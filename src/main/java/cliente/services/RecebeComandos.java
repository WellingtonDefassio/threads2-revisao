package cliente.services;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class RecebeComandos implements Runnable {
    private Socket socket;

    public RecebeComandos(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("cliente: -> iniciando serviço recebe comandos");
        Scanner respostaServidor = null;
        try {
            respostaServidor = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (respostaServidor.hasNext()){
            String nextLine = respostaServidor.nextLine();
            System.out.println(nextLine);
        }

        respostaServidor.close();
    }
}
