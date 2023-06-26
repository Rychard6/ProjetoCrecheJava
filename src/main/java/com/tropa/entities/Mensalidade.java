package com.tropa.entities;

import com.tropa.interfaces.Pagamento;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Mensalidade")
public class Mensalidade implements Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "dataVencimento")
    private String dataVencimento;

    @Column(name = "dataPagamento")
    private String dataPagamento;

    @Column(name = "paga")
    private Integer paga;

    @Column(name = "valor")
    private Double valor;

    public Mensalidade() {
    }

    public Mensalidade(String dataVencimento, String dataPagamento, Integer paga, Double valor) {
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.paga = paga;
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return "Mensalidade{" +
                "codigo=" + codigo +
                ", dataVencimento='" + dataVencimento + '\'' +
                ", dataPagamento='" + dataPagamento + '\'' +
                ", paga=" + paga +
                ", valor=" + valor +
                '}';
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Integer getPaga() {
        return paga;
    }

    public void setPaga(Integer paga) {
        this.paga = paga;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public void realizarPagamento() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.dataPagamento = dateFormat.format(new Date());
        this.paga = 1;
    }

    @Override
    public boolean pagaEmDia() {
        return (dataPagamento != null && dataPagamento.compareTo(dataVencimento) <= 0);
    }

    @Override
    public double calcularMulta() {
        if (!pagaEmDia()) {
            return valor * 0.05;
        }
        return 0.0;
    }
}
