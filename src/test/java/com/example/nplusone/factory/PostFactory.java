package com.example.nplusone.factory;

import static com.example.nplusone.factory.MemberFactory.createMember;

import com.example.nplusone.domain.Member;
import com.example.nplusone.domain.Post;
import com.example.nplusone.dto.post.PostSaveRequestDto;

public class PostFactory {
    public static Post createPost() {
        return new Post(new PostSaveRequestDto("title", "content", "writer"), createMember());
    }

    public static Post createPost(String title, Member member) {
        return new Post(new PostSaveRequestDto(title, "content", "writer"), member);
    }

    public static Post createPost(Member member) {
        return new Post(new PostSaveRequestDto("title", "content", "writer"), member);
    }
}
