package com.starstel.telcopro.stocks.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ProductCategory extends Category
{
	@OneToMany(mappedBy="productCategory")
	@JsonIgnore
	private Set<Product> products = new HashSet<>();
}
