package com.starstel.telcopro.stocks.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
	@OneToMany(cascade=CascadeType.ALL, mappedBy="entrepotSource")
	private Set<Mouvment> mouvments = new HashSet<>();
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="entrepot")
	private Set<Emplacement> emplacements = new HashSet<>();
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nbOfProduct == null) ? 0 : nbOfProduct.hashCode());
		result = prime * result + ((priceTotal == null) ? 0 : priceTotal.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
		result = prime * result + ((volumeSecurity == null) ? 0 : volumeSecurity.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrepot other = (Entrepot) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nbOfProduct == null) {
			if (other.nbOfProduct != null)
				return false;
		} else if (!nbOfProduct.equals(other.nbOfProduct))
			return false;
		if (priceTotal == null) {
			if (other.priceTotal != null)
				return false;
		} else if (!priceTotal.equals(other.priceTotal))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		if (volumeSecurity == null) {
			if (other.volumeSecurity != null)
				return false;
		} else if (!volumeSecurity.equals(other.volumeSecurity))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Entrepot [id=" + id + ", name=" + name + ", nbOfProduct=" + nbOfProduct + ", priceTotal=" + priceTotal
				+ ", volume=" + volume + ", volumeSecurity=" + volumeSecurity + "]";
	}
	
	
}
