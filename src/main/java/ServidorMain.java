import servidor.ServidorTarefas;

public class ServidorMain {
    public static void main(String[] args) throws Exception {

        ServidorTarefas servidorTarefas = new ServidorTarefas();
        servidorTarefas.iniciar();
        servidorTarefas.parar();


    }

}
