package com.workshop.springbootapp.postter.api;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.workshop.springbootapp.TestBase;
import com.workshop.springbootapp.postter.api.request.CreatePostRequest;
import com.workshop.springbootapp.postter.model.PostModel;
import com.workshop.springbootapp.postter.repository.PostRepository;
import com.workshop.springbootapp.postter.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

class PostControllerTest extends TestBase {

    private static final String CREATE_POST_PATH = "/api/posts";
    private static final String GET_POST_PATH = "/api/posts/";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    PostRepository repository;

    @Test
    void shouldCreatePost() throws Exception {
        // given post creation request
        var json = new CreatePostRequest("This is my new post 1", "Totally new discovery...");
        var req = post(CREATE_POST_PATH)
            .contentType(APPLICATION_JSON)
            .content(mapper.writeValueAsString(json));

        // when calling api
        // then the response is correct
        mvc.perform(req)
            .andExpect(status().isCreated())
            .andExpect(content().contentType(APPLICATION_JSON))
            .andExpect(jsonPath("$.id").isNumber())
            .andExpect(jsonPath("$.title", is(json.getTitle())));

        // then the post exists in db
        assertNotNull(repository.findByTitle(json.getTitle()));
    }

    @Test
    void shouldReturnBadRequestWhenPostIncorrect() throws Exception {
        // given invalid post creation request
        var json = new CreatePostRequest();
        var req = post(CREATE_POST_PATH)
            .contentType(APPLICATION_JSON)
            .content(mapper.writeValueAsString(json));

        // when
        // then bad request
        mvc.perform(req)
            .andExpect(status().isBadRequest())
            .andExpect(content().contentType(APPLICATION_JSON))
            .andExpect(jsonPath("$.error", containsString("title")))
            .andExpect(jsonPath("$.error", containsString("content")));
    }

    @Test
    void shouldGetPost() throws Exception {
        // given a post exists
        var post = new PostModel("This is post title", "This is post content");
        post = repository.save(post);
        assertNotNull(post.getId());

        var req = get(GET_POST_PATH + post.getId())
            .contentType(APPLICATION_JSON);

        // when
        // then
        mvc.perform(req)
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON))
            .andExpect(jsonPath("$.id", equalTo(post.getId().intValue())))
            .andExpect(jsonPath("$.title", is(post.getTitle())));
    }

}