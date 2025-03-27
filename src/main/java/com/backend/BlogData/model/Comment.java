package com.backend.BlogData.model;

public class Comment {

     private String pseudo;
     private String content;
     // getters et setters

        public String getPseudo() {
            return pseudo;
        }

        public String getContent() {
            return content;
        }

        public void setPseudo(String string) {
            this.pseudo = string;
        }

        public void setContent(String string) {
            this.content = string;
        }
}