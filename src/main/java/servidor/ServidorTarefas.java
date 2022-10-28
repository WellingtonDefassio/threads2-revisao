package servidor;

import servidor.configs.FabricaThreads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorTarefas {


    private final ServerSocket servidor;
    private final ExecutorService threadPool;
    private volatile boolean estaRodando;

    public ServidorTarefas() throws Exception {
        System.out.println("--Iniciando servidor--");
        this.servidor = new ServerSocket(12345);
        this.threadPool = Executors.newFixedThreadPool(8, new FabricaThreads());
        this.estaRodando = true;

    }

    public void parar() throws IOException {
        this.estaRodando = false;
        servidor.close();
        threadPool.shutdown();

    }

    public void iniciar() throws Exception {
        while (this.estaRodando){
            try {
                Socket socket = servidor.accept();
                System.out.println("aceitando novo cliente na porta " + socket.getPort());
                threadPool.execute(new ServidorTarefasRunnable(threadPool, socket, this));
            } catch (SocketException e) {
                System.out.println("SocketExption, Está rodando? " + this.estaRodando);
            }
        }

    }
}
