package br.net.meuremedio.service.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import br.net.meuremedio.domain.enumeration.FaixaEtaria;
import br.net.meuremedio.domain.enumeration.Sexo;

/**
 * A DTO for the Comentario entity.
 */
public class ComentarioDTO implements Serializable {

	private Long id;

	// @NotNull
	private Timestamp data;

	@NotNull
	private String nome;

	@NotNull
	private String email;

	@NotNull
	@Lob
	private String comentario;

	@NotNull
	private FaixaEtaria faixaEtaria;

	@NotNull
	private Sexo sexo;

	public String getFaixaEtariaLabel() {
		return faixaEtaria.getLabel();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public FaixaEtaria getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(FaixaEtaria faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		ComentarioDTO comentarioDTO = (ComentarioDTO) o;
		if (comentarioDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), comentarioDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "ComentarioDTO [id=" + id + ", data=" + data + ", nome=" + nome + ", email=" + email + ", comentario="
				+ comentario + ", faixaEtaria=" + faixaEtaria + ", sexo=" + sexo + "]";
	}

}
