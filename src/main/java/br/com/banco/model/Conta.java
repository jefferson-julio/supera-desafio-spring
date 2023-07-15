package br.com.banco.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CONTA")
public class Conta {

    @Id
    private Integer idConta;

    @Column(nullable = false, length = 50)
    private String nomeResponsavel;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Transferencia> transferencias;

    public Integer getIdConta() {
        return this.idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public String getNomeResponsavel() {
        return this.nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

}
