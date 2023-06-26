package com.tropa.entities;

import javax.persistence.*;

@Entity
@Table(name = "Aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private String nome;

    private String dataNascimento;

    private String genero;
    private String observacoes;
    private String naturalidade;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    @OneToOne
    private Mensalidade mensalidade;
    
    @OneToOne
    private Responsavel responsavel;

    public Aluno() {
    }

    public Aluno(String nome, String dataNascimento, String genero, String observacoes, String naturalidade, Turma turma, Mensalidade mensalidade, Responsavel responsavel) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.observacoes = observacoes;
        this.naturalidade = naturalidade;
        this.turma = turma;
        this.mensalidade = mensalidade;
        this.responsavel = responsavel;
    }

    public boolean validarDados() {
        return nome instanceof String;
    }

    public boolean statusMensalidade() {
        return this.mensalidade.pagaEmDia();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public Responsavel getResponsavel() {
        return responsavel;
    }
    
    public void setResponsavel(Responsavel r) {
        this.responsavel = r;
    }

    public Mensalidade getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(Mensalidade mensalidade) {
        this.mensalidade = mensalidade;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }
}