package Interface;

import Model.Conta;

public interface BancoOperacoes {
    void depositar(Conta conta, double valor);
    void sacar(Conta conta, double valor);
    void transferir(Conta origem, Conta destino, double valor);
}