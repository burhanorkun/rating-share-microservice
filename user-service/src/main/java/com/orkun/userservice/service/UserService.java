package com.orkun.userservice.service;

import com.orkun.rating.client.RatingService;
import com.orkun.rating.client.dto.Rating;
import com.orkun.rating.client.dto.RatingRequest;
import com.orkun.rating.client.dto.RatingResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Service
public class UserService {

    private WebClient webClient;

    @PostConstruct
    public void init(){
        this.webClient = WebClient.builder()
                                .baseUrl("http://localhost:8080/rating-service")
                                .build();
    }

    public Mono<RatingResponse> rateProduct(int userId, int productId, int rating){
        RatingRequest ratingRequest = RatingRequest.newRequest(req -> {
            req.setUserId(userId);
            req.setProductId(productId);
            req.setRating(Rating.getRating(rating));
        });
        return RatingService.client(this.webClient)
                            .rate(ratingRequest);
    }
}
