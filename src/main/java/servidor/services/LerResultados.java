package servidor.services;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class LerResultados implements Callable<Void> {
    private Future<String> futureBanco;
    private Future<String> futureWs;
    private PrintStream saida;

    public LerResultados(Future<String> futureBanco, Future<String> futureWs, PrintStream saida) {
        this.futureBanco = futureBanco;
        this.futureWs = futureWs;
        this.saida = saida;
    }

    @Override
    public Void call() throws Exception {
        System.out.println("Aguardando resultado banco + aws");

        System.out.println("resultado... " + futureBanco.get() + " " + futureWs.get());
        saida.println("resultado... " + futureBanco.get() + " " + futureWs.get());


        return null;
    }
}
