package com.sandbox.dto.manager;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sandbox.annotation.ForeignKey;
import com.sandbox.entity.manager.Supplier;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class InvoiceDTO {
	@JsonProperty(value = "invoiceId")
	private String id;
	
	@NotNull
	@JsonProperty(value = "invoiceNumber")
	private int number;
	
	@NotNull
	@JsonProperty(value = "invoiceDate")
	private LocalDateTime date;

	@ForeignKey(value = Supplier.class)
	@NotBlank
	@JsonProperty(value = "supplierId")
	private String supplierId;
}
