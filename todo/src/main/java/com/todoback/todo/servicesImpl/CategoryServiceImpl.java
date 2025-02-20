package com.todoback.todo.servicesImpl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoback.todo.model.Category;
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
	public Category save(Category category) {
		// TODO Auto-generated method stub
        List<String> errors = CategoryValidator.validateCategory(category);
        if(!errors.isEmpty()) {
        	log.info("category is not valid ");
        	return null;
        }
        return categoryRepo.save(category);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		 if (id == null) {
	            log.info("category id is null");
	            return;
	        }
	        categoryRepo.deleteById(id);
	}

	@Override
	public List<Category> findAllByUserId(Long userId) {
		// TODO Auto-generated method stub
		 return categoryRepo.findCategoryByUserId(userId);
	}

	@Override
	public Category findById(Long id) {
		// TODO Auto-generated method stub
		if (id == null) {
            log.info("category id is null");
            return null;
        }
		return categoryRepo.findById(id)
				.orElseGet(()->{
					log.info("No category found with ID");
                    return null;
				});
	}

	@Override
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

}
