package com.sptek.demo.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sptek.demo.user.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

}
