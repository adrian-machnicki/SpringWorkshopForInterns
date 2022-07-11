package com.workshop.springbootapp.postter.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import com.workshop.springbootapp.postter.model.PostModel;
import com.workshop.springbootapp.postter.service.PostService;
import com.workshop.springbootapp.postter.exception.PostValidationException;
import com.workshop.springbootapp.postter.api.request.CreatePostRequest;
import java.util.List;
import javax.validation.Valid;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public PostModel get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<PostModel> getAll() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public PostModel create(@Valid @RequestBody CreatePostRequest request, Errors errors) {
        if (errors.hasErrors()) {
            System.out.println("Invalid create request: " + errors.getAllErrors());
            throw new PostValidationException(errors.getAllErrors().toString());
        }

        return service.create(request.getTitle(), request.getContent());
    }
}
