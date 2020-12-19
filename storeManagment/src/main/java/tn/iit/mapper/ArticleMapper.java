package tn.iit.mapper;


import java.util.ArrayList;
import java.util.Collection;

import tn.iit.dto.ArticleDTO;
import tn.iit.entity.Article;

public class ArticleMapper {
	public static Article DtoToEntity(ArticleDTO art) {
		Article article = new Article();
		article.setId(art.getId());
		article.setDescription(art.getDescription());
        return article ;
	}
	
	   public static ArticleDTO EntityToDto(Article art) {
		   ArticleDTO articleDto = new ArticleDTO();
		   articleDto.setId(art.getId());
		   articleDto.setDescription(art.getDescription());
           return articleDto;                            
       }
	   
	   public static Collection<ArticleDTO> EntityToDtos(Collection<Article> arts) {
		   Collection<ArticleDTO> articleDtos = new ArrayList<>();
		   arts.forEach(art -> {
			   articleDtos.add(EntityToDto(art));
		   });
           return articleDtos;                            
       }
	   
}
