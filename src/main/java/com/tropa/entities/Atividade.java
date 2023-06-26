package com.tropa.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name = "Atividade")
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private String nome;
    private String descricao;
    private String diaDaSemana;

    private String horarioInicial;

    private String horarioFinal;
    
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;
    
    public Atividade() {
    }

    public Atividade(String nome, String descricao, String diaDaSemana, String horarioInicial, String horarioFinal, Turma turma) {
        this.nome = nome;
        this.descricao = descricao;
        this.diaDaSemana = diaDaSemana;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.turma = turma;
    }

    public int calcularDuracao() {
        long duracaoMinutos = 0;
        
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
            Date horarioFim = dateFormat.parse(this.horarioFinal);
            Date horarioIni = dateFormat.parse(this.horarioFinal);

            long duracaoMilissegundos = horarioFim.getTime() - horarioIni.getTime();
            duracaoMinutos = TimeUnit.MILLISECONDS.toMinutes(duracaoMilissegundos);
            
        } catch (ParseException e) {
            System.out.println("Formato da data incorreto");
        }
        
        return (int) duracaoMinutos;
    }

    public boolean verificarConclusao() {
        Date horarioFim = null;
        Date horarioAtual = null;
        
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
            horarioFim = dateFormat.parse(this.horarioFinal);
            horarioAtual = new Date();
        } catch (ParseException e) {
            System.out.println("Formato da data incorreto");
        }
        
        return horarioAtual != null && horarioAtual.after(horarioFim);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public String getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(String horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public String getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    
}
