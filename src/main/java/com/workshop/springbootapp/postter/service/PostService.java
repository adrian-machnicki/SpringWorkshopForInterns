package com.workshop.springbootapp.postter.service;

import com.workshop.springbootapp.postter.exception.PostNotFoundException;
import com.workshop.springbootapp.postter.exception.PostValidationException;
import com.workshop.springbootapp.postter.model.PostModel;
import com.workshop.springbootapp.postter.repository.PostRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<PostModel> getAll() {
        return repository.findAll();
    }

    public PostModel get(long id) {
        return repository.findById(id)
            .orElseThrow(PostNotFoundException::new);
    }

    public PostModel create(String title, String content) {
        if (repository.findByTitle(title).isPresent()) {
            throw new PostValidationException("Post title not unique");
        }

        var post = new PostModel(title, content);
        return repository.save(post);
    }
}
