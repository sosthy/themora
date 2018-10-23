package com.starstel.telcopro.stocks.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Emplacement implements Serializable 
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "EMPLAC_SEQ", allocationSize = 1, name = "emplac_id")
    @GeneratedValue(generator = "emplac_id")
	private Long id;
	private String name;
	@ManyToOne
	private Entrepot entrepot;
	@JsonIgnore
	@OneToMany(mappedBy="emplacement")
	private Set<Product> products = new HashSet<>();
}
