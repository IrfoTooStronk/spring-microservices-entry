package com.example.ratingsdataservice.resources;

import com.example.ratingsdataservice.models.Rating;
import com.example.ratingsdataservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataResource {

    @Autowired
    private UserRating userRating;

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId, 4);
    }

    @RequestMapping("/user/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId){

        userRating.initData(userId);

        return userRating;
    }

}
