package Pilhas;

import ExceptionsPersonalizadas.PilhaVaziaException;

/**
 *
 * @author Tiago
 */
public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeada<T> lista;

    public PilhaLista() {
        this.lista = new ListaEncadeada<>();
    }

    @Override
    public void push(T info) {
        lista.inserir(info);
    }

    @Override
    public T pop() {
        if (estaVazia()) {
            throw new PilhaVaziaException("Pilha está vazia");
        }
        T info = lista.getPrimeiro().getInfo();
        lista.retirar(info); //Remove o item do topo
        return info;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException("Pilha estpa vazia");
        }
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        while (!estaVazia()) {
            pop();// Vai removendo os itens.
        }
    }

    public String toString() {
        return lista.toString();
    }
}
