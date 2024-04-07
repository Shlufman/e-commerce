package com.sandbox.entity.customer;

import com.sandbox.annotation.ForeignKey;
import com.sandbox.entity.abstraction.Audit;
import com.sandbox.entity.manager.Brand;
import com.sandbox.entity.manager.Category;
import com.sandbox.entity.manager.Collection;
import com.sandbox.entity.manager.Discount;
import com.sandbox.entity.manager.Season;
import com.sandbox.entity.manager.Section;
import com.sandbox.entity.manager.Style;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "products")
public class Product extends Audit{
	@NotBlank
	@Column(name = "product_name", length = 255, nullable = false, unique = false)
	private String name;
	
	@NotBlank
	@Column(name = "article", length = 7, nullable = false, unique = true)
	private String article;
	
	@NotBlank
	@Column(name = "description", length = 255, nullable = false, unique = false)
	private String description;
	
	@NotBlank
	@Column(name = "details", length = 255, nullable = false, unique = false)
	private String details;
	
	@NotNull
	@Min(value = 0)
	@Max(value = 5)
	@Column(name = "rating", nullable = false, updatable = true)
	private int rating;
	
	@NotBlank
	@Column(name = "image1", length = 255, nullable = false, unique = false)
	private String image1;
	
	@NotBlank
	@Column(name = "image2", length = 255, nullable = false, unique = false)
	private String image2;
	
	@NotBlank
	@Column(name = "image3", length = 255, nullable = false, unique = false)
	private String image3;
	
	@NotBlank
	@Column(name = "image4", length = 255, nullable = false, unique = false)
	private String image4;

	@ForeignKey(value = Category.class)
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category category;
//	@ForeignKey(value = Section.class)
//	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },fetch = FetchType.EAGER)
//	@JoinColumn(name = "section_id")
//	private String sectionId;
	
	@ForeignKey(value = Collection.class)
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },fetch = FetchType.EAGER)
	@JoinColumn(name = "collection_id")
	private Collection collection;
//	@ForeignKey(value = Brand.class)
//	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },fetch = FetchType.EAGER)
//	@JoinColumn(name = "brand_id")
//	private String brandId;
	
	@ForeignKey(value = Style.class)
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },fetch = FetchType.EAGER)
	@JoinColumn(name = "style_id")
	private Style style;
	
	@ForeignKey(value = Season.class)
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },fetch = FetchType.EAGER)
	@JoinColumn(name = "season_id")
	private Season season;
}
