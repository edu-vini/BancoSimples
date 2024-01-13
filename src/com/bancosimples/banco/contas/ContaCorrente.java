package com.bancosimples.banco.contas;

import com.bancosimples.banco.Banco;
import com.bancosimples.banco.Cliente;

public class ContaCorrente extends Conta{
    public ContaCorrente(Cliente cliente, Banco banco) {
        super(cliente, banco);
    }
    @Override
    public void sacar(double valor){

        if(valor > this.getSaldo()){
            System.out.println(this.getCliente() + " Sua conta não tem saldo suficiente. Você entrará em cheque especial!");
            System.out.printf("Valor do saque %.2f, saldo da conta %.2f %n", valor, this.getSaldo());
        }
        super.sacar(valor);
    }
}
