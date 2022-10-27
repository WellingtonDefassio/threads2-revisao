package cliente.services;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class EnviaComando implements Runnable {


    private Socket socket;

    public EnviaComando(Socket socket) {

        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("cliente: -> iniciando serviço de envio de comandos");
        PrintStream saida = null;
        try {
            saida = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scanner teclado = new Scanner(System.in);
        while (teclado.hasNext()) {
            String linha = teclado.nextLine();
            if(linha.trim().equals("exit")){
                break;
            }
            saida.println(linha);
        }
        saida.close();
        teclado.close();
    }
}
