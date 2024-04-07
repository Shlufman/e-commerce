package com.sandbox.entity.manager;

import com.sandbox.entity.abstraction.Audit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "status_orders")
public class StatusOrder extends Audit{

	@NotBlank
	@Column(name = "status_order_name", length = 255, nullable = false, unique = true)
	private String name;

}
