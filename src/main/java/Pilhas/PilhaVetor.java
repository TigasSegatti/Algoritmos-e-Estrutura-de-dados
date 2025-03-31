package Pilhas;

import ExceptionsPersonalizadas.PilhaCheiaException;
import ExceptionsPersonalizadas.PilhaVaziaException;

/**
 *
 * @author Tiago
 */
public class PilhaVetor<T> implements Pilha<T> {

    private Object info[];
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        this.info = new Object[limite];
        this.tamanho = 0;
        this.limite = limite;
    }

    public Object[] getInfo() {
        return info;
    }

    public void setInfo(Object[] info) {
        this.info = info;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public void push(T info) {
        if (limite == tamanho) {
            throw new PilhaCheiaException("Pilha está cheia");
        }
        this.info[tamanho++] = info;
    }

    @Override
    public T pop() {
        if (estaVazia()) {
            throw new PilhaVaziaException("Pilha vazia");
        }
        T valor = (T) info[tamanho - 1]; // Acessa o valor no topo da pilha
        info[tamanho - 1] = null; // Remove a referência do valor
        tamanho--; // Diminui o tamanho da pilha
        return valor; // Retorna o valor armazenado
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException("Pilha está vazia");
        }
        return (T) info[tamanho - 1];
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void liberar() {
        info = new Object[limite];
        tamanho = 0;
    }

    public void concatenar(Pilha<T> p) {
        while (!p.estaVazia()) {
            this.push(p.pop());
        }
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < tamanho; i++) {
            s += info[i].toString();
            if (i < tamanho - 1) {
                s += ".";
            }
        }
        return s;
    }
}
