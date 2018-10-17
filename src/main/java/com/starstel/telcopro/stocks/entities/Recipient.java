package com.starstel.telcopro.stocks.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.starstel.telcopro.rh.entities.Person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Recipient extends Person implements Serializable 
{
	private String civility;
    private String enterprise;
    private String service;
    private String fonction;
    @ManyToOne
    private RecipientGroupe groupe;
    @JsonIgnore
    @OneToMany(mappedBy="recipient")
    private Set<Mouvment> mouvments = new HashSet<>();
}
