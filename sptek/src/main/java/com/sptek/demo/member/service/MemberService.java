package com.sptek.demo.member.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sptek.demo.member.model.Member;
import com.sptek.demo.member.repository.MemberRepository;

@Service
public class MemberService {
	
	private MemberRepository memberRepository;
	
	public List<Member> findAll() {
		List<Member> members = new ArrayList<>();
		memberRepository.findAll().forEach(e -> members.add(e));
		return members;
	}
	

}
