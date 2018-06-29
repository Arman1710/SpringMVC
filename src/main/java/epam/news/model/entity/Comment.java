package epam.news.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "comments")
public class Comment extends Basic {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column (name = "commentId", nullable = false, updatable = false)
    private int commentId;

    @Column (nullable = false)
    private String author;

    @Column (nullable = false)
    private String description;

    @Column (nullable = false)
    private Date dateCreated;

    @Column (nullable = false)
    private int newsId;

    @ManyToOne
    @JoinColumn (name = "newsId", insertable = false, updatable = false)
    private News news;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
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


}
