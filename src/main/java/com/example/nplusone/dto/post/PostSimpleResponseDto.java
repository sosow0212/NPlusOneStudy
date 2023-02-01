package com.example.nplusone.dto.post;

import com.example.nplusone.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostSimpleResponseDto {
    private Long post_id;
    private String title;
    private String content;
    private String writer;

    public static PostSimpleResponseDto toDto(Post post) {
        return new PostSimpleResponseDto(post.getId(), post.getTitle(), post.getContent(), post.getWriter().getName());
    }
}
