package top.rregio.bin2dec.teste;

import top.rregio.bin2dec.dominio.Conversion;

/**
 * @author rodrigo
 */
public class CommandLine {

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
