package com.sandbox.dto.manager;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sandbox.annotation.ValidIntervalAnnotation;

//import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ValidIntervalAnnotation
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode(of = { "id" })
public class DiscountDTO {
	
	@JsonProperty(value = "discountId")
	private String id;
	
	@NotBlank
	@JsonProperty(value = "discountName")
	private String name;
	
	@NotNull
//	@Future
	@JsonProperty(value = "fromDate")
	private LocalDateTime fromDate;

	@NotNull
//	@Future
	@JsonProperty(value = "toDate")
	private LocalDateTime toDate;
	
	@NotNull
	@Min(value = 1)
	@Max(value = 100)
	@JsonProperty(value = "discount")
	private int discount;
	
}










