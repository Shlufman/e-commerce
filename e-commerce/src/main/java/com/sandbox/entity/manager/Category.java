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
@Table(name = "categories")
public class Category extends Audit {

	@Column(name = "category_name", length = 255, nullable = false, unique = true)
	private String name;

	@ForeignKey(value= Section.class)
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },fetch = FetchType.EAGER)
	@JoinColumn(name = "section_id")
	private Section section;
	
	public Category(@NotBlank String name, @NotNull Section section) {
		super();
		this.name = name;
		this.section=section;
	}
}
