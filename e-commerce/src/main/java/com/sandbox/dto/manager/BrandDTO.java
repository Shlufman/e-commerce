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
public class BrandDTO {
	
	@JsonProperty(value = "brandId")
	private String id;
	
	@NotBlank(message = "field brandName must not be blank")
	@JsonProperty(value = "brandName")
	private String name;
}
