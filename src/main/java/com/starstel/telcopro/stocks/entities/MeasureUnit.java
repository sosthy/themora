package com.starstel.telcopro.stocks.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class MeasureUnit implements Serializable 
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "MES_SEQ", allocationSize = 1, name = "mes_id")
    @GeneratedValue(generator = "mes_id")
	private Long id;
	private String unity;
}
