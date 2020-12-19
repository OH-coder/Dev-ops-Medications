package tn.iit.service;

import java.util.Collection;
import tn.iit.dto.ArticleDTO;

public interface Iarticle {
	Collection<ArticleDTO> getAllArticles();
	ArticleDTO findById(int id);
    ArticleDTO save(ArticleDTO art);
    ArticleDTO update(ArticleDTO art);
    void delete(int id);
}
