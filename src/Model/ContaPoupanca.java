package Model;

public class ContaPoupanca extends Conta {
    private static final double RENDIMENTO = 0.02;

    public ContaPoupanca(int numero, Cliente titular) {
        super(numero, titular);
    }

    @Override
    public void aplicarTaxa() {
        setSaldo(getSaldo() + (getSaldo() * RENDIMENTO));
    }
}
