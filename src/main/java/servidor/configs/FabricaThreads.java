package servidor.configs;

import servidor.exceptions.TratadorDeExcecao;

import java.util.concurrent.ThreadFactory;

public class FabricaThreads implements ThreadFactory {
    private static int numero = 0;

    @Override
    public Thread newThread(Runnable r) {
        numero++;
        Thread thread = new Thread(r, "Thread servidor tarefas " + numero);
        thread.setUncaughtExceptionHandler(new TratadorDeExcecao());

        return thread;
    }
}
