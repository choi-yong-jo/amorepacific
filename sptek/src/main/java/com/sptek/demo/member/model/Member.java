package com.sptek.demo.member.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mbrNo;

	private String id;
	
	private String password;
	
	private String name;
	
	private String phone;
	
	private String email;
	
	private String createDt;
}
