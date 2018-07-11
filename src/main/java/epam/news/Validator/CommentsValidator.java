package epam.news.Validator;

import epam.news.model.dto.CommentDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CommentsValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return CommentDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.required.comment");
    }
}
