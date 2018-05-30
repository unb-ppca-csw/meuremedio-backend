package br.net.meuremedio.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A Laboratorio.
 */
@Entity
@Table(name = "tb_laboratorio")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Laboratorio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @Column(name = "codigo_ggrem")
    private String codigoGGREM;

    @NotNull
    @Column(name = "registro", nullable = false)
    private String registro;

    @Column(name = "ean")
    private String ean;

    @OneToMany(mappedBy = "laboratorio")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Medicamento> medicamentos = new HashSet<>();

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

    public Laboratorio nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Laboratorio cnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCodigoGGREM() {
        return codigoGGREM;
    }

    public Laboratorio codigoGGREM(String codigoGGREM) {
        this.codigoGGREM = codigoGGREM;
        return this;
    }

    public void setCodigoGGREM(String codigoGGREM) {
        this.codigoGGREM = codigoGGREM;
    }

    public String getRegistro() {
        return registro;
    }

    public Laboratorio registro(String registro) {
        this.registro = registro;
        return this;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getEan() {
        return ean;
    }

    public Laboratorio ean(String ean) {
        this.ean = ean;
        return this;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public Set<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public Laboratorio medicamentos(Set<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
        return this;
    }

    public Laboratorio addMedicamento(Medicamento medicamento) {
        this.medicamentos.add(medicamento);
        medicamento.setLaboratorio(this);
        return this;
    }

    public Laboratorio removeMedicamento(Medicamento medicamento) {
        this.medicamentos.remove(medicamento);
        medicamento.setLaboratorio(null);
        return this;
    }

    public void setMedicamentos(Set<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
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
        Laboratorio laboratorio = (Laboratorio) o;
        if (laboratorio.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), laboratorio.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Laboratorio{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", cnpj='" + getCnpj() + "'" +
            ", codigoGGREM='" + getCodigoGGREM() + "'" +
            ", registro='" + getRegistro() + "'" +
            ", ean='" + getEan() + "'" +
            "}";
    }
}
