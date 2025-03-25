package com.backend.BlogData.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.backend.BlogData.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}