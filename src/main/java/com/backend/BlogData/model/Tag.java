package com.backend.BlogData.model;


public class Tag {
     private String name;
     private String slug;
     private String description;
     // getters and setters

        public String getName() {
            return name;
        }

        public String getSlug() {
            return slug;
        }

        public String getDescription() {
            return description;
        }

        public void setName(String string) {
            this.name = string;
        }

        public void setSlug(String string) {
            this.slug = string;
        }

        public void setDescription(String string) {
            this.description = string;
        }
}