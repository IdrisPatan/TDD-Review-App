package com.service.reviewService.reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
final class ReviewController {
//    @RequestMapping(value = "/reviews", method = RequestMethod.POST)
//    public String postReview() {
//        return "hey";
//
//    }

    @PostMapping
    ResponseEntity<Review> create(@RequestBody final Review review){
        if (null == review) {
            return ResponseEntity.badRequest().build();
        }
        review.setMovieId(358L);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }
}
