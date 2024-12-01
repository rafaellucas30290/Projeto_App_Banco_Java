package Model;
import Enum.*;


public class Transacao {

    private final TipoTransacao tipo;

    private final double valor;

   


    public Transacao(TipoTransacao tipo, double valor) {

        this.tipo = tipo;

        this.valor = valor;

       

    }


    public TipoTransacao getTipo() {

        return tipo;

    }


    public double getValor() {

        return valor;

    }


}