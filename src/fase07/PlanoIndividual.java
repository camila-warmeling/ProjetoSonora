package fase07;

public class PlanoIndividual extends PlanoPago{

    /*
    Para pensar (Parte B): se a classe Plano Gratuito ficasse totalmente vazia, sem métodos e atributos 
    próprios, deveriamos considerar se ela não poderia se tornar a própria classe Pai. Neste caso ela 
    continua existindo pela necessidade de atribuir valores específicos próprios do plano gratuito.
    **/

    public PlanoIndividual(double precoMensal) {
        super("Individual", 1, precoMensal);
    }

    @Override 
    public boolean temAnuncios() {
        return false;
    }

    @Override 
    public double calcularMensalidade() {
        return getPrecoMensal();
    }


}
