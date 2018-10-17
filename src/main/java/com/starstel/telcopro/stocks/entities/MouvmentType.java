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

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class MouvmentType implements Serializable
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "TRANST_SEQ", allocationSize = 1, name = "transt_id")
    @GeneratedValue(generator = "transt_id")
	private Long id;
	private String name;
	@JsonIgnore
	@OneToMany(mappedBy="mouvmentType")
	private Set<Mouvment> mouvments = new HashSet<>();
	private String note;
}
