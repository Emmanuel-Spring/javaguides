package com.talentyco.shopping.service.impl;

import com.talentyco.shopping.domain.*;
import com.talentyco.shopping.repository.ArticleRepository;
import com.talentyco.shopping.repository.CartItemRepository;
import com.talentyco.shopping.repository.OrderRepository;
import com.talentyco.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Override
    @Transactional
    @CacheEvict(value = "itemcount", allEntries = true)
    public synchronized Order createOrder(ShoppingCart shoppingCart, Shipping shipping, Payment payment, User user) {
        Order order = new Order();
        order.setUser(user);
        order.setPayment(payment);
        order.setShipping(shipping);
        order.setOrderTotal(shoppingCart.getGrandTotal());
        shipping.setOrder(order);
        payment.setOrder(order);
        LocalDate today = LocalDate.now();
        LocalDate estimatedDeliveryDate = today.plusDays(5);
        order.setOrderDate(Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        order.setOrderDate(Date.from(estimatedDeliveryDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        order.setOrderStatus("in process");

        order = orderRepository.save(order);

        List<CardItem> cartItems = shoppingCart.getCardItems();
        for (CardItem item : cartItems) {
            Article article = item.getArticle();
            article.decreaseStock(item.getQty());
            articleRepository.save(article);
            item.setOrder(order);
            cartItemRepository.save(item);
        }
        return order;
    }

    @Override
    public Order findOrderWithDetails(Long id) {
        return orderRepository.findEagerById(id);
    }

    public List<Order> findByUser(User user) {
        return orderRepository.findByUser(user);
    }
}