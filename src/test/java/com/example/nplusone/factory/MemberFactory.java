package com.example.nplusone.factory;

import com.example.nplusone.domain.Member;
import com.example.nplusone.dto.member.MemberSaveRequestDto;

public class MemberFactory {
    public static Member createMember() {
        return new Member(new MemberSaveRequestDto("name", 10));
    }

    public static Member createMemberForQuery() {
        return new Member(1L, "제이", 10);
    }
}
