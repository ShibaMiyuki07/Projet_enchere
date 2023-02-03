package com.example.enchere.repository;

import com.example.enchere.ModelClient.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, Integer>, ImageFucntion {
}

