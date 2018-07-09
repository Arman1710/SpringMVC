package epam.news.services;

import epam.news.converter.impl.CommentConverterImpl;
import epam.news.converter.impl.NewsConverterImpl;
import epam.news.converter.impl.UserConverterImpl;
import epam.news.dao.impl.NewsDAOImpl;
import epam.news.dao.impl.UserDAOImpl;
import epam.news.model.dto.CommentDTO;
import epam.news.model.dto.NewsDTO;
import epam.news.model.dto.UserDTO;
import epam.news.model.entity.Comment;
import epam.news.model.entity.News;
import epam.news.model.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsDAOImpl newsDAOImpl;

    @Autowired
    private NewsConverterImpl newsConverterImpl;

    @Autowired
    private CommentConverterImpl commentImpl;

    private final static Logger LOGGER = Logger.getLogger(NewsService.class);


    public List<News> showAllNews() {
        LOGGER.trace("show all news");
        return newsDAOImpl.read();

    }

    public NewsDTO selectedNews(Long newsId) {
        LOGGER.info("selected news :" + newsId);
        NewsDTO newsDTO = newsConverterImpl.entityToDTO(newsDAOImpl.findById(newsId));
        LOGGER.trace("Show selected news");
        LOGGER.info("News :" + newsId + " is selected");
        return newsDTO;
    }


    public void editNews(NewsDTO newsDTO, Long newsId) {
        LOGGER.info("Updating news :" + newsId);
        News news = newsDAOImpl.findById(newsId);
        news.setContent(newsDTO.getContent());
        news.setBrief(newsDTO.getBrief());
        news.setTitle(newsDTO.getTitle());
        newsDAOImpl.update(news);
        LOGGER.info("News :" + newsId + " is updated");
    }

    public void addNews(NewsDTO newsDTO) {
        News news = newsConverterImpl.DTOToEntity(newsDTO);
        newsDAOImpl.create(news);
        LOGGER.info("News :" + news.getTitle() + "is created");
    }

    public void addComment(Long newsId, CommentDTO commentDTO) {
        LOGGER.info("Creating comment :" + newsId);
        commentDTO.setDateCreated(new Date());
        Comment comment = commentImpl.DTOToEntity(commentDTO);
        News news = newsDAOImpl.findById(newsId);
        comment.setNewsId(news.getNewsId());
        news.getCommentList().add(comment);
        newsDAOImpl.update(news);
        LOGGER.info("Comments :" + news + "is created");
    }


    public void deleteNews(Long newsId) {
        LOGGER.info("delete news :" + newsId);

        newsDAOImpl.delete(newsDAOImpl.findById(newsId));

        LOGGER.info("News :" + newsId + " is deleted");
    }

    public void deleteComment(final Long newsId, final Long commentId) {
        LOGGER.info("delete news :" + commentId);
        final News news = newsDAOImpl.findById(newsId);
        final Iterator<Comment> itr = news.getCommentList().iterator();

        while (itr.hasNext()) {
            Comment comment = itr.next();
            if (comment.getCommentId() == commentId) {
                itr.remove();
            }
        }
        newsDAOImpl.update(news);
        LOGGER.info("News :" + commentId + " is deleted");
    }

}
