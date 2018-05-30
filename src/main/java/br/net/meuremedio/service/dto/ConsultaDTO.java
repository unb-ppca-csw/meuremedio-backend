package br.net.meuremedio.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

/**
 * A DTO for the Consulta result.
 */
public class ConsultaDTO implements Serializable {
	private static final long serialVersionUID = -4569708709757196279L;

	private Long idMedicamento;

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
	private String tarja;

	private BigDecimal precoFabrica;
	private BigDecimal precoConsumidor0;
	private BigDecimal precoConsumidor12;
	private BigDecimal precoConsumidor17;
	private BigDecimal precoConsumidor20;

	private String laboratorioNome;

	private String laboratorioCnpj;

	private String laboratorioRegistro;

	public String getRestricaoHospitalarStr() {
		return restricaoHospitalar ? "Restrição Hospitalar" : "Sem Restrição Hospitalar";
	}

	public Long getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(Long idMedicamento) {
		this.idMedicamento = idMedicamento;
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

	public Boolean getRestricaoHospitalar() {
		return restricaoHospitalar;
	}

	public void setRestricaoHospitalar(Boolean restricaoHospitalar) {
		this.restricaoHospitalar = restricaoHospitalar;
	}

	public String getTarja() {
		return tarja;
	}

	public void setTarja(String tarja) {
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

	public String getLaboratorioNome() {
		return laboratorioNome;
	}

	public void setLaboratorioNome(String laboratorioNome) {
		this.laboratorioNome = laboratorioNome;
	}

	public String getLaboratorioCnpj() {
		return laboratorioCnpj;
	}

	public void setLaboratorioCnpj(String laboratorioCnpj) {
		this.laboratorioCnpj = laboratorioCnpj;
	}

	public String getLaboratorioRegistro() {
		return laboratorioRegistro;
	}

	public void setLaboratorioRegistro(String laboratorioRegistro) {
		this.laboratorioRegistro = laboratorioRegistro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apresentacao == null) ? 0 : apresentacao.hashCode());
		result = prime * result + ((classeTerapeutica == null) ? 0 : classeTerapeutica.hashCode());
		result = prime * result + ((idMedicamento == null) ? 0 : idMedicamento.hashCode());
		result = prime * result + ((laboratorioCnpj == null) ? 0 : laboratorioCnpj.hashCode());
		result = prime * result + ((laboratorioNome == null) ? 0 : laboratorioNome.hashCode());
		result = prime * result + ((laboratorioRegistro == null) ? 0 : laboratorioRegistro.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((precoConsumidor0 == null) ? 0 : precoConsumidor0.hashCode());
		result = prime * result + ((precoConsumidor12 == null) ? 0 : precoConsumidor12.hashCode());
		result = prime * result + ((precoConsumidor17 == null) ? 0 : precoConsumidor17.hashCode());
		result = prime * result + ((precoConsumidor20 == null) ? 0 : precoConsumidor20.hashCode());
		result = prime * result + ((precoFabrica == null) ? 0 : precoFabrica.hashCode());
		result = prime * result + ((principioAtivo == null) ? 0 : principioAtivo.hashCode());
		result = prime * result + ((restricaoHospitalar == null) ? 0 : restricaoHospitalar.hashCode());
		result = prime * result + ((tarja == null) ? 0 : tarja.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaDTO other = (ConsultaDTO) obj;
		if (apresentacao == null) {
			if (other.apresentacao != null)
				return false;
		} else if (!apresentacao.equals(other.apresentacao))
			return false;
		if (classeTerapeutica == null) {
			if (other.classeTerapeutica != null)
				return false;
		} else if (!classeTerapeutica.equals(other.classeTerapeutica))
			return false;
		if (idMedicamento == null) {
			if (other.idMedicamento != null)
				return false;
		} else if (!idMedicamento.equals(other.idMedicamento))
			return false;
		if (laboratorioCnpj == null) {
			if (other.laboratorioCnpj != null)
				return false;
		} else if (!laboratorioCnpj.equals(other.laboratorioCnpj))
			return false;
		if (laboratorioNome == null) {
			if (other.laboratorioNome != null)
				return false;
		} else if (!laboratorioNome.equals(other.laboratorioNome))
			return false;
		if (laboratorioRegistro == null) {
			if (other.laboratorioRegistro != null)
				return false;
		} else if (!laboratorioRegistro.equals(other.laboratorioRegistro))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (precoConsumidor0 == null) {
			if (other.precoConsumidor0 != null)
				return false;
		} else if (!precoConsumidor0.equals(other.precoConsumidor0))
			return false;
		if (precoConsumidor12 == null) {
			if (other.precoConsumidor12 != null)
				return false;
		} else if (!precoConsumidor12.equals(other.precoConsumidor12))
			return false;
		if (precoConsumidor17 == null) {
			if (other.precoConsumidor17 != null)
				return false;
		} else if (!precoConsumidor17.equals(other.precoConsumidor17))
			return false;
		if (precoConsumidor20 == null) {
			if (other.precoConsumidor20 != null)
				return false;
		} else if (!precoConsumidor20.equals(other.precoConsumidor20))
			return false;
		if (precoFabrica == null) {
			if (other.precoFabrica != null)
				return false;
		} else if (!precoFabrica.equals(other.precoFabrica))
			return false;
		if (principioAtivo == null) {
			if (other.principioAtivo != null)
				return false;
		} else if (!principioAtivo.equals(other.principioAtivo))
			return false;
		if (restricaoHospitalar == null) {
			if (other.restricaoHospitalar != null)
				return false;
		} else if (!restricaoHospitalar.equals(other.restricaoHospitalar))
			return false;
		if (tarja == null) {
			if (other.tarja != null)
				return false;
		} else if (!tarja.equals(other.tarja))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConsultaDTO [idMedicamento=" + idMedicamento + ", nome=" + nome + ", principioAtivo=" + principioAtivo
				+ ", apresentacao=" + apresentacao + ", classeTerapeutica=" + classeTerapeutica + ", tipo=" + tipo
				+ ", restricaoHospitalar=" + restricaoHospitalar + ", tarja=" + tarja + ", precoFabrica=" + precoFabrica
				+ ", precoConsumidor0=" + precoConsumidor0 + ", precoConsumidor12=" + precoConsumidor12
				+ ", precoConsumidor17=" + precoConsumidor17 + ", precoConsumidor20=" + precoConsumidor20
				+ ", laboratorioNome=" + laboratorioNome + ", laboratorioCnpj=" + laboratorioCnpj
				+ ", laboratorioRegistro=" + laboratorioRegistro + "]";
	}

}
