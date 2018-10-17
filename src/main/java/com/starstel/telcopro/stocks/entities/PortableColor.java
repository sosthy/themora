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
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sosthene Nouebissi
 * @version 1.0
 * @created 13-oct.-2018 07:24:18
 */
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class PortableColor implements Serializable
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "PCOL_SEQ", allocationSize = 1, name = "pcol_id")
    @GeneratedValue(generator = "pcol_id")
	private Long id;
	private String name;
	@OneToMany(mappedBy="portableColor")
	@JsonIgnore
	private Set<Portable> portables = new HashSet<>();
}