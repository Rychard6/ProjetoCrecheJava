package com.tropa.interfaces;

public interface Pagamento {
    void realizarPagamento();

    boolean pagaEmDia();

    double calcularMulta();
}