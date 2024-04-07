package com.sandbox.dto.manager;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class SeasonDTO {
	@JsonProperty(value = "seasonId")
	private String id;
	
	@NotBlank
	@JsonProperty(value = "seasonName")
	private String name;
}