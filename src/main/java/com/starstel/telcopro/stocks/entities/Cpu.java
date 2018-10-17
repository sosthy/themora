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
 * @created 13-oct.-2018 07:23:47
 */
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Cpu implements Serializable
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "CPU_SEQ", allocationSize = 1, name = "cpu_id")
    @GeneratedValue(generator = "cpu_id")
	private Long id;
	private String brand;
	private Double frequency;
}