package com.bancosimples.banco;

import com.bancosimples.banco.contas.Conta;
import com.bancosimples.banco.contas.ContaCorrente;
import com.bancosimples.banco.contas.ContaPoupanca;
import com.bancosimples.exceptions.ClienteJaTemContaCorrenteException;
import com.bancosimples.exceptions.ClienteJaTemContaPoupancaException;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private final String nome;
    private List<Conta> contas = new ArrayList<Conta>();
    public final int AGENCIA = 1;
    public int CONTADOR_NUMERO_CONTA = 1;
    public Banco(String nome){
        this.nome = nome;
    }

    protected Conta criarContaCorrente(Cliente cliente) throws ClienteJaTemContaCorrenteException {
        if(cliente.getContaCorrente() == null){
            Conta conta = new ContaCorrente(cliente, this);
            this.contas.add(conta);
            return conta;
        } else {
            throw new ClienteJaTemContaCorrenteException();
        }
    }

    protected Conta criarContaPoupanca(Cliente cliente) throws ClienteJaTemContaPoupancaException {
        if(cliente.getContaPoupanca() == null){
            Conta conta = new ContaPoupanca(cliente, this);
            this.contas.add(conta);
            return conta;
        } else {
            throw new ClienteJaTemContaPoupancaException();
        }
    }

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return contas;
    }
}
