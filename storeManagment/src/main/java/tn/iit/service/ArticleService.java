package tn.iit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.iit.dao.ArticleRepository;
import tn.iit.entity.Article;

@Service
public class ArticleService implements Iarticle {
    @Autowired
    private ArticleRepository articleRepository;
    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
    @Override
    public Optional<Article> findById(int id) {
        return articleRepository.findById(id);
    }
    @Override
    public Article save(Article art) {
        return articleRepository.save(art);
    }
    @Override
    public void delete(int id) {
        articleRepository.deleteById(id);
    }
}