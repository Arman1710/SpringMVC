package epam.news.form;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class CommentForm extends ActionForm {
    private static Logger log = Logger.getLogger(CommentForm.class.getName());
    private String author;
    private String description;
    private Date dateCreated;
    private int newsId;
    private int commentId;
    private String [] checkboxValue;

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getAuthor() == null || ("".equals(getAuthor()))) {
            errors.add("comAuthor_err",
                    new ActionMessage("error.required.comment.author"));
            log.error("Author field  is empty");
        }

        if (getDescription() == null || ("".equals(getDescription()))) {
            errors.add("comDesc_err",
                    new ActionMessage("error.required.comment.description"));
            log.error("Description field  is empty");
        }
        return errors;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String[] getCheckboxValue() {
        return checkboxValue;
    }

    public void setCheckboxValue(String[] checkboxValue) {
        this.checkboxValue = checkboxValue;
    }
}
