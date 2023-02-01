package com.example.nplusone.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostSaveRequestDto {
    private String title;
    private String content;
    private String writer;
}
