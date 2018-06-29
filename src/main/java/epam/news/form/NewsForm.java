package epam.news.form;

import epam.news.model.entity.News;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class NewsForm extends ActionForm {
    private static Logger log = Logger.getLogger(NewsForm.class);
    private List<News> newsList = new ArrayList<>();
    private String title;
    private String brief;
    private String content;
    private String error;
    private int newsId;
    private List<CommentForm> commentList = new ArrayList<>();
    private String [] checkboxValue;

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        if (StringUtils.isEmpty(getTitle())) {
            errors.add("title_err",
                    new ActionMessage("error.required.title"));
            log.error("title is empty");
        }

        if (StringUtils.isEmpty(getBrief())) {
            errors.add("brief_err",
                    new ActionMessage("error.required.brief"));
            log.error("brief is empty");
        }

        if (StringUtils.isEmpty(getContent())) {
            errors.add("content_err",
                    new ActionMessage("error.required.content"));
            log.error("content  is empty");
        }
        return errors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public List<CommentForm> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentForm> commentList) {
        this.commentList = commentList;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public String[] getCheckboxValue() {
        return checkboxValue;
    }

    public void setCheckboxValue(String[] checkboxValue) {
        this.checkboxValue = checkboxValue;
    }
}

