public class Transacao {

    private TipoTransacao tipo;

    private double valor;

   


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