package com.talentyco.shopping.domain;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCart {

    private List<CardItem> cardItems;

    public ShoppingCart(List<CardItem> cardItems) {
        this.cardItems = cardItems;
    }


    public BigDecimal getGrandTotal() {
        BigDecimal cartTotal = new BigDecimal(0);
        for (CardItem item : this.cardItems) {
            cartTotal = cartTotal.add(item.getSubtotal());
        }
        return cartTotal;
    }

    public boolean isEmpty() {
        return cardItems.isEmpty();
    }


    public void removeCartItem(CardItem cardItem) {
        cardItems.removeIf(item -> item.getId() == cardItem.getId());
    }

    public void clearItems() {
        cardItems.clear();
    }

    public CardItem findCartItemByArticleAndSize(Long id, String size) {
        for (CardItem item : this.cardItems) {
            if (item.getArticle().getId().equals(id) && item.getSize().equals(size)) {
                return item;
            }
        }
        return null;
    }

    public int getItemAcount() {
        return this.cardItems.size();
    }

    public List<CardItem> getCardItems() {
        return cardItems;
    }

    public void setCardItems(List<CardItem> cardItems) {
        this.cardItems = cardItems;
    }
}
