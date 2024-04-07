package com.sandbox.dto.customer;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sandbox.annotation.ForeignKey;
import com.sandbox.entity.manager.Brand;
import com.sandbox.entity.manager.Category;
import com.sandbox.entity.manager.Collection;
import com.sandbox.entity.manager.Season;
import com.sandbox.entity.manager.Section;
import com.sandbox.entity.manager.Style;

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
public class ProductDTO {
	@JsonProperty(value = "productId")
	private String id;
	
	@NotBlank
	@JsonProperty(value = "productName")
	private String name;
	
	@NotBlank
	@Length(min = 5, max=7)
	@JsonProperty(value = "article")
	private String article;
	
	@NotBlank
	@JsonProperty(value = "description")
	private String description;
	
	@NotBlank
	@JsonProperty(value = "details")
	private String details;
	
	@NotNull
	@JsonProperty(value = "rating")
	private int rating;
	
	@NotBlank
	@JsonProperty(value = "image1")
	private String image1;
	
	@NotBlank
	@JsonProperty(value = "image2")
	private String image2;
	
	@NotBlank
	@JsonProperty(value = "image3")
	private String image3;
	
	@NotBlank
	@JsonProperty(value = "image4")
	private String image4;

	@ForeignKey(value = Category.class)
	@NotBlank
	@JsonProperty(value = "categoryId")
	private String categoryId;
//	@ForeignKey(value = Section.class)
//	@NotBlank
//	@JsonProperty(value = "sectionId")
//	private String sectionId;
	

	@ForeignKey(value = Collection.class)
	@NotBlank
	@JsonProperty(value = "collectionId")
	private String collectionId;
//	@ForeignKey(value = Brand.class)
//	@NotBlank
//	@JsonProperty(value = "brandId")
//	private String brandId;
	
	@ForeignKey(value = Style.class)
	@NotBlank
	@JsonProperty(value = "styleId")
	private String styleId;
	
	@ForeignKey(value = Season.class)
	@NotBlank
	@JsonProperty(value = "seasonId")
	private String seasonId;
}
