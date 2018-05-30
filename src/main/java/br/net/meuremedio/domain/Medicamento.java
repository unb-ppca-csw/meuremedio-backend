package br.net.meuremedio.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.net.meuremedio.domain.enumeration.Tarja;

/**
 * A Medicamento.
 */
@Entity
@Table(name = "tb_medicamento")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
    @Column(name = "principio_ativo", nullable = false, length=512)
    private String principioAtivo;

    @NotNull
    @Column(name = "apresentacao", nullable = false)
    private String apresentacao;

    @Column(name = "classe_terapeutica")
    private String classeTerapeutica;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "restricao_hospitalar")
    private Boolean restricaoHospitalar;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tarja", nullable = false)
    private Tarja tarja;

    @NotNull
    @DecimalMin(value = "0")
    @Column(name = "preco_fabrica", precision=10, scale=2, nullable = false)
    private BigDecimal precoFabrica;

    @DecimalMin(value = "0")
    @Column(name = "preco_consumidor_0", precision=10, scale=2)
    private BigDecimal precoConsumidor0;
    
    @DecimalMin(value = "0")
    @Column(name = "preco_consumidor_12", precision=10, scale=2)
    private BigDecimal precoConsumidor12;
    
    @DecimalMin(value = "0")
    @Column(name = "preco_consumidor_17", precision=10, scale=2)
    private BigDecimal precoConsumidor17;
    
    @DecimalMin(value = "0")
    @Column(name = "preco_consumidor_20", precision=10, scale=2)
    private BigDecimal precoConsumidor20;

    @OneToMany(mappedBy = "medicamento")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Denuncia> denuncias = new HashSet<>();

    @ManyToOne
    private Laboratorio laboratorio;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Medicamento nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public Medicamento principioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
        return this;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getApresentacao() {
        return apresentacao;
    }

    public Medicamento apresentacao(String apresentacao) {
        this.apresentacao = apresentacao;
        return this;
    }

    public void setApresentacao(String apresentacao) {
        this.apresentacao = apresentacao;
    }

    public String getClasseTerapeutica() {
        return classeTerapeutica;
    }

    public Medicamento classeTerapeutica(String classeTerapeutica) {
        this.classeTerapeutica = classeTerapeutica;
        return this;
    }

    public void setClasseTerapeutica(String classeTerapeutica) {
        this.classeTerapeutica = classeTerapeutica;
    }

    public String getTipo() {
        return tipo;
    }

    public Medicamento tipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean isRestricaoHospitalar() {
        return restricaoHospitalar;
    }

    public Medicamento restricaoHospitalar(Boolean restricaoHospitalar) {
        this.restricaoHospitalar = restricaoHospitalar;
        return this;
    }

    public void setRestricaoHospitalar(Boolean restricaoHospitalar) {
        this.restricaoHospitalar = restricaoHospitalar;
    }

    public Tarja getTarja() {
        return tarja;
    }

    public Medicamento tarja(Tarja tarja) {
        this.tarja = tarja;
        return this;
    }

    public void setTarja(Tarja tarja) {
        this.tarja = tarja;
    }

    public BigDecimal getPrecoFabrica() {
        return precoFabrica;
    }

    public Medicamento precoFabrica(BigDecimal precoFabrica) {
        this.precoFabrica = precoFabrica;
        return this;
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

	public Boolean getRestricaoHospitalar() {
		return restricaoHospitalar;
	}

	public Set<Denuncia> getDenuncias() {
        return denuncias;
    }

    public Medicamento denuncias(Set<Denuncia> denuncias) {
        this.denuncias = denuncias;
        return this;
    }

    public Medicamento addDenuncia(Denuncia denuncia) {
        this.denuncias.add(denuncia);
        denuncia.setMedicamento(this);
        return this;
    }

    public Medicamento removeDenuncia(Denuncia denuncia) {
        this.denuncias.remove(denuncia);
        denuncia.setMedicamento(null);
        return this;
    }

    public void setDenuncias(Set<Denuncia> denuncias) {
        this.denuncias = denuncias;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public Medicamento laboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
        return this;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Medicamento medicamento = (Medicamento) o;
        if (medicamento.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), medicamento.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Medicamento{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", principioAtivo='" + getPrincipioAtivo() + "'" +
            ", apresentacao='" + getApresentacao() + "'" +
            ", classeTerapeutica='" + getClasseTerapeutica() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", restricaoHospitalar='" + isRestricaoHospitalar() + "'" +
            ", tarja='" + getTarja() + "'" +
            ", precoFabrica=" + getPrecoFabrica() +
            ", precoMaximo=" + getPrecoConsumidor20() +
            "}";
    }
}
