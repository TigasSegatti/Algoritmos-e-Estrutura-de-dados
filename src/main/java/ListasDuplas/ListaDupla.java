/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasDuplas;

/**
 *
 * @author tsegatti
 */
public class ListaDupla<T> {

    private NoListaDupla<T> primeiro;

    public ListaDupla() {
        this.primeiro = null;

    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoListaDupla<T> novoNo = new NoListaDupla<>(valor);

        if (primeiro != null) {
            primeiro.setAnterior(novoNo);
            novoNo.setProximo(primeiro);
        }
        primeiro = novoNo;
    }

    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> atual = primeiro;

        while (atual != null) {
            if (atual.getInfo().equals(valor)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void retirar(T valor) {
        NoListaDupla<T> atual = buscar(valor);

        if (atual == null) {
            return; //valor não econtrando, logo n será retirado.
        }
        if (atual == primeiro) {
            primeiro = atual.getProximo(); //o ponteiro "primeiro" deve ser atualizado para o próximo nó
        }
        if (atual.getAnterior() != null) {
            atual.getAnterior().setProximo(atual.getProximo());
            // nó anterior (atual.getAnterior()) precisa apontar para o próximo nó (atual.getProximo()), 
            //pulando o nó atual.
        }
        if (atual.getProximo() != null) {
            atual.getProximo().setAnterior(atual.getAnterior());
            //o próximo nó (atual.getProximo()) precisa atualizar sua referência para apontar
            //para o nó anterior de atual.
        }
    }

    public void exibirOrdemInversa() {
        NoListaDupla<T> atual = primeiro; // Começa do último nó

        if (atual == null) {
            return;
        }

        while (atual.getProximo() != null) {
            atual = atual.getProximo();
        }
        while (atual != null) {
            System.out.println(atual.getInfo() + " ");
            atual = atual.getAnterior();
        }
    }

    public void liberar() {
        NoListaDupla<T> atual = primeiro;

        while (atual != null) { //Percorre a lista e remove referencia de nós
            NoListaDupla<T> proximo = atual.getProximo();
            atual.setProximo(null); //Define para ir limpando 
            atual.setAnterior(null);
            atual = proximo;
        }
        primeiro = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            sb.append(atual.getInfo());
            if (atual.getProximo() != null) {
                sb.append(", ");
            }
            atual = atual.getProximo();
        }
        return sb.toString();
    }
}
