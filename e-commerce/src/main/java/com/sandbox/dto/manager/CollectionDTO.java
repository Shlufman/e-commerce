package com.sandbox.dto.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sandbox.annotation.ForeignKey;
import com.sandbox.entity.manager.Brand;

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
public class CollectionDTO {
	@JsonProperty(value = "collectionId")
	private String id;
	
	@NotBlank
	@JsonProperty(value = "collectionName")
	private String name;

	@ForeignKey(value = Brand.class)
	@NotBlank
	@JsonProperty(value = "brandId")
	private String brandId;
}
