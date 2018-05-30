package br.net.meuremedio.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A DTO for the Denuncia entity.
 */
public class DenunciaDTO implements Serializable {

	private Long id;

	// @NotNull
	private Timestamp data;

	@NotNull
	private String farmacia;

	@NotNull
	@DecimalMin(value = "0")
	private BigDecimal preco;

	@Size(max = 512)
	private String texto;

	private String nome;

	private String email;

	@NotNull
	private Long medicamentoId;

	private String medicamentoNome;

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

	public String getFarmacia() {
		return farmacia;
	}

	public void setFarmacia(String farmacia) {
		this.farmacia = farmacia;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
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

	public Long getMedicamentoId() {
		return medicamentoId;
	}

	public void setMedicamentoId(Long medicamentoId) {
		this.medicamentoId = medicamentoId;
	}

	public String getMedicamentoNome() {
		return medicamentoNome;
	}

	public void setMedicamentoNome(String medicamentoNome) {
		this.medicamentoNome = medicamentoNome;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		DenunciaDTO denunciaDTO = (DenunciaDTO) o;
		if (denunciaDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), denunciaDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "DenunciaDTO{" + "id=" + getId() + ", data='" + getData() + "'" + ", farmacia='" + getFarmacia() + "'"
				+ ", preco=" + getPreco() + ", texto='" + getTexto() + "'" + ", nome='" + getNome() + "'" + ", email='"
				+ getEmail() + "'" + "}";
	}
}
