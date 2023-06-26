package com.tropa.entities;

import javax.persistence.*;

@Entity
@Table(name = "Secretaria")
public class Secretaria extends Funcionario {

    private String senha;
    private double comissao;
    private double salarioAnual;

    public Secretaria() {
    }

    public Secretaria(String CPF, String nome, String dataNascimento, String genero, String endereco, String telefone, String cargo, double salario, String senha, double comissao) {
        super(CPF, nome, dataNascimento, genero, endereco, telefone, cargo, salario);
        this.senha = senha;
        this.comissao = comissao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public double calcularSalarioAnual() {
        salarioAnual = (this.getSalario() + this.comissao) * 12;
        return this.salarioAnual;
    }
}
