package epam.news.converter.impl;

import epam.news.converter.CommentConverter;
import epam.news.form.CommentForm;
import epam.news.model.dto.CommentDTO;
import epam.news.model.entity.Comment;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CommentConverterImpl implements CommentConverter {

    @Override
    public CommentDTO formToDTO(CommentForm commentForm) {
        return createCommentDTO(commentForm.getAuthor(), commentForm.getDescription(), commentForm.getDateCreated(), commentForm.getNewsId(), commentForm.getCommentId());
    }



    @Override
    public Comment DTOToEntity(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setNewsId(commentDTO.getNewsId());
        comment.setAuthor(commentDTO.getAuthor());
        comment.setDateCreated(commentDTO.getDateCreated());
        comment.setDescription(commentDTO.getDescription());
        comment.setCommentId(commentDTO.getCommentId());
        return comment;
    }

    @Override
    public CommentDTO entityToDTO(Comment comment) {
        return createCommentDTO(comment.getAuthor(), comment.getDescription(), comment.getDateCreated(), comment.getNewsId(), comment.getCommentId());
    }

    @Override
    public CommentForm DTOToForm(CommentDTO commentDTO) {
        CommentForm commentForm = new CommentForm();
        commentForm.setDateCreated(commentDTO.getDateCreated());
        commentForm.setAuthor(commentDTO.getAuthor());
        commentForm.setDescription(commentDTO.getDescription());
        commentForm.setNewsId(commentDTO.getNewsId());
        commentForm.setCommentId(commentDTO.getCommentId());
        return commentForm;
    }

    private CommentDTO createCommentDTO(String author, String description, Date dateCreated, int newsId, int commentId) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setAuthor(author);
        commentDTO.setDescription(description);
        commentDTO.setDateCreated(dateCreated);
        commentDTO.setNewsId(newsId);
        commentDTO.setCommentId(commentId);
        return commentDTO;
    }
}
