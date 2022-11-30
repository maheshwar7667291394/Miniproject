package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private Integer bookid;
	private String name;
	private String author;
	private String publication;
	private String category;
	private Integer pages;
	private Integer price;

}
