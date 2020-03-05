/*
 * Classe que trata do domínio que converte um inteiro digitado em binário
 * para um numero decimal.
 */
package top.rregio.bin2dec.dominio;

import top.rregio.bin2dec.teste.CommandLine;
import top.rregio.bin2dec.utils.Condicoes;

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

    public void CommandLineConversion() {
        CommandLine cl = new CommandLine();
        cl.Conversion();
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
    
        teste = Condicoes.testaCondicoes(binario, 1); // binario é a string a ser validada
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
