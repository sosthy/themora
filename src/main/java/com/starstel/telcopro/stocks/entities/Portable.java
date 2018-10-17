package com.starstel.telcopro.stocks.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
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
	private Memoire memoire;
	@ManyToOne
	private Camera camera;
	@ManyToOne
	private Cpu cpu;
	@ManyToOne
	private SystemOS os;
	@ManyToOne
	private PortableCategory portableCategory;
	@ManyToOne
	private PortableColor portableColor;
}