package com.devsuperior.dsmovie.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")
public class Score implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ScorePK id = new ScorePK();
	private Double value;

	public Score() {
	}
	
	public Score(Movie movie, User user, Double value) {
		this.id.setMovie(movie);
		this.id.setUser(user);
		this.value = value;
	}

	public void setIdMovie(Movie movie) {
		this.id.setMovie(movie);
	}

	public void setIdUser(User user) {
		this.id.setUser(user);
	}

	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
