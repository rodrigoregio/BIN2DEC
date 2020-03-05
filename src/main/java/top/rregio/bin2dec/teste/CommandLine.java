package top.rregio.bin2dec.teste;

import java.util.Scanner;
import top.rregio.bin2dec.dominio.Conversion;
import static top.rregio.bin2dec.utils.Condicoes.testaCondicoes;

/**
 * @author rodrigo
 */
public class CommandLine {
    int teste;
    int bin;
    String binario;
    public void Conversion(){
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
     * @param args the command line arguments
     */
    public static void main(String...args) {
        if (!args[0].equals("0")) {
            Windowed w = new Windowed();
            w.setVisible(true);
        } else {
            Conversion c = new Conversion();
            c.CommandLineConversion();
        }
    }
}
