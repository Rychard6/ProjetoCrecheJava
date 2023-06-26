package com.tropa.entities;

import javax.persistence.*;

@Entity
@Table(name = "Professor")
public class Professor extends Funcionario {
    private double salarioAnual;
    private String grauAcademico;

    public Professor() {
    }

    public Professor(String CPF, String nome, String dataNascimento, String genero, String endereco, String telefone, String cargo, double salario, String grauAcademico) {
        super(CPF, nome, dataNascimento, genero, endereco, telefone, cargo, salario);
        this.grauAcademico = grauAcademico;
    }

    public String getGrauAcademico() {
        return grauAcademico;
    }

    public void setGrauAcademico(String grauAcademico) {
        this.grauAcademico = grauAcademico;
    }

    @Override
    public double calcularSalarioAnual() {
        if ("graduado".equals(this.grauAcademico)) {
            salarioAnual = this.salario * 1.1;
        } else if ("pos-graduado".equals(this.grauAcademico)) {
            salarioAnual = this.salario * 1.3;
        } else if ("mestre".equals(this.grauAcademico)) {
            salarioAnual = this.salario * 1.5;
        } else if ("doutor".equals(this.grauAcademico)) {
            salarioAnual = this.salario * 1.8;
        }
        return salarioAnual * 12;
    }
}
