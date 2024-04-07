package com.sandbox.dto.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sandbox.annotation.ForeignKey;
import com.sandbox.entity.manager.Role;

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
public class ManagerDTO {
	@JsonProperty(value = "managerId")
	private String id;
	
	@NotBlank
	@JsonProperty(value = "firstName")
	private String firstName;
	
	@NotBlank
	@JsonProperty(value = "lastName")
	private String lastName;

	@ForeignKey(value = Role.class)
	@NotBlank
	@JsonProperty(value = "roleId")
	private String roleId;
}
