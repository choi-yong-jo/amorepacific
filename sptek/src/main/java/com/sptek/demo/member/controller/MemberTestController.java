package com.sptek.demo.member.controller;

import com.sptek.demo.member.model.Member;
import com.sptek.demo.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("memberTest")
@Slf4j
public class MemberTestController {

    @Autowired
    MemberService memberService;

    // 모든 회원 조회
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Member>> getAllmembers() {
        List<Member> member = memberService.findAll();
        return new ResponseEntity<List<Member>>(member, HttpStatus.OK);
    }

    // 회원번호로 한명의 회원 조회
    @GetMapping(value = "/{mbrNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Member> getMember(@PathVariable("mbrNo") Integer mbrNo) {
        Optional<Member> member = memberService.findById(mbrNo);
        return new ResponseEntity<Member>(member.get(), HttpStatus.OK);
    }

    // 회원번호로 회원 삭제
    @DeleteMapping(value = "/{mbrNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteMember(@PathVariable("mbrNo") Integer mbrNo) {
        memberService.deleteById(mbrNo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // 회원번호로 회원 수정(mbrNo로 회원을 찾아 Member 객체의 id, name로 수정함)
    @PutMapping(value = "/{mbrNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Member> updateMember(@PathVariable("mbrNo") Integer mbrNo, Member member) {
        memberService.updateById(mbrNo, member);
        return new ResponseEntity<Member>(member, HttpStatus.OK);
    }

    // 회원 입력
    @PostMapping
    public ResponseEntity<Member> save(Member member) {
        return new ResponseEntity<Member>(memberService.save(member), HttpStatus.CREATED);
    }

    // 회원 입력
    @RequestMapping(value="/saveMember", method = RequestMethod.GET)
    public ResponseEntity<Member> save(HttpServletRequest req, Member member) {
        return new ResponseEntity<Member>(memberService.save(member), HttpStatus.CREATED);
    }
}
