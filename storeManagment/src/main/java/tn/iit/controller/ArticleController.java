package tn.iit.controller;

import java.net.URI;
import java.util.Collection;

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
import tn.iit.service.ArticleService;

@RestController
@RequestMapping("/api")
public class ArticleController {
    
    @Autowired
    private ArticleService articleService;
    

    @GetMapping(value="/articles")
    Collection<ArticleDTO> getAll(){
        return articleService.getAllArticles();
    }
    

    @GetMapping(value="/articles/{id}")
    ResponseEntity<ArticleDTO> getById(@PathVariable("id") int id) {
        ArticleDTO art = articleService.findById(id);                                 
        return ResponseEntity.ok().body(art);
    }
    

    @PostMapping(value="/articles")
    ResponseEntity<?> createArticle(@RequestBody ArticleDTO inart) {
        ArticleDTO addedart = articleService.save(inart);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                        .path("/{id}")
                                        .buildAndExpand(addedart.getId())
                                        .toUri();
        return ResponseEntity.created(location).build();
    }
    
    
    @PutMapping(value="/articles/{id}")
    ResponseEntity<ArticleDTO> updateArticle(@PathVariable("id") int id,  @RequestBody ArticleDTO inart) {
    	inart.setId(id);
    	ArticleDTO resultdos = articleService.update(inart);
        return ResponseEntity.ok().body(resultdos);    
    }
    
    
    @DeleteMapping(value="/articles/{id}")
    ResponseEntity deleteArticle( @PathVariable("id") int id) {
        articleService.delete(id);
        return ResponseEntity.ok().body("Article with ID : "+id+" deleted with success!");  
    }
}
