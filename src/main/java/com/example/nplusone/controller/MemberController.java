package com.example.nplusone.controller;

import com.example.nplusone.dto.member.MemberSaveRequestDto;
import com.example.nplusone.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<String> saveMember(@RequestBody MemberSaveRequestDto req) {
        memberService.saveMember(req);
        return new ResponseEntity<>("멤버 추가 성공", HttpStatus.CREATED);
    }

    @GetMapping("/members")
    public ResponseEntity<?> findAllMembers() {
        return new ResponseEntity<>(memberService.readAllMembers(), HttpStatus.OK);
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<?> findMember(@PathVariable("id") Long id) {
        return new ResponseEntity<>(memberService.readMember(id), HttpStatus.OK);
    }
}
