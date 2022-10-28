package servidor;

import servidor.services.*;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ServidorTarefasRunnable implements Runnable {


    private ExecutorService threadPool;
    private Socket socket;
    private ServidorTarefas servidor;

    public ServidorTarefasRunnable(ExecutorService threadPool, Socket socket, ServidorTarefas servidor) {
        this.threadPool = threadPool;
        this.socket = socket;
        this.servidor = servidor;
    }

    @Override
    public void run() {
        System.out.println("distribuindo tarefas para " + socket.getPort());
        try {
            Scanner comandoCliente = new Scanner(socket.getInputStream());
            PrintStream saida = new PrintStream(socket.getOutputStream());

            while (comandoCliente.hasNextLine()) {
                String comando = comandoCliente.nextLine();
                if ("c1".equals(comando)) {
                    saida.println("servidor: -> confirmação comando c1 " + socket.getPort());
                   threadPool.execute(new Comando1(saida, socket));
                } else if ("c2".equals(comando)) {
                    saida.println("servidor: -> confirmação comando c2 AWS + BANCO " + socket.getPort());
                    Future<String> futureBanco = threadPool.submit(new Comando3ChamaBanco(saida, socket));
                    Future<String> futureWs = threadPool.submit(new Comando2ChamaWS(saida, socket));
                    threadPool.submit(new LerResultados(futureBanco, futureWs, saida));




                } else if ("c3".equals(comando)) {
                    threadPool.submit(new Comando3ChamaBanco(saida,socket));
                    saida.println("servidor: -> confirmação comando c3 " + socket.getPort());
                }else if ("fim".equals(comando)) {
                    servidor.parar();
                    saida.println("servidor: -> encerando a conexão da " + socket.getPort());

                }else
                    saida.println("servidor: -> comando não encontrado " + socket.getPort());
            }

            System.out.println("fechando conexao da porta " + socket.getPort());

            comandoCliente.close();
            comandoCliente.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
