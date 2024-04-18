package com.sptek.demo.member.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sptek.demo.member.model.Member;
import com.sptek.demo.member.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	public List<Member> findAll() {
		List<Member> members = new ArrayList<>();
		memberRepository.findAll().forEach(e -> members.add(e));
		return members;
	}

	public Optional<Member> findById(Integer mbrNo){
		Optional<Member> member = memberRepository.findById(mbrNo);
		return member;
	}

	public void deleteById(Integer mbrNo){
		memberRepository.deleteById(mbrNo);
	}

	public Member save(Member member){
		memberRepository.save(member);
		return member;
	}

	public void updateById(Integer mbrNo, Member member){
		Optional<Member> e = memberRepository.findById(mbrNo);
		if(e.isPresent()){
			e.get().setMbrNo(member.getMbrNo());
			e.get().setId(member.getId());
			e.get().setName(member.getName());
			memberRepository.save(member);
		}
	}

}
