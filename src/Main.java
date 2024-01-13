import com.bancosimples.banco.Banco;
import com.bancosimples.banco.Cliente;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Banco bCaixa = new Banco("Caixa");
        Banco bBradesco = new Banco("Bradesco");

        Cliente vinicius = new Cliente("Vinicius");
        Cliente joao = new Cliente("Joao");

        vinicius.solicitarContaCorrente(bCaixa);
        joao.solicitarContaPoupanca(bBradesco);

        System.out.println("João e Vinicius criaram contas em bancos diferentes.");

        vinicius.getContaCorrente().sacar(100);
        System.out.println("Vinicius sacou 100 reais de sua conta.");
        joao.getContaPoupanca().depositar(500);
        System.out.println("João depositou 500 reais na sua conta.");

        joao.getContaPoupanca().transferir(100,vinicius.getContaCorrente());
        System.out.println("João percebendo que o saldo do seu amigo ficou negativo, resolveu ajuda-lo a sair do negativo transferindo 100 reais.");

        System.out.println(vinicius.getContaCorrente());
        System.out.println(joao.getContaPoupanca());

    }
}