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
 * @created 13-oct.-2018 07:24:36
 */
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class SystemOS implements Serializable
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "SYSOS_SEQ", allocationSize = 1, name = "sysos_id")
    @GeneratedValue(generator = "sysos_id")
	private Long id;
	private String name;
	private String version;
}