package com.bancosimples.banco.contas;

import com.bancosimples.banco.Banco;
import com.bancosimples.banco.Cliente;
import com.bancosimples.banco.interfaces.IConta;

public abstract class Conta implements IConta {
    private final int agencia;
    private final int numero;
    private double saldo;
    private final Cliente cliente;
    private final Banco banco;

    public Conta(Cliente cliente, Banco banco){
        this.agencia = banco.AGENCIA;
        this.numero = banco.CONTADOR_NUMERO_CONTA++;
        this.cliente = cliente;
        this.banco = banco;
    }


    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }
    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {

        String conta = this instanceof ContaCorrente ? "Conta Corrente" : "Conta Poupança";
        return String.format("%s %s {%n cliente: %s%n agencia: %d%n numero: %d%n saldo: %.2f %n}", conta, this.banco.getNome(), this.cliente, this.agencia, this.numero, this.saldo);
    }
}
