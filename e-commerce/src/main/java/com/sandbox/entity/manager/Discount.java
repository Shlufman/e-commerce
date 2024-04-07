package com.sandbox.entity.manager;

import java.time.LocalDateTime;

import com.sandbox.entity.abstraction.Audit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
//import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "discounts")
public class Discount extends Audit{

	@NotBlank
	@Column(name = "brand_name", length = 255, nullable = false, unique = true)
	private String name;
	
	@NotNull
//	@Future
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "from_date", nullable = false, updatable = true)
	private LocalDateTime fromDate;

	@NotNull
//	@Future
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "to_date", nullable = false, updatable = true)
	private LocalDateTime toDate;
	
	@NotNull
	@Min(value = 1)
	@Max(value = 100)
	@Column(name = "discount", nullable = false, updatable = true)
	private int discount;

}
