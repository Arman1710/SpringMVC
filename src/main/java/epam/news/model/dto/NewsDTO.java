package epam.news.model.dto;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewsDTO {
    private List<NewsDTO> newsList = new ArrayList<>();
    private String title;
    private String brief;
    private String content;
    private String error;
    private int newsId;
    private List<CommentDTO> commentList = new ArrayList<>();
    private String [] checkboxValue;

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


    public String[] getCheckboxValue() {
        return checkboxValue;
    }

    public void setCheckboxValue(String[] checkboxValue) {
        this.checkboxValue = checkboxValue;
    }

    public List<NewsDTO> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<NewsDTO> newsList) {
        this.newsList = newsList;
    }

    public List<CommentDTO> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentDTO> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return "NewsDTO{" +
                "newsList=" + newsList +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                ", error='" + error + '\'' +
                ", newsId=" + newsId +
                ", commentList=" + commentList +
                ", checkboxValue=" + (checkboxValue == null ? null : Arrays.asList(checkboxValue)) +
                '}';
    }
}

