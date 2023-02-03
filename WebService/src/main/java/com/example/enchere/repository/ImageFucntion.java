package com.example.enchere.repository;

import com.example.enchere.ModelClient.Image;
import org.springframework.data.mongodb.repository.Aggregation;

import java.util.List;

public interface ImageFucntion  {
    @Aggregation(pipeline = {
            "{'$match': {'idenchere':  ?0}}"
    })
    List<Image> findAllImageByEnchere(int idenchere);
}
