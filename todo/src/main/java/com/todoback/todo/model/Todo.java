package com.todoback.todo.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Todo implements Serializable {
	
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String description;
	private ZonedDateTime startTime;
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	@JsonIgnore
	private Category category;

}
