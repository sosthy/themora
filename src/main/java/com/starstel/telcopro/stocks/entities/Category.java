package com.starstel.telcopro.stocks.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Category implements Serializable
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "CAT_SEQ", allocationSize = 1, name = "cat_id")
    @GeneratedValue(generator = "cat_id")
	private Long id;
	private String name;
	private String notes;
}
