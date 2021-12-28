package com.irfandogic.moviecatalogservice.resources;

import com.irfandogic.moviecatalogservice.models.CatalogItem;
import com.irfandogic.moviecatalogservice.models.UserRating;
import com.irfandogic.moviecatalogservice.services.MovieInfoService;
import com.irfandogic.moviecatalogservice.services.UserRatingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {



    @Autowired
    MovieInfoService movieInfoService;

    @Autowired
    UserRatingInfoService userRatingInfoService;

//    @Autowired
//    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        //get all rated movie ids
        UserRating ratings = userRatingInfoService.getUserRating(userId);

        return ratings.getUserRating().stream().map(rating -> movieInfoService.getCatalogItem(rating))
                .collect(Collectors.toList());

        //WebClient example
        // if we want to do it fully async, our controller needs to return the mono object and the block method should not be called

//            Movie movie = webClientBuilder.build()
//                    .get()
//                    .uri("http://localhost:8082/movies/" + rating.getMovieId())
//                    .retrieve()
//                    .bodyToMono(Movie.class)
//                    .block();

    }

}
