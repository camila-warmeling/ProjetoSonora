package fase03.utilitarios;

import java.util.Scanner;

public class Leitor {
    private Scanner scanner;

    public Leitor(){
        this.scanner = new Scanner(System.in);
    }

    public String lerTexto(String mensagem){
        System.out.println(mensagem);
        return scanner.nextLine();
    }

    public int lerInteiro(String mensagem){
        while(true){
            System.out.println(mensagem);
            try{ //se for possível fazer a conversão o while acaba.
                return Integer.parseInt(scanner.nextLine()); 
            }catch(NumberFormatException e){
                System.out.println("Número inválido. Digite um número inteiro.");
            }catch(Exception e){
                System.out.println("Número inválido. Digite somente números inteiros.");
            }
        }
    }
}
