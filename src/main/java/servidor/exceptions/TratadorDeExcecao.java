package servidor.exceptions;

public class TratadorDeExcecao implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("TRATADOR DE EXCECAO ATIVADO NA THREAD " + t.getName());
    }
}
