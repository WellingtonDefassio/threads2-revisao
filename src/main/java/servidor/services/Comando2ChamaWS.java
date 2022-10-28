package servidor.services;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.Callable;

public class Comando2ChamaWS implements Callable<String> {
    private PrintStream saida;
    private Socket socket;

    public Comando2ChamaWS(PrintStream saida, Socket socket) {
        this.saida = saida;
        this.socket = socket;
    }


    @Override
    public String call() throws Exception {
        System.out.println("servidor: -> chamando AWS " + socket.getPort());
        saida.println("servidor: -> processando AWS");

        Thread.sleep(15000);

        int numero = new Random().nextInt(100) + 1;

        System.out.println("servidor: -> concludo AWS " + socket.getPort());
        saida.println("servidor: -> concludo AWS " + socket.getPort());

        return Integer.toString(numero);

    }
}

