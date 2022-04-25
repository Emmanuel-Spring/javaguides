package com.talentyco.shopping.controller;

import com.talentyco.shopping.domain.Article;
import com.talentyco.shopping.form.ArticleFileForm;
import com.talentyco.shopping.service.ArticleService;
import com.talentyco.shopping.type.SortFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

@Controller
public class StoreController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/store")
    public String store(@ModelAttribute("filters")ArticleFileForm fileForm, Model model) {
        Integer page = fileForm.getPage();
        int pageNumber = (page == null || page <= 0) ? 0 : page - 1;
        SortFilter sortFilter = new SortFilter(fileForm.getSort());
        Page<Article> pageResult = articleService.findArticleByCriteria(PageRequest.of(pageNumber,9, sortFilter.getSortType()),
                fileForm.getPricelow(), fileForm.getPricehigh(),
                fileForm.getSize(), fileForm.getCategory(), fileForm.getBrand(), fileForm.getSearch());

        model.addAttribute("allCategories", articleService.getAllCategories());
        model.addAttribute("allBrands", articleService.getAllBrands());
        model.addAttribute("allSizes", articleService.getAllSizes());
        model.addAttribute("articles", pageResult.getContent());
        model.addAttribute("totalitems", pageResult.getTotalElements());
        model.addAttribute("itemsperpage", 9);
        return "store";
    }

    @RequestMapping("/article-detail")
    public String articleDetail(@PathParam("id") Long id, Model model) {
        Article article = articleService.findArticleById(id);
        model.addAttribute("article", article);
        model.addAttribute("notEnoughStock", model.asMap().get("notEnoughStock"));
        model.addAttribute("addArticleSuccess", model.asMap().get("addArticlesSuccess"));
        return "articleDetail";
    }
}