package com.backend.BlogData;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;

import com.backend.BlogData.model.Comment;
import com.backend.BlogData.model.LightPost;
import com.backend.BlogData.model.Post;
import com.backend.BlogData.model.PostAggregate;
import com.backend.BlogData.model.Tag;
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

          logger.info("Affichage de tous les noms de posts avec projection par Aggregation");
          List<String> allNames = postRepository.findAllName();
          allNames.forEach(logger::info);

          logger.info("Affichage du nombre de posts par date");
          List<PostAggregate> postAggregates = postRepository.groupByDate();
          postAggregates.stream().forEach((post) -> logger.info(post.getDate() + " : " + post.getNames().size()));

          // Ajout d'un post
          Post newP = new Post();
          newP.setName("THE first blog post");
          newP.setDate(new Date());
          newP.setContent("A new blog post, amazing !!!!");

          // postRepository.insert(newP);

          // Ajout de plusieurs posts
          Post newP1 = new Post();
          newP1.setName("Welcome on board!");
          newP1.setDate(new Date());
          newP1.setContent("My blog is really useful !");

          Post newP2 = new Post();
          newP2.setName("See you soon");
          newP2.setDate(new Date());
          newP2.setContent("I will be back soon - going on holidays!");

          postRepository.insert(List.of(newP1, newP2));

          // Ajout d'un post avec un tag
          Tag springTag = new Tag();
          springTag.setName("Spring Framework");
          springTag.setSlug("spring-framework");
          springTag.setDescription("Spring is the most popular Java Framework in the world.");

          Post newPost = new Post();
          newPost.setName("Spring Framework Presentation");
          newPost.setDate(new Date());
          newPost.setContent("Let me introduce you to the awesome Spring Framework!");
          newPost.setTag(springTag);

          postRepository.insert(newPost);

          // Mise à jour d'un post
          String newName = newP.getName() + " [updated]";
          newP.setName(newName);

          postRepository.save(newP); // mise à jour avec la méthode save

          // Creation d'un commentaire
          Comment newComment = new Comment();
          newComment.setPseudo("your fan");
          newComment.setContent("This blog is amazing!");

          newP.getComments().add(newComment);

          postRepository.save(newP);

          postRepository.delete(newP); // suppression du post

     }

}




