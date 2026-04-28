package com.exemplo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    private String nome;

    private Integer responsavel;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private List<Atividade> atividades;

    public Projeto() {}

    public Projeto(String nome, Integer responsavel) {
        this.nome = nome;
        this.responsavel = responsavel;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Integer responsavel) {
        this.responsavel = responsavel;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }
}