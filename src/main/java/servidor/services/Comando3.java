package servidor.services;

import java.io.PrintStream;
import java.net.Socket;

public class Comando3 implements Runnable {
    private PrintStream saida;
    private Socket socket;

    public Comando3(PrintStream saida, Socket socket) {
        this.saida = saida;
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("servidor: -> Exec C3 " +socket.getPort());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("servidor: -> Concluido C3 " + socket.getPort());
        saida.println("servidor: -> comando C3 executado com sucesso!");


    }
}
