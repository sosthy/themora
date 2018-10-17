package com.starstel.telcopro.stocks.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sosthene Nouebissi
 * @version 1.0
 * @created 13-oct.-2018 07:24:02
 */
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Memoire implements Serializable
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "MEMO_SEQ", allocationSize = 1, name = "memo_id")
    @GeneratedValue(generator = "memo_id")
	private Long id;
	private Double ram;
	private Double rom;
	private String brand;
}