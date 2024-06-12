package com.repliforce.entities;

import java.util.Date;

public class Rent {

	private User user;
	private Movie movie;
	private Date dataLocacao;
	private Date dataRetorno;
	private Double valor;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	public Date getDataRetorno() {
		return dataRetorno;
	}
	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Movie getFilme() {
		return movie;
	}
	public void setMovie(Movie filme) {
		this.movie = filme;
	}
}