package com.backend.BlogData;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.backend.BlogData.model.LightPost;
import com.backend.BlogData.model.Post;
import com.backend.BlogData.repository.PostRepository;

@SpringBootApplication
public class BlogDataApplication implements CommandLineRunner {

     private final Logger logger = LoggerFactory.getLogger(BlogDataApplication.class);

     @Autowired
     private PostRepository postRepository;

     public static void main(String[] args) {
          SpringApplication.run(BlogDataApplication.class, args);
     }

     @Override
     public void run(String... args) throws Exception {

          logger.info("Affichage de tous les posts");
          List<Post> allPosts = postRepository.findAll();
          allPosts.stream().forEach((post) -> logger.info(post.getName()));

          logger.info("Affichage de tous les posts triés par date");
          List<LightPost> allLightPosts = postRepository.findByOrderByDateDesc();
          allLightPosts.stream().forEach((post) -> logger.info(post.getName()));

          logger.info("Affichage de tous les posts avec projection par requête native");
          List<Post> allPostsIdAndName = postRepository.findIdAndNameExcludeOthers();
          allPostsIdAndName.stream().forEach((post) -> logger.info(post.getName()));

     }

}