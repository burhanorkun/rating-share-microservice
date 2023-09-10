package com.orkun.rating.client;

import com.orkun.rating.client.dto.RatingRequest;
import com.orkun.rating.client.dto.RatingResponse;
import reactor.core.publisher.Mono;

public interface RatingClient {

    Mono<RatingResponse> rate(RatingRequest ratingRequest);

}
