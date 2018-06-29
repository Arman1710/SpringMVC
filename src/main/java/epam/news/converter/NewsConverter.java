package epam.news.converter;

import epam.news.form.NewsForm;
import epam.news.model.dto.NewsDTO;
import epam.news.model.entity.News;

public interface NewsConverter {

    NewsDTO formToDTO(NewsForm newsForm);

    News DTOToEntity(NewsDTO newsDTO);

    NewsDTO entityToDTO(News news);

    void DTOToForm(NewsDTO newsDTO, NewsForm newsForm);
}
