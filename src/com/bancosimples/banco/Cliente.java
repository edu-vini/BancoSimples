package com.bancosimples.banco;

import com.bancosimples.banco.contas.Conta;
import com.bancosimples.exceptions.ClienteJaTemContaCorrenteException;
import com.bancosimples.exceptions.ClienteJaTemContaPoupancaException;

public class Cliente {
    private final String nome;
    private Conta contaPoupanca;
    private Conta contaCorrente;

    public Cliente(String nome){
        this.nome = nome;
    }

    public void solicitarContaCorrente(Banco banco){
        try {
            this.contaCorrente = banco.criarContaCorrente(this);
        } catch (ClienteJaTemContaCorrenteException e) {
            System.out.println("Não foi possível criar conta corrente. Cliente já possui uma.");
        }
    }

    public void solicitarContaPoupanca(Banco banco){
        try {
            this.contaPoupanca = banco.criarContaPoupanca(this);
        } catch (ClienteJaTemContaPoupancaException e) {
            System.out.println("Não foi possível criar conta poupança. Cliente já possui uma.");
        }
    }

    public String getNome() {
        return nome;
    }

    public Conta getContaPoupanca() {
        return contaPoupanca;
    }

    public Conta getContaCorrente() {
        return contaCorrente;
    }

    @Override
    public String toString() {
        return nome;
    }
}
