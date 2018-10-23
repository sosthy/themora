package com.starstel.telcopro.stocks.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Sosthene Nouebissi
 * @version 1.0
 * @created 13-oct.-2018 07:24:13
 */
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Portable extends Product 
{
	private String connection;
	private Double screen;
	private String battery;
	private String sim;
	private Double dimension;
	private Double weight;
	private String ipRating;
	private Boolean fingerprint;
	private Boolean waterproof;
	private Boolean splashproof;
	private Boolean dushproof;
	@OneToMany(mappedBy="portable")
	@JsonIgnore
	private Set<PortableItem> portableItem = new HashSet<>();
	@ManyToOne
	private Memory memory;
	@ManyToOne
	private Camera camera;
	@ManyToOne
	private Cpu cpu;
	@ManyToOne
	private SystemOS os;
	@ManyToOne
	private PortableCategory portableCategory;
	
	public Portable(Long id, Double quantity, Date dateCreation, String designation, String image, Double priceUnit,
			Double priceUnitWholesaler, Double priceUnitSemiWholesaler, Double stockMinim, Double stockAlert,
			Double volume, String note, State state, Emplacement emplacement, MeasureUnit measureUnit,
			ProductCategory productCategory, Set<MouvmentLine> mouvmentLines, String connection, Double screen,
			String battery, String sim, Double dimension, Double weight, String ipRating, Boolean fingerprint,
			Boolean waterproof, Boolean splashproof, Boolean dushproof, Set<PortableItem> portableItem, Memory memoire,
			Camera camera, Cpu cpu, SystemOS os, PortableCategory portableCategory, AppColor appColor) {
		super(id, quantity, dateCreation, designation, image, priceUnit, priceUnitWholesaler, priceUnitSemiWholesaler,
				stockMinim, stockAlert, volume, note, state, emplacement, measureUnit, productCategory, appColor,mouvmentLines);
		this.connection = connection;
		this.screen = screen;
		this.battery = battery;
		this.sim = sim;
		this.dimension = dimension;
		this.weight = weight;
		this.ipRating = ipRating;
		this.fingerprint = fingerprint;
		this.waterproof = waterproof;
		this.splashproof = splashproof;
		this.dushproof = dushproof;
		this.portableItem = portableItem;
		this.memory = memoire;
		this.camera = camera;
		this.cpu = cpu;
		this.os = os;
		this.portableCategory = portableCategory;
	}
	
	
}