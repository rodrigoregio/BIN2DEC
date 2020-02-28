/*
 * Classe que trata do domínio que converte um inteiro digitado em binário
 * para um numero decimal.
 */
package top.rregio.bin2dec.dominio;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author rodrigo
 */
public class Conversion {

    //Variaveis principais da classe
    String binario;                         // A String digitada no campo
    int teste;
    /* 
                                             * Um numero inteiro para testar se 
                                             * todas as condições se satisfazem
                                             * na conversão
     */
    int bin;                                // O numero inteiro já convertido
    
    //Método construtor da classe Conversion
    public Conversion() {
    }
    
    //Testador se todas as condições são satisfeitas de acordo com o
    //app-ideas/bin2dec
    public int testaCondicoes(String texto, int tipo) {
        if (texto.equals("")) {//Primeira condição
        //Se a string for em branca
            if (tipo == 0) {//Se o tipo de execução for por linha de comando
                System.err.println("O campo deve ter mais de um caractere e "+
                        "até 8 caracteres!");//imprima isto
            } else {//senão
                //Mostre um JOptionpane com o texto
                JOptionPane.showMessageDialog(null, "O campo deve ter mais de "+
                        "um caractere e até 8 caracteres!", "Nada digitado",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (texto.length() > 8) { //segunda condição
            //Senão se o tamanho do texto for maior que 8 caracteres
            if (tipo == 0) {//Se o tipo de execução for por linha de comando
                System.err.println("O campo deve ter mais de um caractere e "+
                        "até 8 caracteres!");//imprima isto
            } else {//senão
                //mostre um JOptionPane com o texto
                JOptionPane.showMessageDialog(null, "O campo deve ter mais de"+
                        " um caractere e até 8 caracteres!", "Caracteres acima"+
                        " do esperado", JOptionPane.ERROR_MESSAGE);
            }
        } else {//Se as duas condições forem satisfeitas
            for (int i = 0; i < texto.length(); i++) {
            //em todos caracteres da string
                if ((texto.charAt(i) == '0') || (texto.charAt(i) == '1')) {
                    //Se o caractere atual for 0 ou 1
                    teste = 1; // variavel de teste recebe 1
                } else {//Senão
                    if (tipo == 0) {
                    //Se o tipo de execução for por linha de comando
                        System.out.println("O campo aceita somente os "+
                                "caracteres \'0\' e \'1\'!");
                    } else {
                        JOptionPane.showMessageDialog(null, "O campo aceita "+
                                "somente os caracteres \'0\' e \'1\'!", 
                                "Caracteres diferentes do esperado!", 
                                JOptionPane.ERROR_MESSAGE);
                    }
                    teste = 0;
                    break;
                }
            }
        }
        return teste;
    }

    public void CommandLineConversion() {
        Scanner sc = new Scanner(System.in);

        teste = 0;

        do {
            System.out.println("Digite um numero Binário:");
            binario = sc.nextLine();
            teste = testaCondicoes(binario,0);
            if (teste == 0) {
                continue;
            } else {
                bin = Integer.parseInt(binario, 2);
            }

            StringBuilder sb = new StringBuilder();
            sb.append("Valores do binario:\n\n");
            sb.append("Decimal: ");
            sb.append(bin);
            sb.append("\n");
            sb.append("Binario: ");
            sb.append(binario);
            sb.append("\n");
            System.out.println(sb);
            teste = 1;
        } while (teste == 0);
    }

    public int WindowedConversion(String binario) {
        teste = testaCondicoes(binario,1);
        if (teste == 0) {

        } else {
            bin = Integer.parseInt(binario, 2);
        }
        teste = 1;
        return bin;
    }
}
