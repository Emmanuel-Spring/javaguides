package com.talentyco.shopping.repository;

import com.talentyco.shopping.domain.CardItem;
import com.talentyco.shopping.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartItemRepository extends CrudRepository<CardItem, Long> {

    @EntityGraph(attributePaths = { "article" })
    List<CardItem> findAllByUserAndOrderIsNull(User user);

    void deleteAllByUserAndOrderIsNull(User user);

    int countDistinctByUserAndOrderIsNull(User user);

}
