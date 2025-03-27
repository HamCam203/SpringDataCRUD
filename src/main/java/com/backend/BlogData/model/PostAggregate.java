package com.backend.BlogData.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class PostAggregate {

     private @Id Date date;
     private List<String> names;

     public Date getDate() {
          return date;
     }
     public List<String> getNames() {
          return names;
     }
}