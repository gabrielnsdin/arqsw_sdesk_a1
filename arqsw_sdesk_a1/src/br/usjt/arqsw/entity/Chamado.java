package br.usjt.arqsw.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Gabriel do Nascimento RA 816113722
 *
 */
public class Chamado {
	
	private int id;
	
	@NotNull
	@Size(min=5, max=60, message="O chamdado de ter uma descrição entre 5 e 60 caracteres.")
	private String descricao;
	
	private String status;
	private Date dtAbertura;
	private Date dtFechamento;
	
	@NotNull(message="Selecione uma fila de acordo com o tipo do chamado.")
	private Fila fila;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(Date dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public Date getDtFechamento() {
		return dtFechamento;
	}

	public void setDtFechamento(Date dtFechamento) {
		this.dtFechamento = dtFechamento;
	}

	public Fila getFila() {
		return fila;
	}

	public void setFila(Fila fila) {
		this.fila = fila;
	}

	@Override
	public String toString() {
		return "Chamado [id=" + id + ", descricao=" + descricao + ", status=" + status + ", dtAbertura=" + dtAbertura
				+ ", dtFechamento=" + dtFechamento + ", fila=" + fila + "]";
	}
	

	/*
	 * public static void main(String[] args) { Timestamp dataDeHoje = new
	 * Timestamp(System.currentTimeMillis()); DateFormat dateFormat = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String data =
	 * dateFormat.format(dataDeHoje).toString();
	 * 
	 * System.out.println(data); System.out.println(dataDeHoje); }
	 */

}
