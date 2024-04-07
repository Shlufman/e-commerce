package com.sandbox.entity.manager;

import com.sandbox.annotation.ForeignKey;
import com.sandbox.entity.abstraction.Audit;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "managers")
public class Manager extends Audit {

	@Column(name = "first_name", length = 255, nullable = false, unique = true)
	private String firstName;
	
	@Column(name = "last_name", length = 255, nullable = false, unique = true)
	private String lastName;

	@ForeignKey(value= Role.class)
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	private Role role;
	
	public Manager(@NotBlank String firstName,@NotBlank String lastName,  @NotNull Role role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role=role;
	}
}
