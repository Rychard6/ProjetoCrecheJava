package com.tropa.entities;

import javax.persistence.*;

@Entity
@Table(name = "Monitor")
public class Monitor extends Funcionario {
    private String funcao;

    public Monitor() {
    }

    public Monitor(String CPF, String nome, String dataNascimento, String genero, String endereco, String telefone, String cargo, double salario, String funcao) {
        super(CPF, nome, dataNascimento, genero, endereco, telefone, cargo, salario);
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public double calcularSalarioAnual() {
        double salarioAnual;
        if ("Corrigir provas".equals(this.funcao)) {
            salarioAnual = this.salario * 1.1;
        } else {
            salarioAnual = this.salario * 1.05;
        }
        return salarioAnual * 12;
    }
}
