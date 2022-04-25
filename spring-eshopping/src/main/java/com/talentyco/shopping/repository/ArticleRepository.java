package com.talentyco.shopping.repository;

import com.talentyco.shopping.domain.Article;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article> {

    @EntityGraph(attributePaths = { "sizes", "categories", "brands" })
    List<Article> findAllEagerBy();

    @EntityGraph(attributePaths = { "sizes", "categories", "brands" })
    Optional<String> findAllSizes(Long id);

    @Query("SELECT DISTINCT s.value FROM Size s")
    List<String> findAllSizes();

    @Query("SELECT DISTINCT c.name FROM Category c")
    List<String> findAllCategories();

    @Query("SELECT DISTINCT b.name FROM Brand b")
    List<String> findAllBrands();
}
