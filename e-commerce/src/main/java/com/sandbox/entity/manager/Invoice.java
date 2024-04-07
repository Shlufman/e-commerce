package com.sandbox.entity.manager;

import java.time.LocalDateTime;

import com.sandbox.annotation.ForeignKey;
import com.sandbox.entity.abstraction.Audit;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "invoices")
public class Invoice extends Audit {

	@NotNull
	@Column(name = "invoice_number", nullable = false, unique = true)
	private int number;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "invoice_date", nullable = false, updatable = true)
	private LocalDateTime date;

	@ForeignKey(value= Supplier.class)
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },fetch = FetchType.EAGER)
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;
	
	public Invoice(@NotBlank int number,@NotNull LocalDateTime date, @NotNull Supplier supplier) {
		super();
		this.number = number;
		this.supplier=supplier;
	}
}
