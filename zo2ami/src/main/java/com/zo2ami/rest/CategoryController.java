package com.zo2ami.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zo2ami.dto.CategoryDTO;
import com.zo2ami.dto.ErrorDTO;
import com.zo2ami.enums.ErrorCodes;
import com.zo2ami.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

	
	@PostMapping("/add-category")
	public ResponseEntity<List<ErrorDTO>> createCategory(@RequestBody CategoryDTO categoryDto){
		List<ErrorDTO> errors = new ArrayList<>();
		if(categoryDto.getNameAr() == null || categoryDto.getNameAr().isEmpty())
			errors.add(new ErrorDTO(ErrorCodes.MISSING_CATEGORY_NAME_AR));
		if(categoryDto.getNameEn() == null || categoryDto.getNameEn().isEmpty())
			errors.add(new ErrorDTO(ErrorCodes.MISSING_CATEGORY_NAME_EN));
		if(categoryDto.getDisplayOrder() == null)
			errors.add(new ErrorDTO(ErrorCodes.MISSING_CATEGORY_DISPLAY_ORDER));
		if(!errors.isEmpty())
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		categoryService.save(categoryDto.toDomain(categoryDto));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/list-categories")
	public ResponseEntity<List<CategoryDTO>> listCategories(){
		List<CategoryDTO> categoryDTOs = new ArrayList<>();
		categoryService.list().stream().forEach(category -> categoryDTOs.add(new CategoryDTO().toDto(category)));
		return new ResponseEntity<> (categoryDTOs, HttpStatus.OK);
	}
	
	
}
