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
public class RoleDTO {
	
	@JsonProperty(value = "roleId")
	private String id;
	
	@NotBlank
	@JsonProperty(value = "roleName")
	private String name;
}