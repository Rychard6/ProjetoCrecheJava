package com.tropa.entities;

import javax.persistence.*;

@Entity
@Table(name = "Responsavel")
public class Responsavel {
    @Id
    @Column(name="cpf")
    private String cpf;
    
    private String nome;
    private String genero;
    private String telefone;
    private double salario;

    public Responsavel() {}

    public Responsavel(String nome, String cpf, String genero, String telefone, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.genero = genero;
        this.telefone = telefone;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}

