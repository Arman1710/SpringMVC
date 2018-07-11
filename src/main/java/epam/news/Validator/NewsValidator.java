package epam.news.Validator;

import epam.news.model.dto.NewsDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class NewsValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return NewsDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.required.title");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "brief", "error.required.brief");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "error.required.content");


    }
}
