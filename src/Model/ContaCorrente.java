package Model;

public class ContaCorrente extends Conta {
    private static final double TAXA = 5.0;

    public ContaCorrente(int numero, Cliente titular) {
        super(numero, titular);
    }

    @Override
    public void aplicarTaxa() {
        setSaldo(getSaldo() - TAXA);
    }
}
