package top.rregio.bin2dec.utils;

import javax.swing.JOptionPane;

/**
 *
 * @author rodrigo
 */
public class Condicoes {
    static int teste;
    
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
    public static int testaCondicoes(String texto, int modoExec) {
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
    public static void exibeErroConformeExecucao(int modoExec,String msg) {
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
}
