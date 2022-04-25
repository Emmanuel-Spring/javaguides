package com.talentyco.shopping.repository;

import com.talentyco.shopping.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    @EntityGraph(value = "UserComplete", type = EntityGraph.EntityGraphType.FETCH)
    User findByUsername(String username);

    User findByEmail(String email);

}
