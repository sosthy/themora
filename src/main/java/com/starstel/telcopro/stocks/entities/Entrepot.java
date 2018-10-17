package com.starstel.telcopro.stocks.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Entrepot implements Serializable 
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "ENTR_SEQ", allocationSize = 1, name = "entr_id")
    @GeneratedValue(generator = "entr_id")
	private Long id;
	private String name;
	private Double nbOfProduct;
	private Double priceTotal;
	private Double volume;
	private Double volumeSecurity;
	@JsonIgnore
	@OneToMany(mappedBy="entrepotSource")
	private Set<Mouvment> mouvments = new HashSet<>();
	@JsonIgnore
	@OneToMany(mappedBy="entrepot")
	private Set<Emplacement> emplacements = new HashSet<>();
	
	@Override
	public int hashCode() 
	{
		if(name != null && id != null)
			return name.hashCode() + id.hashCode();
		else
			return super.hashCode();
	}
}
