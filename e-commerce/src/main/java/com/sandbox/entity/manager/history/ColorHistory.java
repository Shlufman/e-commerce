package com.sandbox.entity.manager.history;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UuidGenerator;

import com.sandbox.constants.TypeCrud;
import com.sandbox.entity.manager.Color;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode(of = { "recordId" }, callSuper = false)
//@Entity
//@Table(name = "color_history")
public class ColorHistory {
//	@Id
//	@UuidGenerator
//	@Column(name = "record_id", unique = true, nullable = false)
//	private String recordId;
//	
//	@Enumerated(EnumType.STRING)
//	@Column(name = "type_crud", nullable = false)
//	private TypeCrud typeCrud;
//	
//	@Temporal(TemporalType.TIMESTAMP)
//	@CreationTimestamp(source = SourceType.DB)
//	@Column(name = "date", nullable = false)
//	private LocalDateTime date;
//	
//
//	Color color;

}
