package tn.iit.mapper;


import tn.iit.dto.ArticleDTO;
import tn.iit.entity.Article;

public class ArticleMapper {
	public static Article DtoToEntity(ArticleDTO art) {
		Article article = new Article();
		article.setDescription(art.getDescription());
        return article ;
	}
	
	   public static ArticleDTO EntityToDto(Article art) {
		   ArticleDTO articleDto = new ArticleDTO();
		   articleDto.setDescription(art.getDescription());
           return articleDto;                            
       }
}
