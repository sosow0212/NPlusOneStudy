package com.example.nplusone;

import static com.example.nplusone.factory.MemberFactory.createMember;
import static com.example.nplusone.factory.MemberFactory.createMemberForQuery;
import static com.example.nplusone.factory.PostFactory.createPost;

import com.example.nplusone.domain.Member;
import com.example.nplusone.domain.Post;
import com.example.nplusone.repository.MemberRepository;
import com.example.nplusone.repository.PostRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    MemberRepository memberRepository;

    @After
    public void reset() {
        memberRepository.deleteAll();
        postRepository.deleteAll();
    }

    @Test
    @DisplayName("N+1 테스트")
    public void test() {
        // given
        Member member = createMemberForQuery();
        Post post = createPost(member);

        // when
        postRepository.save(post);

        // then
    }
}
