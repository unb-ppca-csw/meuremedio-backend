package br.net.meuremedio.service.dto;


import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;

/**
 * A DTO for the Laboratorio entity.
 */
public class LaboratorioDTO implements Serializable {

    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String cnpj;

    private String codigoGGREM;

    @NotNull
    private String registro;

    private String ean;

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCodigoGGREM() {
        return codigoGGREM;
    }

    public void setCodigoGGREM(String codigoGGREM) {
        this.codigoGGREM = codigoGGREM;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LaboratorioDTO laboratorioDTO = (LaboratorioDTO) o;
        if(laboratorioDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), laboratorioDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "LaboratorioDTO{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", cnpj='" + getCnpj() + "'" +
            ", codigoGGREM='" + getCodigoGGREM() + "'" +
            ", registro='" + getRegistro() + "'" +
            ", ean='" + getEan() + "'" +
            "}";
    }
}
