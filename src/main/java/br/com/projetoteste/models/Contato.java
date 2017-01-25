package br.com.projetoteste.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(name = "CONTATO_SEQUENCE", sequenceName = "CONTATO_SEQUENCE", allocationSize = 1, initialValue = 0)
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQUENCE")
	private Integer id;
	private String nome;
	private String email;
	private String endereco;
	private String telefone;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataNasc;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="usuario_id")
	@JsonIgnore
	Usuario usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
}
