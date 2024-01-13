package com.bancosimples.banco.contas;

import com.bancosimples.banco.Banco;
import com.bancosimples.banco.Cliente;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente cliente, Banco banco) {
        super(cliente, banco);
    }
    @Override
    public void sacar(double valor){
        if(valor > this.getSaldo()){
            System.out.println(this.getCliente() + " Não foi possível realizar saque.");
            System.out.printf("Valor do saque %.2f, saldo da conta %.2f %n", valor, this.getSaldo());
        } else {
            super.sacar(valor);
        }
    }
}
