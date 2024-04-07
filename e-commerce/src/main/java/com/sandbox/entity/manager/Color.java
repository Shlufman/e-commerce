package com.sandbox.entity.manager;

import com.sandbox.entity.abstraction.Audit;

//import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
//import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
//@Embeddable
@Table(name = "colors") // , uniqueConstraints = { @UniqueConstraint(columnNames = { "colorName", "rgb"
						// }) }
public class Color extends Audit{

	@Column(name = "color_name", length = 50, nullable = false, unique = true)
	private String name;

	@Pattern(regexp = "^rgb\\((0|255|25[0-4]|2[0-4]\\d|1\\d\\d|0?\\d?\\d),(0|255|25[0-4]|2[0-4]\\d|1\\d\\d|0?\\d?\\d),(0|255|25[0-4]|2[0-4]\\d|1\\d\\d|0?\\d?\\d)\\)$")
	@Column(name = "rgb_code", length = 16, nullable = false, unique = true)
	private String rgbCode;

	public Color(@NotBlank String name, @NotBlank String rgbCode) {
		super();
		this.name = name;
		this.rgbCode = rgbCode;
	}

}
