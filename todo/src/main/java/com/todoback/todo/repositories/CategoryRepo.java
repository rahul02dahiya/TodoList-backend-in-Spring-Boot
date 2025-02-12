package com.todoback.todo.repositories;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.todoback.todo.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    List<Category> findCategoryByUserId(Long userId);
    
    @Query("select t.category.id from Todo t where t.id = :todoId")
    Long findCategoryByTodoId(Long todoId);

    @Query("select c from Category c inner join Todo t on t.category.id = c.id where t.startTime >= :startTime and t.startTime <= :endTime and c.user.id = :userId")
    List<Category> getAllTodoByCategoriesForToday(@Param("startTime") ZonedDateTime startTime, @Param("endTime") ZonedDateTime endTime, @Param("userId")Long userId);
}
