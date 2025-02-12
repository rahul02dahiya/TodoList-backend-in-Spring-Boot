package com.todoback.todo.servicesImpl;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoback.todo.dto.CategoryDto;
import com.todoback.todo.repositories.CategoryRepo;
import com.todoback.todo.services.CategoryService;
import com.todoback.todo.validators.CategoryValidator;

@Service

public class CategoryServiceImpl implements CategoryService {
	
    private static final Logger log = Logger.getLogger(TodoServiceImpl.class.getName());
	
	@Autowired
	private CategoryRepo categoryRepo;

	public CategoryServiceImpl(@Autowired CategoryRepo categoryRepo) {
		super();
		this.categoryRepo = categoryRepo;
	}

	@Override
	public CategoryDto save(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
        List<String> errors = CategoryValidator.validateCategory(categoryDto);
        if(!errors.isEmpty()) {
        	log.info("Category is not valid ");
        	return null;
        }
        return CategoryDto.fromEntity(categoryRepo.save(CategoryDto.toEntity(categoryDto)));
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		 if (id == null) {
	            log.info("Category id is null");
	            return;
	        }
	        categoryRepo.deleteById(id);
	}

	@Override
	public List<CategoryDto> findAllByUserId(Long userId) {
		// TODO Auto-generated method stub
		 return categoryRepo.findCategoryByUserId(userId).stream()
	                .map(CategoryDto::fromEntity)
	                .collect(Collectors.toList());
	}

	@Override
	public CategoryDto findById(Long id) {
		// TODO Auto-generated method stub
		if (id == null) {
            log.info("Category id is null");
            return null;
        }
		return categoryRepo.findById(id).map(CategoryDto::fromEntity)
				.orElseGet(()->{
					log.info("No category found with ID");
                    return null;
				});
	}

	@Override
	public List<CategoryDto> getAllTodoByCategoriesForToday(Long userId) {
		// TODO Auto-generated method stub
		 return categoryRepo.getAllTodoByCategoriesForToday(ZonedDateTime.now().withHour(0).withMinute(0),
	                ZonedDateTime.now().withHour(23).withMinute(59), userId)
	                .stream()
	                .map(CategoryDto::fromEntity)
	                .collect(Collectors.toList());
	}

	@Override
	public List<CategoryDto> findAll() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
	}

}
