package com.starstel.telcopro.stocks.entities;

import java.io.Serializable;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sosthene Nouebissi
 * @version 1.0
 * @created 13-oct.-2018 07:24:22
 */
// @Entity
// @Data @AllArgsConstructor @NoArgsConstructor
public class PortableUnit implements Serializable
{
	private Long id;
	private String name;
}