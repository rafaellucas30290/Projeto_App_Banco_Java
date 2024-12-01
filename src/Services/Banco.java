package Services;

import java.util.ArrayList;
import java.util.List;
import Model.*;
import Interface.*;

public class Banco implements BancoOperacoes {
    private final List<Conta> contas;

    public Banco() {            
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    @Override
    public void depositar(Conta conta, double valor) {
        conta.setSaldo(conta.getSaldo() + valor);
    }

    @Override
    public void sacar(Conta conta, double valor) {
        if (conta.getSaldo() >= valor) {
            conta.setSaldo(conta.getSaldo() - valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void transferir(Conta origem, Conta destino, double valor) {
        if (origem.getSaldo() >= valor) {
            sacar(origem, valor);
            depositar(destino, valor);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public List<Conta> getContas() {
        return contas;
    }
}
