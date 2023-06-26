package com.tropa.entities;

import javax.persistence.*;

@Entity
@Table(name = "Funcionario")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Funcionario {
    @Id
    @Column(name="CPF")
    protected String CPF;
    protected String nome;
    protected String dataNascimento;
    protected String genero;
    protected String endereco;
    protected String telefone;
    protected String cargo;
    protected double salario;

    public Funcionario() {
    }

    public Funcionario(String CPF, String nome, String dataNascimento, String genero, String endereco, String telefone, String cargo, double salario) {
        this.CPF = CPF;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cargo = cargo;
        this.salario = salario;
    }

    public boolean verificarPromocao() {
        return true;
    }

    public abstract double calcularSalarioAnual();

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
