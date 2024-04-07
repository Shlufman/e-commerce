package com.sandbox.validator;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.sandbox.annotation.ValidIntervalAnnotation;
import com.sandbox.dto.manager.DiscountDTO;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ValidIntervalValidator implements ConstraintValidator<ValidIntervalAnnotation, DiscountDTO> {

	public void initialize(ValidIntervalAnnotation constraintAnnotation) {
		// initialize the zipcode/city/country correlation service
	}

	/**
	 * Validate zipcode and city depending on the country
	 */
	public boolean isValid(DiscountDTO object, ConstraintValidatorContext context) {
		if (!(object instanceof DiscountDTO)) {
			throw new IllegalArgumentException("@ValidIntervalAnnotation only applies to DiscountDTO objects");
		}
		DiscountDTO discount = (DiscountDTO) object;
		LocalDateTime fromDate = discount.getFromDate();
		LocalDateTime toDate  = discount.getToDate();
		return toDate.compareTo(fromDate)>0;
	}
}
