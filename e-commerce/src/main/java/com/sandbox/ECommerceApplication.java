package com.sandbox;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.ResponseEntity;

import com.sandbox.controller.abstraction.ISimpleController;
import com.sandbox.controller.customer.ProductGenericController;
import com.sandbox.controller.manager.BrandGenericController;
import com.sandbox.controller.manager.CategoryGenericController;
import com.sandbox.controller.manager.CollectionGenericController;
import com.sandbox.controller.manager.ColorGenericController;
import com.sandbox.controller.manager.CountryGenericController;
import com.sandbox.controller.manager.DiscountGenericController;
import com.sandbox.controller.manager.InvoiceGenericController;
import com.sandbox.controller.manager.ManagerGenericController;
import com.sandbox.controller.manager.RoleGenericController;
import com.sandbox.controller.manager.SeasonGenericController;
import com.sandbox.controller.manager.SectionGenericController;
import com.sandbox.controller.manager.SizeGenericController;
import com.sandbox.controller.manager.StatusOrderGenericController;
import com.sandbox.controller.manager.StyleGenericController;
import com.sandbox.controller.manager.SupplierGenericController;
import com.sandbox.controller.manager.TypeGoodsGenericController;
import com.sandbox.dto.customer.ProductDTO;
import com.sandbox.dto.manager.BrandDTO;
import com.sandbox.dto.manager.CategoryDTO;
import com.sandbox.dto.manager.CollectionDTO;
import com.sandbox.dto.manager.ColorDTO;
import com.sandbox.dto.manager.CountryDTO;
import com.sandbox.dto.manager.DiscountDTO;
import com.sandbox.dto.manager.InvoiceDTO;
import com.sandbox.dto.manager.ManagerDTO;
import com.sandbox.dto.manager.RoleDTO;
import com.sandbox.dto.manager.SeasonDTO;
import com.sandbox.dto.manager.SectionDTO;
import com.sandbox.dto.manager.SizeDTO;
import com.sandbox.dto.manager.StatusOrderDTO;
import com.sandbox.dto.manager.StyleDTO;
import com.sandbox.dto.manager.SupplierDTO;
import com.sandbox.dto.manager.TypeGoodsDTO;
import com.sandbox.entity.customer.Product;
import com.sandbox.repository.customer.UniversalRepositoryProducts;
import com.sandbox.service.customer.ProductGenericService;

@SpringBootApplication
@EnableJpaAuditing
public class ECommerceApplication implements CommandLineRunner {
	private static int countColors = 20;
	private static int countStyles = 20;
	private static int countBrands = 20;
	private static int countSeasons = 20;
	private static int countSections = 20;
	private static int countSuppliers = 20;
	private static int countTypeGoods = 20;
	private static int countStatusOrders = 20;
	private static int countCountries = 20;
	private static int countRoles = 20;
	private static int countDiscounts = 5;
	private static int countCollectionsOfOneBrand = 14;
	private static int countCategiesOfOneSection = 14;
	private static int countManagersOfOneRole = 14;
	private static int countInvoicesOfOneSupplier = 14;
	private static int countSizesOfOneTypeGoods = 14;
	private static int countProducts = 14;
	private static ConfigurableApplicationContext ctx;

	private static Logger LOG = LoggerFactory.getLogger(ECommerceApplication.class);

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		ctx = SpringApplication.run(ECommerceApplication.class, args);

//		addColors(countColors);
//		addBrands(countBrands);
//		addStyles(countStyles);
//		addSeasons(countSeasons);
//		addSections(countSections);
//		addSuppliers(countSuppliers);
//		addTypeGoods(countTypeGoods);
//		addStatusOrders(countStatusOrders);
//		addCountries(countCountries);
//		addRoles(countRoles);
//		addDiscounts(countDiscounts);
//		addCollections(countCollectionsOfOneBrand);
//		addCategories(countCategiesOfOneSection);
//		addManagers(countManagersOfOneRole);
//		addInvoices(countInvoicesOfOneSupplier);
//		addSizes(countSizesOfOneTypeGoods);
//		addProducts(countProducts);
//		getByUnversalRepository();
//		getByUnversalRepositorySorted();

		LOG.info("APPLICATION FINISHED");
	}

	private static void getByUnversalRepository() {
//		UniversalRepositoryProducts repository = ctx.getBean(UniversalRepositoryProducts.class);
//		ProductGenericService produtService = ctx.getBean("productService", ProductGenericService.class);
//		ProductDTO productDTO = ctx.getBean(ProductGenericController.class).getAll().getBody().get(0);
		ProductGenericController productController = ctx.getBean(ProductGenericController.class);

		ProductDTO productDTO = productController.getAll().getBody().get(0);

		List<CategoryDTO> categoryDTOs = ctx.getBean(CategoryGenericController.class).getAll().getBody();
		@SuppressWarnings("unused")
		List<CollectionDTO> collectionDTOs = ctx.getBean(CollectionGenericController.class).getAll().getBody();
		List<StyleDTO> styleDTOs = ctx.getBean(StyleGenericController.class).getAll().getBody();
		List<SeasonDTO> seasonDTOs = ctx.getBean(SeasonGenericController.class).getAll().getBody();

		Map<String, String> foreignKeysMap = new HashMap<>();
		foreignKeysMap.put("category", categoryDTOs.get(0).getId());
		foreignKeysMap.put("style", styleDTOs.get(0).getId());
		foreignKeysMap.put("season", seasonDTOs.get(0).getId());
//		foreignKeysMap.put("id", productDTO.getId());
		Integer pageNumber = 1;
		Integer pageSize = 4;

//		Page<Product> pageProducts = repository.getAllWithPaginationByForeignKeys(foreignKeysMap, pageNumber, pageSize);
//		Page<ProductDTO> pageProducts = produtService.getAllWithPaginationByForeignKeys(foreignKeysMap, pageNumber,
//				pageSize);
//		pageProducts.forEach(System.out::println);

		ResponseEntity<Page<ProductDTO>> pageProducts = productController.getAllWithPaginationByForeignKey(pageNumber,
				pageSize, null, null, "id", productDTO.getId());
		System.out.println("pageProducts : " + pageProducts.getBody().getContent());
	}

	private static void getByUnversalRepositorySorted() {
//		UniversalRepositoryProducts repository = ctx.getBean(UniversalRepositoryProducts.class);
//		ProductGenericService produtService = ctx.getBean("productService", ProductGenericService.class);
//		ProductDTO productDTO = ctx.getBean(ProductGenericController.class).getAll().getBody().get(0);
		ProductGenericController productController = ctx.getBean(ProductGenericController.class);

		ProductDTO productDTO = productController.getAll().getBody().get(0);

		List<CategoryDTO> categoryDTOs = ctx.getBean(CategoryGenericController.class).getAll().getBody();
		@SuppressWarnings("unused")
		List<CollectionDTO> collectionDTOs = ctx.getBean(CollectionGenericController.class).getAll().getBody();
		List<StyleDTO> styleDTOs = ctx.getBean(StyleGenericController.class).getAll().getBody();
		List<SeasonDTO> seasonDTOs = ctx.getBean(SeasonGenericController.class).getAll().getBody();

		Map<String, String> foreignKeysMap = new HashMap<>();
		foreignKeysMap.put("category", categoryDTOs.get(0).getId());
		foreignKeysMap.put("style", styleDTOs.get(0).getId());
		foreignKeysMap.put("season", seasonDTOs.get(0).getId());
//		foreignKeysMap.put("id", productDTO.getId());
		Integer pageNumber = 1;
		Integer pageSize = 4;

//		Page<Product> pageProducts = repository.getAllWithPaginationAndSortingByForeignKeys(foreignKeysMap, pageNumber, pageSize,
//				"article", "DESC");
//		Page<ProductDTO> pageProducts = produtService.getAllWithPaginationSortedByForeignKeys(foreignKeysMap,
//				pageNumber, pageSize, "article", "DESC");
//		pageProducts.forEach(System.out::println);
		
		ResponseEntity<Page<ProductDTO>> pageProducts = productController.getAllWithPaginationByForeignKey(pageNumber,
				pageSize, "name", "ASC", "id", productDTO.getId());
		System.out.println("pageProducts : " + pageProducts.getBody().getContent());
	}

	private static void addColors(int count) {
		ISimpleController<ColorDTO> controller = ctx.getBean("colorGenericController", ColorGenericController.class);

		ColorDTO dto = new ColorDTO();

		for (int i = 0; i < count; i++) {
			dto.setName("color" + i);
			dto.setRgbCode("rgb(" + i + "," + i + "," + i + ")");
			controller.add(dto);
		}

//		System.out.println(controller.getAll());
	}

	private static void addBrands(int count) {
		ISimpleController<BrandDTO> controller = ctx.getBean("brandGenericController", BrandGenericController.class);
		BrandDTO dto = new BrandDTO();

		for (int i = 0; i < count; i++) {
			dto.setName("brand" + i);
			controller.add(dto);
		}

//		System.out.println(controller.getAll());
	}

	private static void addStyles(int count) {
		StyleGenericController controller = ctx.getBean(StyleGenericController.class);
		StyleDTO dto = new StyleDTO();

		for (int i = 0; i < count; i++) {
			dto.setName("style" + i);
			controller.add(dto);
		}

//		System.out.println(controller.getAll());
	}

	private static void addSeasons(int count) {
		SeasonGenericController controller = ctx.getBean(SeasonGenericController.class);
		SeasonDTO dto = new SeasonDTO();

		for (int i = 0; i < count; i++) {
			dto.setName("season" + i);
			controller.add(dto);
		}

//		System.out.println(controller.getAll());
	}

	private static void addSections(int count) {
		SectionGenericController controller = ctx.getBean(SectionGenericController.class);
		SectionDTO dto = new SectionDTO();

		for (int i = 0; i < count; i++) {
			dto.setName("section" + i);
			controller.add(dto);
		}

//		System.out.println(controller.getAll());
	}

	private static void addSuppliers(int count) {
		SupplierGenericController controller = ctx.getBean(SupplierGenericController.class);
		SupplierDTO dto = new SupplierDTO();

		for (int i = 0; i < count; i++) {
			dto.setName("supplier" + i);
			controller.add(dto);
		}

//		System.out.println(controller.getAll());
	}

	private static void addTypeGoods(int count) {
		TypeGoodsGenericController controller = ctx.getBean(TypeGoodsGenericController.class);
		TypeGoodsDTO dto = new TypeGoodsDTO();

		for (int i = 0; i < count; i++) {
			dto.setName("typyGoods" + i);
			controller.add(dto);
		}

//		System.out.println(controller.getAll());
	}

	private static void addStatusOrders(int count) {
		StatusOrderGenericController controller = ctx.getBean(StatusOrderGenericController.class);
		StatusOrderDTO dto = new StatusOrderDTO();

		for (int i = 0; i < count; i++) {
			dto.setName("statusOrder" + i);
			controller.add(dto);
		}

//		System.out.println(controller.getAll());
	}

	private static void addCountries(int count) {
		ISimpleController<CountryDTO> controller = ctx.getBean("countryGenericController",
				CountryGenericController.class);

		CountryDTO dto = new CountryDTO();

		for (int i = 0; i < count; i++) {
			dto.setName("country" + i);
			controller.add(dto);
		}

//		System.out.println(controller.getAll());
	}

	private static void addRoles(int count) {
		RoleGenericController controller = ctx.getBean(RoleGenericController.class);
		RoleDTO dto = new RoleDTO();

		for (int i = 0; i < count; i++) {
			dto.setName("role" + i);
			controller.add(dto);
		}

//		System.out.println(controller.getAll());
	}

	private static void addDiscounts(int count) {
		DiscountGenericController controller = ctx.getBean(DiscountGenericController.class);
		DiscountDTO dto = new DiscountDTO();

		int month = 0;
		int day = 0;
		int hour = 0;
		int minute = 0;
		for (int i = 0; i < count; i++) {
			dto.setName("discount" + i);
			month = (i + 2) % 12;
			day = (i + 2) % 27;
			dto.setFromDate(LocalDateTime.of(2023, month, day, hour, minute));
			month = (month + 0) % 12;
			day = (day + 1) % 28;
			dto.setToDate(LocalDateTime.of(2023, month, day, hour, minute));
			dto.setDiscount((i + 1) * 5);
			controller.add(dto);
		}

//		System.out.println(controller.getAll());
	}

	private static void addCollections(int countCollectionsOfOneBrand) {
		CollectionGenericController controller = ctx.getBean(CollectionGenericController.class);
		CollectionDTO dto;
		BrandGenericController brandController = ctx.getBean(BrandGenericController.class);
		ResponseEntity<List<BrandDTO>> response = brandController.getAll();

		List<BrandDTO> brands = response.getBody();
		String nameCollection;
		for (int i = 0; i < countBrands; i++) {
			BrandDTO brand = brands.get(i);

			for (int j = 0; j < countCollectionsOfOneBrand; j++) {
				dto = new CollectionDTO();
				dto.setBrandId(brand.getId());
				nameCollection = "collection" + j + brand.getName();
				dto.setName(nameCollection);
				controller.add(dto);
			}
		}

//		System.out.println(controller.getAll());
	}

	private static void addCategories(int countCategiesOfOneSection) {
		CategoryGenericController controller = ctx.getBean(CategoryGenericController.class);
		CategoryDTO dto;
		SectionGenericController sectionController = ctx.getBean(SectionGenericController.class);
		ResponseEntity<List<SectionDTO>> response = sectionController.getAll();

		List<SectionDTO> sections = response.getBody();
		String name;
		for (int i = 0; i < countSections; i++) {
			SectionDTO section = sections.get(i);

			for (int j = 0; j < countCategiesOfOneSection; j++) {
				dto = new CategoryDTO();
				dto.setSectionId(section.getId());
				name = "category" + j + section.getName();
				dto.setName(name);
				controller.add(dto);
			}
		}

//		System.out.println(controller.getAll());
	}

	private static void addManagers(int countManagersOfOneRole) {
		ManagerGenericController controller = ctx.getBean(ManagerGenericController.class);
		ManagerDTO dto;
		RoleGenericController roleController = ctx.getBean(RoleGenericController.class);
		ResponseEntity<List<RoleDTO>> response = roleController.getAll();

		List<RoleDTO> roles = response.getBody();
		String name;
		for (int i = 0; i < countRoles; i++) {
			RoleDTO role = roles.get(i);

			for (int j = 0; j < countManagersOfOneRole; j++) {
				dto = new ManagerDTO();
				dto.setRoleId(role.getId());
				name = "manager" + j + role.getName();
				dto.setFirstName("first" + name);
				dto.setLastName("last" + name);
				controller.add(dto);
			}
		}

//		System.out.println(controller.getAll());
	}

	private static void addInvoices(int countInvoicesOfOneSupplier) {
		InvoiceGenericController controller = ctx.getBean(InvoiceGenericController.class);
		InvoiceDTO dto;
		SupplierGenericController supplierController = ctx.getBean(SupplierGenericController.class);
		ResponseEntity<List<SupplierDTO>> response = supplierController.getAll();

		List<SupplierDTO> suppliers = response.getBody();
		int number = 1;
		for (int i = 0; i < countSuppliers; i++) {
			SupplierDTO supplier = suppliers.get(i);

			for (int j = 0; j < countInvoicesOfOneSupplier; j++) {
				dto = new InvoiceDTO();
				dto.setSupplierId(supplier.getId());
				dto.setNumber(number++);
				dto.setDate(LocalDateTime.now());
				controller.add(dto);
			}
		}

//		System.out.println(controller.getAll());
	}

	private static void addSizes(int countSizesOfOneTypeGoods) {
		SizeGenericController controller = ctx.getBean(SizeGenericController.class);
		SizeDTO dto;
		TypeGoodsGenericController typeGoodsController = ctx.getBean(TypeGoodsGenericController.class);
		ResponseEntity<List<TypeGoodsDTO>> response = typeGoodsController.getAll();

		List<TypeGoodsDTO> typeGoods = response.getBody();
		String name;
		for (int i = 0; i < countSuppliers; i++) {
			TypeGoodsDTO type = typeGoods.get(i);

			for (int j = 0; j < countInvoicesOfOneSupplier; j++) {
				dto = new SizeDTO();
				dto.setTypeGoodsId(type.getId());
				name = "size" + j + type.getName();
				dto.setName(name);
				controller.add(dto);
			}
		}

//		System.out.println(controller.getAll());
	}

	private static void addProducts(int countProducts) {
		int countGlobal = 10;

		ProductGenericController controller = ctx.getBean(ProductGenericController.class);

		List<CategoryDTO> categoryDTOs = ctx.getBean(CategoryGenericController.class).getAll().getBody();
		List<CollectionDTO> collectionDTOs = ctx.getBean(CollectionGenericController.class).getAll().getBody();
		List<StyleDTO> styleDTOs = ctx.getBean(StyleGenericController.class).getAll().getBody();
		List<SeasonDTO> seasonDTOs = ctx.getBean(SeasonGenericController.class).getAll().getBody();

		ProductDTO dto;
		String article = "123";
		String description = "description";
		String details = "details";
		int rating = 0;
		String image1 = "image1";
		String image2 = "image2";
		String image3 = "image3";
		String image4 = "image4";

		CategoryDTO categoryDTO;
		CollectionDTO collectionDTO;
		StyleDTO styleDTO;
		SeasonDTO seasonDTO;

		String name;

		for (int i = 0; i < countGlobal; i++) {
			for (int j = 0; j < countInvoicesOfOneSupplier; j++) {
				dto = new ProductDTO();
				String temp = "" + i + j;
				categoryDTO = categoryDTOs.get(j);
				collectionDTO = collectionDTOs.get(j);
				styleDTO = styleDTOs.get(j);
				seasonDTO = seasonDTOs.get(j);
				name = "product" + i + categoryDTO.getName() + collectionDTO.getName() + styleDTO.getName()
						+ seasonDTO.getName();
				dto.setName(name);

				dto.setArticle(article + temp);
				dto.setDescription(description + temp);
				dto.setDetails(details + temp);
				dto.setRating(rating);
				dto.setImage1(image1 + temp);
				dto.setImage2(image2 + temp);
				dto.setImage3(image3 + temp);
				dto.setImage4(image4 + temp);

				dto.setCategoryId(categoryDTO.getId());
				dto.setCollectionId(collectionDTO.getId());
				dto.setStyleId(styleDTO.getId());
				dto.setSeasonId(seasonDTO.getId());

				controller.add(dto);
			}
		}
		System.out.println(controller.getAll());
	}

	@Override
	public void run(String... args) {
		LOG.info("EXECUTING : command line runner");

		for (int i = 0; i < args.length; ++i) {
			LOG.info("args[{}]: {}", i, args[i]);
		}
	}

}
