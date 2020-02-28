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
    String binario;
    // A String digitada no campo

    int teste;
    /* 
     * Um numero inteiro para testar se 
     * todas as condições se satisfazem
     * na conversão
     */

    int bin;
    // O numero inteiro já convertido

    //Método construtor da classe Conversion
    public Conversion() {
    }

    /**
     * Método que testa se as condições estão de acordo com o proposto, são
     * elas:
     *
     * 1º O texto não pode estar vazio 2º O campo deve aceitar somente 8 bits
     * (caracteres binarios, 0 e 1) 3º O campo não deve aceitar caracteres
     * diferentes do binario (caracteres 0 e 1)
     *
     * @param texto O texto a ser convertido
     * @param modoExec O tipo de execução 0 para linha de comando e 1 para execução
     * em janela
     * @return retorna uma variavel informando se todas as condições foram
     * validas
     */
    public int testaCondicoes(String texto, int modoExec) {
        //Inicio do método que testa as condições

        if (texto.equals("")) {
            //Testa a Primeira condição (Se a string for em branca)

            exibeErroConformeExecucao(modoExec,"O campo não deve estar vazio!");

        } else if (texto.length() > 8) {
            //Senão testa a Segunda condição (se o tamanho do texto for maior 
            //que 8 caracteres)

            exibeErroConformeExecucao(modoExec,"O campo não deve conter mais "+
                    "que oito caracteres!");
        } else {//Senão (se as duas condições forem satisfeitas)
            for (int i = 0; i < texto.length(); i++) {
                //em todos caracteres da string
                if ((texto.charAt(i) == '0') || (texto.charAt(i) == '1')) {
                    //Testa se o caractere atual é binário (se é 0 ou 1)
                    teste = 1; // variavel de teste recebe 1
                } else {//Senão 
                    
                    //chama o metodo que exibe a mensagem de acordo com a execução
                    exibeErroConformeExecucao(modoExec,"O campo não deve conter "+
                            "caracteres diferentes de \'0\' e \'1\'!");
                    
                    //Atribua 0 á variavel teste
                    teste = 0;
                    break;//quebre o laço for

                }//Fim do if que testa se o caractere é um caractere binario

            }//Fim do for que varre os caracteres

        }//Fim do senão

        return teste;
    }

    /**
     * Método que testa o modo de execução
     *
     * Modo de execução
     * @param modoExec
     * Mensagem a ser exibida
     * @param msg
     * 
     */
    public void exibeErroConformeExecucao(int modoExec,String msg) {
        if (modoExec == 0) {
            //Se o tipo de execução for por linha de comando

            System.err.println(msg);
            //imprima a mensagem

        } else {
            //senão 

            JOptionPane.showMessageDialog(null, msg, "Ocorreu um erro!",
                    JOptionPane.ERROR_MESSAGE);
            //Mostre um JOptionpane com a mensagem

        }//fim do if que verifica modo de execução

    }

    public void CommandLineConversion() {
    //Inicia a conversão pela linha de comando
        
        //Inicializa a classe Scanner do pacote java.util
        Scanner sc = new Scanner(System.in);

        //inicializa a variavel teste com 0
        teste = 0;

        do {
        //faça isto
            
            System.out.println("Digite um numero Binário:");
            //Solicita que o usuario digite um numero binario
            
            binario = sc.nextLine();
            //lê o que foi digitado pelo usuario
            
            teste = testaCondicoes(binario, 0);
            //a variavel teste vai receber o retorno do método testa condições
            
            if (teste == 0) {
            //verifica se a variavel teste é igual a 0
                
                continue;
                //se for ignora todos os comando abaixo deste continue
            } else {
            //senão
                bin = Integer.parseInt(binario, 2);
                //realiza a conversão da String em um valor inteiro que está 
                //na base dois (binário)
            }
            //E se a variavel teste não for 0 continua com a execução dos 
            //comandos abaixo:
            
            StringBuilder sb = new StringBuilder();
            //Instancia uma String Builder para mostrar o valor digitado e o 
            //valor já convertido
            //A String Builder começa com uma String vazia
            sb.append("Valores do binario:\n\n");
            sb.append("Decimal: ");
            sb.append(bin);
            sb.append("\n");
            sb.append("Binario: ");
            sb.append(binario);
            sb.append("\n");
            //Os comandos acima apenas acrescentam a String passada como 
            //parametro á String do StringBuilder
            System.out.println(sb);
            //Imprime a String do StringBuilder
            teste = 1;
            //a variavel teste recebe 1
            
        } while (teste == 0);
        //enquanto a variavel teste for igual a 0 (se a variavel teste for 1 
        //sairá do loop)
    }

    /**
     * Método que executa no modo Janela
     * 
     * Variavel binario é o texto a ser convertido em decimal
     * @param binario
     * 
     * Retorna um inteiro com o resultado da conversão
     * @return 
     */
    public int WindowedConversion(String binario) {
    //inicio do metodo em modo janela
    
        teste = testaCondicoes(binario, 1); // binario é a string a ser validada
        //e 1 é o modo de execução. A variavel teste recebe o resultado da
        //validação da String.
        
        if (teste != 0) {
        //Se a variavel teste for diferente de 0 (no caso 1) 
            bin = Integer.parseInt(binario, 2);
            //se for diferebte de 0 realiza a conversão para binario
        }
        return bin;
    }
}
