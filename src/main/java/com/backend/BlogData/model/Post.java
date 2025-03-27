package com.backend.BlogData.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class Post {

      @Id
      private String id;
      @Indexed(unique = true)
      private String name;
      private String content;
      private Date date;
      private Tag tag;
      private List<Comment> comments = new ArrayList<>();

      // getters and setters
        public String getId() {
                return id;
        }

    // getContent
    public String getContent() {
        return content;
    }

    // getName
    public String getName() {
        return name;
    }
    // getDate
    public Date getDate() {
        return date;
    }

    public void setName(String string) {
        this.name = string;
    }

    public void setContent(String string) {
        this.content = string;
    }

    public void setDate(Date date2) {
        this.date = date2;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


}