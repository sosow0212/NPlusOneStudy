package com.example.nplusone.repository;

import com.example.nplusone.domain.Member;
import com.example.nplusone.domain.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByWriter(Member writer);
}
