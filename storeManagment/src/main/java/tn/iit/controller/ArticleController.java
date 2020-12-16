package tn.iit.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import tn.iit.dto.ArticleDTO;
import tn.iit.entity.Article;
import tn.iit.exception.ArticleNotFoundException;
import tn.iit.mapper.ArticleMapper;
import tn.iit.service.ArticleService;

@RestController
@RequestMapping("/api")
public class ArticleController {
    
    @Autowired
    private ArticleService articleService;
    
    // Get all articles GET /api/articles
    @GetMapping(value="/articles")
    List<Article> getAll(){
        return articleService.getAllArticles();
    }
    
    // Get single article by ID  GET /api/articles/{id}
    @GetMapping(value="/articles/{id}")
    ResponseEntity<Article> getById(@PathVariable("id") int id) {
        Article art = articleService.findById(id)
                                    .orElseThrow(()->new ArticleNotFoundException("No Article with ID : "+id));
        return ResponseEntity.ok().body(art);
    }
    
    // Create new article POST /api/articles
    @PostMapping(value="/articles")
    ResponseEntity<?> createArticle(@RequestBody ArticleDTO inart) {
        Article art      = ArticleMapper.DtoToEntity(inart);
        Article addedart = articleService.save(art);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                        .path("/{id}")
                                        .buildAndExpand(addedart.getId())
                                        .toUri();
        return ResponseEntity.created(location).build();
    }
    
    
    // Update article details PUT /api/article/{id}
    @PutMapping(value="/articles/{id}")
    ResponseEntity<Article> updateArticle(@PathVariable("id") int id,  @RequestBody ArticleDTO inart) {
        Article art = articleService.findById(id)
                                    .orElseThrow(()->new ArticleNotFoundException("No Article with ID : "+id));
        
        Article newart = ArticleMapper.DtoToEntity(inart);
        newart.setId(art.getId());
        articleService.save(newart);
        return ResponseEntity.ok().body(newart);    
    }
    
    
    // Delete article by ID DELETE /api/articles/{id}
    @DeleteMapping(value="/articles/{id}")
    ResponseEntity deleteArticle( @PathVariable("id") int id) {
        Article art = articleService.findById(id)
                                    .orElseThrow(()->new ArticleNotFoundException("No Article with ID : "+id));
        articleService.delete(art.getId());
        return ResponseEntity.ok().body("Article with ID : "+id+" deleted with success!");  
    }
}
