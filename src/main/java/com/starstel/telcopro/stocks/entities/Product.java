package com.starstel.telcopro.stocks.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@SequenceGenerator(initialValue = 1, sequenceName = "STOCK_SEQ", allocationSize = 1, name = "stock_id")
    @GeneratedValue(generator = "stock_id")
	private Long id;
	private Double quantity;
	private Date dateCreation;
	private String designation;
	private String image;
	private Double priceUnit;
	private Double priceUnitWholesaler;
	private Double priceUnitSemiWholesaler;
	private Double stockMinim;
	private Double stockAlert;
	private Double volume;
	private String note;
	@ManyToOne
	private State state;
	@ManyToOne
	private Emplacement emplacement;
	@ManyToOne
	private MeasureUnit measureUnit;
	@ManyToOne
	private ProductCategory productCategory;
	@ManyToOne
	private AppColor appColor;
	@JsonIgnore
	@OneToMany(mappedBy="product")
	private Set<MouvmentLine> mouvmentLines;
}
