package Filas;

/**
 *
 * @author tsegatti
 */
public class FilaLista<T> implements Fila<T> {

    private ListaEncadeada<T> lista;
    private NoLista<T> ultimo;

    public FilaLista() {
        this.lista = new ListaEncadeada<>();
        this.ultimo = null;
    }

    @Override
    public void inserir(T valor) {
        lista.inserirNoFinal(valor);
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new IllegalArgumentException("A fila está cheia");
        }
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public T retirar() {
        if (estaVazia()) {
            throw new IllegalArgumentException("A fila está vazia");
        }
        T valor = lista.getPrimeiro().getInfo();
        lista.removerInicio();
        return valor;
    }

    @Override
    public void liberar() {
        lista.liberar();
    }

    @Override
    public String toString() {
        return lista.toString();
    }

}
