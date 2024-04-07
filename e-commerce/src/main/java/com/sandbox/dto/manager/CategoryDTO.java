package com.sandbox.dto.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sandbox.annotation.ForeignKey;
import com.sandbox.entity.manager.Section;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode(of = { "id" })
public class CategoryDTO {
	@JsonProperty(value = "categoryId")
	private String id;
	
	@NotBlank
	@JsonProperty(value = "categoryName")
	private String name;

	@ForeignKey(value = Section.class)
	@NotBlank
	@JsonProperty(value = "sectionId")
	private String sectionId;
}
