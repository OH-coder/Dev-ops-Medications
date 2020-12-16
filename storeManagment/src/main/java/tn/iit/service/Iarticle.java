package tn.iit.service;

import java.util.List;
import java.util.Optional;

import tn.iit.entity.Article;

public interface Iarticle {
	List<Article> getAllArticles();
    Optional<Article> findById(int id);
    Article save(Article prd);
    void delete(int id);
}
