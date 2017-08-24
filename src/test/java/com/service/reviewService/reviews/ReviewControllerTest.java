package com.service.reviewService.reviews;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void receivesMovieReviewPostAndReturns200IfFound() throws Exception {
        mvc.perform(post("/reviews").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void createsReturnsCreateReview () throws Exception {
        mvc.perform(
                post("/reviews")
                        .content("{\n"+
                                "  \"title\": \"Gremlins\",\n"+
                                "  \"year\": 1984,\n"+
                                "  \"reviewer\": \"Hercules Mulligan\",\n"+
                                "  \"comment\": \"I loved it!\",\n"+
                                "  \"starRating\": 3.0\n"+
                                "}")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
        )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.movieID", Matchers.is(358)));
    }

}

