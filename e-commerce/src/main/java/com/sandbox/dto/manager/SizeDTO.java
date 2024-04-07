package com.sandbox.dto.manager;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sandbox.annotation.ForeignKey;
import com.sandbox.entity.manager.TypeGoods;

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
public class SizeDTO {
	@JsonProperty(value = "sizeId")
	private String id;
	
	@NotBlank
	@JsonProperty(value = "sizeName")
	private String name;

	@ForeignKey(value = TypeGoods.class)
	@NotBlank
	@JsonProperty(value = "typeGoodsId")
	private String typeGoodsId;
}
