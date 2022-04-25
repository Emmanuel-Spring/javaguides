package com.talentyco.shopping.service.impl;

import com.talentyco.shopping.domain.Article;
import com.talentyco.shopping.domain.CardItem;
import com.talentyco.shopping.domain.ShoppingCart;
import com.talentyco.shopping.domain.User;
import com.talentyco.shopping.repository.CartItemRepository;
import com.talentyco.shopping.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public ShoppingCart getShoppingCart(User user) {
        return new ShoppingCart(cartItemRepository.findAllByUserAndOrderIsNull(user));
    }

    @Override
    @Cacheable("itemcount")
    public int getItemsNumber(User user) {
        return cartItemRepository.countDistinctByUserAndOrderIsNull(user);
    }

    @Override
    public CardItem findCartItemById(Long cartItemId) {
        Optional<CardItem> optionalCardItem = cartItemRepository.findById(cartItemId);
        return optionalCardItem.get();
    }

    @Override
    @CacheEvict(value = "itemcount", allEntries = true)
    public CardItem addArticleToShoppingCart(Article article, User user, int qty, String size) {
        ShoppingCart shoppingCart = this.getShoppingCart(user);
        CardItem cardItem = shoppingCart.findCartItemByArticleAndSize(article.getId(), size);
        if (cardItem != null && cardItem.hasSameSizeThan(size)) {
            cardItem.addQuantity(qty);
            cardItem.setSize(size);
            cardItem = cartItemRepository.save(cardItem);
        } else {
            cardItem = new CardItem();
            cardItem.setUser(user);
            cardItem.setArticle(article);
            cardItem.setQty(qty);
            cardItem.setSize(size);
            cardItem = cartItemRepository.save(cardItem);
        }
        return cardItem;
    }

    @Override
    @CacheEvict(value = "itemcount", allEntries = true)
    public void clearShoppingCart(User user) {
        cartItemRepository.deleteAllByUserAndOrderIsNull(user);
    }

    @Override
    @CacheEvict(value = "itemcount", allEntries = true)
    public void updateCartItem(CardItem cardItem, Integer qty) {
        if (qty == null || qty <= 0) {
            this.removeCartItem(cardItem);
        } else if (cardItem.getArticle().hasStock(qty)) {
            cardItem.setQty(qty);
            cartItemRepository.save(cardItem);
        }
    }

    @Override
    @CacheEvict(value = "itemcount", allEntries = true)
    public void removeCartItem(CardItem cardItem) {
        cartItemRepository.deleteById(cardItem.getId());
    }
}
