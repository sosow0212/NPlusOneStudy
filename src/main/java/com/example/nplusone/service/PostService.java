package com.example.nplusone.service;

import com.example.nplusone.domain.Member;
import com.example.nplusone.domain.Post;
import com.example.nplusone.dto.post.PostSaveRequestDto;
import com.example.nplusone.dto.post.PostSimpleResponseDto;
import com.example.nplusone.repository.MemberRepository;
import com.example.nplusone.repository.PostRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void savePost(PostSaveRequestDto req) {
        Member member = memberRepository.findByName(req.getWriter())
                .orElseThrow(IllegalArgumentException::new);
        Post post = new Post(req, member);
        postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public List<PostSimpleResponseDto> readAllPosts() {
        return postRepository.findAll().stream()
                .map(post -> new PostSimpleResponseDto().toDto(post))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostSimpleResponseDto readPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("nope"));
        return new PostSimpleResponseDto().toDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostSimpleResponseDto> readMyPosts(String writer) {
        Member member = memberRepository.findByName(writer)
                .orElseThrow(IllegalArgumentException::new);

        return postRepository.findAllByWriter(member).stream()
                .map(post -> PostSimpleResponseDto.toDto(post))
                .collect(Collectors.toList());
    }
}
