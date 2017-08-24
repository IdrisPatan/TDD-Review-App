package com.service.reviewService.reviews;


public class Review {

    private String title, year, reviewer, comment, starRating;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    private Long movieId;

    public Review(String title, String year, String reviewer, String comment, String starRating) {
        this.title = title;
        this.year = year;
        this.reviewer = reviewer;
        this.comment = comment;
        this.starRating = starRating;
    }
}
