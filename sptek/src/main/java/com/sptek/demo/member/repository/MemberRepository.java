package com.sptek.demo.member.repository;

import java.util.List;

import com.sptek.demo.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	public List<Member> findById(String id);

	public List<Member> findByName(String name);

	public List<Member> findByNameLike(String name);

}
