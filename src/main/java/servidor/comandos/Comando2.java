package servidor.comandos;

import java.io.PrintStream;
import java.net.Socket;

public class Comando2 implements Runnable {
    private PrintStream saida;
    private Socket socket;

    public Comando2(PrintStream saida, Socket socket) {
        this.saida = saida;
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("servidor: -> Exec C2 " +socket.getPort());
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("servidor: -> Concluido C2 " + socket.getPort());
        saida.println("servidor: -> comando C2 executado com sucesso!");


    }
}
