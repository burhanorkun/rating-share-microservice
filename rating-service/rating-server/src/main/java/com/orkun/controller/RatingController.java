package com.orkun.controller;

import com.orkun.rating.client.dto.RatingRequest;
import com.orkun.rating.client.dto.RatingResponse;
import com.orkun.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rating-service")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/rate")
    public Mono<RatingResponse> rate(@RequestBody RatingRequest ratingRequest){
        return Mono.fromSupplier(() -> this.ratingService.rate(ratingRequest));
    }

}
