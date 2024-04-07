package com.sandbox.entity.abstraction;

import java.io.Serializable;
import java.time.LocalDateTime;
//import java.util.Date;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Getter
@Setter
@MappedSuperclass
@ToString
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(of = { "id" })
public abstract class Audit implements Serializable {
	@Id
	@UuidGenerator
	@Column(name = "id", nullable = false, updatable = false, unique = true)
	protected String id;

	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
//	@CreationTimestamp(source = SourceType.DB)
	@Column(name = "created_date", nullable = false) // , columnDefinition = "TIMESTAMP"
	private LocalDateTime createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
//	@UpdateTimestamp(source = SourceType.DB)
	@Column(name = "modify_date", nullable = false, updatable = true) // , columnDefinition = "updated_on timestamp
																		// default CURRENT_TIMESTAMP"
	private LocalDateTime updatedDate;

}
