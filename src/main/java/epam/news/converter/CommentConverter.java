package epam.news.converter;

import epam.news.form.CommentForm;
import epam.news.model.entity.Comment;
import epam.news.model.dto.CommentDTO;

public interface CommentConverter {

    CommentDTO formToDTO(CommentForm commentForm);

    Comment DTOToEntity(CommentDTO commentDTO);

    CommentDTO entityToDTO(Comment comment);

    CommentForm DTOToForm(CommentDTO commentDTO);
}
