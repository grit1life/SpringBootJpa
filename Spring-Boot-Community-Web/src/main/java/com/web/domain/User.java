package com.web.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.web.domain.enums.BoardType;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table
public class User implements Serializable {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	@Column
	private String name;
	@Column
	private String password;
	@Column
	private String email;
	@Column
	private LocalDateTime createdDate;
	@Column
	private LocalDateTime updateData;
	
	@Builder
	public User(String name, String password, String email, LocalDateTime createdDate,
			LocalDateTime updateData) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.createdDate = createdDate;
		this.updateData = updateData;
	}
}
