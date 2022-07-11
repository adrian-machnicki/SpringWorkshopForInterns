package com.workshop.springbootapp.postter.api.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostRequest {

    @NotBlank
    @Size(min = 3)
    private String title;

    @NotBlank
    @Size(min = 10, max = 160)
    private String content;
}
