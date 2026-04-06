package unidade4.exerciciosUni4;

import java.util.Scanner;

//Código realizado segundo a seguinte regra de imposto
//O contribuinte com uma renda líquida de até R$ 2.000,00 não paga imposto. Para aqueles que possuem renda líquida 
//entre R$ 2.000,01 e R$ 5.000,00 o imposto é de 5% sobre o valor da renda líquida; para rendas líquidas entre 
//R$ 5.000,01 e R$ 10.000,00 é de 10%. Rendas superiores a R$ 10.000,01 pagam 15% de imposto.

public class Uni4Exe17 {

    Scanner input = new Scanner(System.in);
    private float rendaAnual, rendaLiquida, impostoSalarioLiquido;
    private int numDependentes, descontoNumDependentes;
    private String porcentagemDeImposto; 
    
    public Uni4Exe17(){
        obterDadosUsuario();
        calcularRendaLíquida();
        calcularImpostoDoContribuinte();
        mostrarResultados();
    }

    public void obterDadosUsuario(){
        System.out.println("Digite a renda anual do contribuinte:");
        rendaAnual = input.nextFloat();

        System.out.println("Digite o número de dependentes:");
        numDependentes = input.nextInt();
    }

    public void calcularRendaLíquida(){
        descontoNumDependentes = numDependentes * 2;
        rendaLiquida = rendaAnual - (rendaAnual * descontoNumDependentes / 100);
    }

    public void calcularImpostoDoContribuinte(){
        if(rendaLiquida <= 2000){
            impostoSalarioLiquido = 0;
        }
        else if(rendaLiquida <= 5000){
            porcentagemDeImposto = "5%";
            impostoSalarioLiquido = rendaLiquida * 0.05f;
        }
        else if(rendaLiquida <= 10000){
            porcentagemDeImposto = "10%";
            impostoSalarioLiquido = rendaLiquida * 0.10f;
        }
        else{
            porcentagemDeImposto = "15%";
            impostoSalarioLiquido = rendaLiquida * 0.15f;
        }
    }

    public void mostrarResultados(){
        if(numDependentes < 0 || rendaAnual <= 0){
            System.out.println("Os números são inválidos!");
        }
        else if(impostoSalarioLiquido == 0){
            System.out.println("O contribuinte não precisa pagar nenhum imposto!");
        }
        else{
            System.out.printf("O imposto é de %s e deve ser pago R$%.2f", porcentagemDeImposto, impostoSalarioLiquido);;
        }
    }

    public static void main(String[] args) {
        new Uni4Exe17();   
    }
}
