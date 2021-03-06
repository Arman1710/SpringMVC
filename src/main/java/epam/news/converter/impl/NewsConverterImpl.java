package epam.news.converter.impl;

import epam.news.converter.NewsConverter;
import epam.news.form.CommentForm;
import epam.news.form.NewsForm;
import epam.news.model.dto.CommentDTO;
import epam.news.model.dto.NewsDTO;
import epam.news.model.entity.Comment;
import epam.news.model.entity.News;
import org.springframework.stereotype.Component;

@Component
public class NewsConverterImpl implements NewsConverter {
    private CommentConverterImpl commentImpl = new CommentConverterImpl();

    @Override
    public NewsDTO formToDTO(NewsForm newsForm) {
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setContent(newsForm.getContent());
        newsDTO.setBrief(newsForm.getBrief());
        newsDTO.setNewsId(newsForm.getNewsId());
        newsDTO.setTitle(newsForm.getTitle());
        for (CommentForm commentForm : newsForm.getCommentList()) {
            newsDTO.getCommentList().add(commentImpl.formToDTO(commentForm));
        }
        return newsDTO;
    }

    @Override
    public News DTOToEntity(NewsDTO newsDTO) {
        News news = new News();
        news.setContent(newsDTO.getContent());
        news.setBrief(newsDTO.getBrief());
        news.setNewsId(newsDTO.getNewsId());
        news.setTitle(newsDTO.getTitle());
        for (CommentDTO commentDTO : newsDTO.getCommentList()) {
            news.getCommentList().add(commentImpl.DTOToEntity(commentDTO));
        }
        return news;
    }

    @Override
    public NewsDTO entityToDTO(News news) {
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setBrief(news.getBrief());
        newsDTO.setContent(news.getContent());
        newsDTO.setNewsId(news.getNewsId());
        newsDTO.setTitle(news.getTitle());
        for (Comment comment : news.getCommentList()) {
            CommentDTO commentDTO = commentImpl.entityToDTO(comment);
            newsDTO.getCommentList().add(commentDTO);
        }
        return newsDTO;
    }

    @Override
    public void DTOToForm(NewsDTO newsDTO, NewsForm newsForm) {
        newsForm.setContent(newsDTO.getContent());
        newsForm.setBrief(newsDTO.getBrief());
        newsForm.setNewsId(newsDTO.getNewsId());
        newsForm.setTitle(newsDTO.getTitle());
        for (CommentDTO commentDTO : newsDTO.getCommentList()) {
            CommentForm commentForm = commentImpl.DTOToForm(commentDTO);
            newsForm.getCommentList().add(commentForm);
        }
    }
}
