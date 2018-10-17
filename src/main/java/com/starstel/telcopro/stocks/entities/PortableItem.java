package com.starstel.telcopro.stocks.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sosthene Nouebissi
 * @version 1.0
 * @created 13-oct.-2018 07:24:20
 */
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class PortableItem implements Serializable
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "PITEM_SEQ", allocationSize = 1, name = "pitem_id")
    @GeneratedValue(generator = "pitem_id")
	private Long id;
	private String codeQrc;
	private String codeBar;
	private String serial;
	private String reference;
	@ManyToOne
	private Portable portable;
}