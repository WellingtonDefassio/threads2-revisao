package cliente;

import cliente.services.EnviaComando;
import cliente.services.RecebeComandos;

import java.io.IOException;
import java.net.Socket;

public class ClienteTarefa {
    public static void main(String[] args) throws Exception {

        System.out.println("cliente: -> iniciando cliente");
        Socket socket = new Socket("localhost", 12345);
        System.out.println("cliente: -> conexão estabelecida");


        Thread enviaComandos = new Thread(new EnviaComando(socket));

        Thread recebeComandos = new Thread(new RecebeComandos(socket));

        enviaComandos.start();
        recebeComandos.start();

        recebeComandos.join();

        System.out.println("cliente: -> sessão encerrada");
        socket.close();
    }
}
