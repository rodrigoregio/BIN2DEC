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

    public Conversion() {
    }

    public int testaCondicoes(String texto, int tipo) {
        if (texto.equals("")) {
            if (tipo == 0) {
                System.err.println("O campo deve ter mais de um caractere e até 8 caracteres!");
            } else {
                JOptionPane.showMessageDialog(null, "O campo deve ter mais de um caractere e até 8 caracteres!", "Nada digitado", JOptionPane.ERROR_MESSAGE);
            }
            //teste = 0;
        } else if (texto.length() > 8) {
            if (tipo == 0) {
                System.err.println("O campo deve ter mais de um caractere e até 8 caracteres!");
            } else {
                JOptionPane.showMessageDialog(null, "O campo deve ter mais de um caractere e até 8 caracteres!", "Caracteres acima do esperado", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            for (int i = 0; i < texto.length(); i++) {
                if ((texto.charAt(i) == '0') || (texto.charAt(i) == '1')) {
                    teste = 1;
                } else {
                    if (tipo == 0) {
                        System.out.println("O campo aceita somente os caracteres \'0\' e \'1\'!");
                    } else {
                        JOptionPane.showMessageDialog(null, "O campo aceita somente os caracteres \'0\' e \'1\'!", "Caracteres diferentes do esperado!", JOptionPane.ERROR_MESSAGE);
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
