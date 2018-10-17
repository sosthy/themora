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
 * @created 13-oct.-2018 07:23:42
 */
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Camera implements Serializable
{
	@Id
	@SequenceGenerator(initialValue = 1, sequenceName = "CAM_SEQ", allocationSize = 1, name = "cam_id")
    @GeneratedValue(generator = "cam_id")
	private Long id;
	private Double frontCamera;
	private Double backCamera;
}