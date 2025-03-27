package com.backend.BlogData.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.BlogData.model.LightPost;
import com.backend.BlogData.model.Post;
import com.backend.BlogData.model.PostAggregate;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    public List<Post> findByName(String name);
    // Projection par interface
    public List<LightPost> findByOrderByDateDesc();

    // Alternative à la Projection par interface, utilisation de requête native
    @Query(value="{}", fields="{_id : 1, name : 1}", sort = "{ date : -1 }")
     List<Post> findIdAndNameExcludeOthers();

     // Utilisation de l'annotation @Aggregation
     @Aggregation("{ '$project': { '_id' : '$name' } }")
     public List<String> findAllName();

     //Regroupement par date
     @Aggregation("{ $group: { _id : $date, names : { $addToSet : $name } } }")
     public List<PostAggregate> groupByDate();
}


