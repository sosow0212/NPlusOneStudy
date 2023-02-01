package com.example.nplusone.dto.member;

import com.example.nplusone.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberSimpleResponseDto {
    private Long id;
    private String name;
    private int age;

    public static MemberSimpleResponseDto toDto(Member member) {
        return new MemberSimpleResponseDto(member.getId(), member.getName(), member.getAge());
    }
}
