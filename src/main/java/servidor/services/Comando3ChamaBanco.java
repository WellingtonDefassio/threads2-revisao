package servidor.services;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.Callable;

public class Comando3ChamaBanco implements Callable<String> {
    private PrintStream saida;
    private Socket socket;

    public Comando3ChamaBanco(PrintStream saida, Socket socket) {
        this.saida = saida;
        this.socket = socket;
    }


    @Override
    public String call() throws Exception {
        System.out.println("servidor: -> chamando Banco de dados " + socket.getPort());
        saida.println("servidor: -> processando Banco de dados");

        Thread.sleep(20000);

        int numero = new Random().nextInt(100) + 1;

        System.out.println("servidor: -> concludo Banco de dados " + socket.getPort());
        saida.println("servidor: -> concludo Banco de dados " + socket.getPort());

        return Integer.toString(numero);

    }
}

