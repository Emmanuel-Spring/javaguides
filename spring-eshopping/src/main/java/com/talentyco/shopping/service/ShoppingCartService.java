package com.talentyco.shopping.service;

import com.talentyco.shopping.domain.Article;
import com.talentyco.shopping.domain.CardItem;
import com.talentyco.shopping.domain.ShoppingCart;
import com.talentyco.shopping.domain.User;

public interface ShoppingCartService {

    ShoppingCart getShoppingCart(User user);

    int getItemsNumber(User user);

    CardItem findCartItemById(Long cartItemId);

    CardItem addArticleToShoppingCart(Article article, User user, int qty, String size);

    void clearShoppingCart(User user);

    void updateCartItem(CardItem cardItem, Integer qty);

    void  removeCartItem(CardItem cardItem);

}
