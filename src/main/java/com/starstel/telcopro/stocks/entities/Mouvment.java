package com.starstel.telcopro.stocks.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.starstel.telcopro.rh.entities.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Mouvment implements Serializable
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "TRANS_SEQ", allocationSize = 1, name = "trans_id")
    @GeneratedValue(generator = "trans_id")
	private Long id;
	private String reference;
	private Date date;
	private Double quantity;
	private Double priceTotal;
	@ManyToOne
	private Entrepot entrepotSource;
	@ManyToOne
	private Entrepot entrepotRecipient;
	@JsonIgnore
	@OneToMany(mappedBy="mouvment")
	private Set<MouvmentLine> mouvmentLines = new HashSet<>();
	@ManyToOne
	private MouvmentType mouvmentType;
	@ManyToOne
	private Employee user;
	@ManyToOne
	private Recipient recipient;
	
	
	@Override
	public int hashCode() 
	{
		if(reference != null && id != null)
			return reference.hashCode() + id.hashCode();
		else
			return super.hashCode();
	}
}
