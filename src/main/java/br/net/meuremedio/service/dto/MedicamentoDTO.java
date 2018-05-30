package br.net.meuremedio.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import br.net.meuremedio.domain.enumeration.Tarja;

/**
 * A DTO for the Medicamento entity.
 */
public class MedicamentoDTO implements Serializable {

	private Long id;

	@NotNull
	private String nome;

	@NotNull
	private String principioAtivo;

	@NotNull
	private String apresentacao;

	private String classeTerapeutica;

	private String tipo;

	private Boolean restricaoHospitalar;

	@NotNull
	private Tarja tarja;

	@NotNull
	@DecimalMin(value = "0")
	private BigDecimal precoFabrica;

	@DecimalMin(value = "0")
	private BigDecimal precoConsumidor0;

	@DecimalMin(value = "0")
	private BigDecimal precoConsumidor12;

	@DecimalMin(value = "0")
	private BigDecimal precoConsumidor17;

	@DecimalMin(value = "0")
	private BigDecimal precoConsumidor20;

	private Long laboratorioId;

	private String laboratorioNome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPrincipioAtivo() {
		return principioAtivo;
	}

	public void setPrincipioAtivo(String principioAtivo) {
		this.principioAtivo = principioAtivo;
	}

	public String getApresentacao() {
		return apresentacao;
	}

	public void setApresentacao(String apresentacao) {
		this.apresentacao = apresentacao;
	}

	public String getClasseTerapeutica() {
		return classeTerapeutica;
	}

	public void setClasseTerapeutica(String classeTerapeutica) {
		this.classeTerapeutica = classeTerapeutica;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Boolean isRestricaoHospitalar() {
		return restricaoHospitalar;
	}

	public Boolean getRestricaoHospitalar() {
		return restricaoHospitalar;
	}

	public void setRestricaoHospitalar(Boolean restricaoHospitalar) {
		this.restricaoHospitalar = restricaoHospitalar;
	}

	public Tarja getTarja() {
		return tarja;
	}

	public void setTarja(Tarja tarja) {
		this.tarja = tarja;
	}

	public BigDecimal getPrecoFabrica() {
		return precoFabrica;
	}

	public void setPrecoFabrica(BigDecimal precoFabrica) {
		this.precoFabrica = precoFabrica;
	}

	public BigDecimal getPrecoConsumidor0() {
		return precoConsumidor0;
	}

	public void setPrecoConsumidor0(BigDecimal precoConsumidor0) {
		this.precoConsumidor0 = precoConsumidor0;
	}

	public BigDecimal getPrecoConsumidor12() {
		return precoConsumidor12;
	}

	public void setPrecoConsumidor12(BigDecimal precoConsumidor12) {
		this.precoConsumidor12 = precoConsumidor12;
	}

	public BigDecimal getPrecoConsumidor17() {
		return precoConsumidor17;
	}

	public void setPrecoConsumidor17(BigDecimal precoConsumidor17) {
		this.precoConsumidor17 = precoConsumidor17;
	}

	public BigDecimal getPrecoConsumidor20() {
		return precoConsumidor20;
	}

	public void setPrecoConsumidor20(BigDecimal precoConsumidor20) {
		this.precoConsumidor20 = precoConsumidor20;
	}

	public Long getLaboratorioId() {
		return laboratorioId;
	}

	public void setLaboratorioId(Long laboratorioId) {
		this.laboratorioId = laboratorioId;
	}

	public String getLaboratorioNome() {
		return laboratorioNome;
	}

	public void setLaboratorioNome(String laboratorioNome) {
		this.laboratorioNome = laboratorioNome;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		MedicamentoDTO medicamentoDTO = (MedicamentoDTO) o;
		if (medicamentoDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), medicamentoDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "MedicamentoDTO [id=" + id + ", nome=" + nome + ", principioAtivo=" + principioAtivo + ", apresentacao="
				+ apresentacao + ", classeTerapeutica=" + classeTerapeutica + ", tipo=" + tipo
				+ ", restricaoHospitalar=" + restricaoHospitalar + ", tarja=" + tarja + ", precoFabrica=" + precoFabrica
				+ ", precoConsumidor0=" + precoConsumidor0 + ", precoConsumidor12=" + precoConsumidor12
				+ ", precoConsumidor17=" + precoConsumidor17 + ", precoConsumidor20=" + precoConsumidor20
				+ ", laboratorioId=" + laboratorioId + ", laboratorioNome=" + laboratorioNome + "]";
	}

}
