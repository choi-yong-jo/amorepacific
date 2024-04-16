package com.sptek.demo.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sptek.demo.member.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

	public List<Member> findById(String id);
	
	public List<Member> findByName(String name);
	
	public List<Member> findByNameLike(String name);
	
}
