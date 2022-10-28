package servidor.services;

import java.io.PrintStream;
import java.net.Socket;

public class Comando1 implements Runnable {
    private PrintStream saida;
    private Socket socket;

    public Comando1(PrintStream saida, Socket socket) {
        this.saida = saida;
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("servidor: -> Exec C1 " +socket.getPort());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("servidor: -> Concluido C1 " + socket.getPort());
        saida.println("servidor: -> comando c1 executado com sucesso!");
    }
}
