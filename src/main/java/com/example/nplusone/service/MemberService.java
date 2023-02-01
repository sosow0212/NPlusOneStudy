package com.example.nplusone.service;

import com.example.nplusone.domain.Member;
import com.example.nplusone.dto.member.MemberSimpleResponseDto;
import com.example.nplusone.dto.member.MemberSaveRequestDto;
import com.example.nplusone.repository.MemberRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void saveMember(MemberSaveRequestDto req) {
        Member member = new Member(req);
        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public List<MemberSimpleResponseDto> readAllMembers() {
        return memberRepository.findAll().stream()
                .map(member -> MemberSimpleResponseDto.toDto(member))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MemberSimpleResponseDto readMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("nope"));
        return new MemberSimpleResponseDto().toDto(member);
    }
}
