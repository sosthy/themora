package com.starstel.telcopro.stocks.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Product implements Serializable 
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "PRODUCT_SEQ", allocationSize = 1, name = "product_id")
    @GeneratedValue(generator = "product_id")
	private Long id;
	private Date dateAdded;
	@JsonIgnore
	@OneToMany(mappedBy="product")
	private Set<MouvmentLine> mouvmentLines;
	@JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
	private Stock stock;
}
