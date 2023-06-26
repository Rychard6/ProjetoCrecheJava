package com.tropa.entities;

import javax.persistence.*;

@Entity
@Table(name = "Turma")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int capacidade;

    @OneToOne
    private Professor professor;
    private String turno;
    private int idadeMaxima;

    public Turma() {}

    public Turma(String nome, int capacidade, Professor professor, String turno, int idadeMaxima) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.professor = professor;
        this.turno = turno;
        this.idadeMaxima = idadeMaxima;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean haVagas() {
        return this.capacidade > 0;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getIdadeMaxima() {
        return idadeMaxima;
    }

    public void setIdadeMaxima(int idadeMaxima) {
        this.idadeMaxima = idadeMaxima;
    }
}