package com.workshop.springbootapp.postter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Long id;

    @Column(unique = true)
    @Size(min = 3)
    private String title;

    @Size(min = 10, max = 160)
    private String content;

    public PostModel(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "[" + id + "] title='" + title + '\'' + ", content='" + content;
    }
}
