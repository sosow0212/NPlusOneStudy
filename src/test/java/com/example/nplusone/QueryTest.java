package com.example.nplusone;

import static com.example.nplusone.factory.MemberFactory.createMember;
import static com.example.nplusone.factory.PostFactory.createPost;
import static org.mockito.Mockito.verify;

import com.example.nplusone.domain.Member;
import com.example.nplusone.domain.Post;
import com.example.nplusone.dto.post.PostSaveRequestDto;
import com.example.nplusone.repository.MemberRepository;
import com.example.nplusone.repository.PostRepository;
import com.example.nplusone.service.MemberService;
import com.example.nplusone.service.PostService;
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
    PostRepository postRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PostService postService;

    @Autowired
    MemberService memberService;

//    @After
    public void cleanAll() {
        memberRepository.deleteAll();
        postRepository.deleteAll();
    }

    @Test
    @DisplayName("N+1 테스트")
    public void test() {
        // given
        Member member = createMember();

        // when
        memberRepository.save(member);
        member.addPosts(createPost(member));

        // then
    }
}
