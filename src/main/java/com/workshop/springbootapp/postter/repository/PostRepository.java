package com.workshop.springbootapp.postter.repository;

import com.workshop.springbootapp.postter.model.PostModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostModel, Long> {

    Optional<PostModel> findByTitle(String title);

}
