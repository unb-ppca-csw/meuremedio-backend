package br.net.meuremedio.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Denuncia.
 */
@Entity
@Table(name = "tb_denuncia")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Denuncia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "data", nullable = false)
    private Timestamp data;

    @NotNull
    @Column(name = "farmacia", nullable = false)
    private String farmacia;

    @DecimalMin(value = "0")
    @Column(name = "preco", precision=10, scale=2)
    private BigDecimal preco;

    @Size(max = 512)
    @Column(name = "texto", length = 512)
    private String texto;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @ManyToOne
    private Medicamento medicamento;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getData() {
        return data;
    }

    public Denuncia data(Timestamp data) {
        this.data = data;
        return this;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public String getFarmacia() {
        return farmacia;
    }

    public Denuncia farmacia(String farmacia) {
        this.farmacia = farmacia;
        return this;
    }

    public void setFarmacia(String farmacia) {
        this.farmacia = farmacia;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Denuncia preco(BigDecimal preco) {
        this.preco = preco;
        return this;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getTexto() {
        return texto;
    }

    public Denuncia texto(String texto) {
        this.texto = texto;
        return this;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getNome() {
        return nome;
    }

    public Denuncia nome(String nome) {
        this.nome = nome;
        return this;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public Denuncia email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public Denuncia medicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
        return this;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
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
        Denuncia denuncia = (Denuncia) o;
        if (denuncia.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), denuncia.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Denuncia{" +
            "id=" + getId() +
            ", data='" + getData() + "'" +
            ", farmacia='" + getFarmacia() + "'" +
            ", preco=" + getPreco() +
            ", texto='" + getTexto() + "'" +
            ", nome='" + getNome() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }
}
