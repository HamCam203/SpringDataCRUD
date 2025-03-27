package com.backend.BlogData.model;

import java.util.Date;

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


}