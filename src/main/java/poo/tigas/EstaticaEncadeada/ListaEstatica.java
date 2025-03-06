/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.tigas.EstaticaEncadeada;

/**
 *
 * @author Tiago
 */
public class ListaEstatica<T> {

    private Object[] info;
    private int tamanho;

    public ListaEstatica() {
        info = new Object[10];
        tamanho = 0;
    }

    private void redimensionar() {
        Object[] novoVetor = new Object[info.length + 10];
        for (int i = 0; i < tamanho; i++) {
            novoVetor[i] = info[i];
        }
        info = novoVetor;
    }

    public void inserir(T valor) {
        if (tamanho == info.length) {
            redimensionar();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            if (i < tamanho - 1) {
                System.out.print(info[i] + ", ");
            } else {
                System.out.print(info[i]);
            }
        }
        System.out.println();
    }

    public int buscar(T valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }

    public void retirar(T valor) throws IndexOutOfBoundsException {
        int posicao = buscar(valor);
        if (posicao == -1) {
            throw new IndexOutOfBoundsException("Valor não encontrado na lista");
        }
        for (int i = posicao; i < tamanho - 1; i++) {
            info[i] = info[i + 1];
        }
        tamanho--;
    }

    public void liberar() {
        info = new Object[10];
        tamanho = 0;
    }

    public T obterElemento(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        return (T) info[posicao];
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

   @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < tamanho; i++) {
        sb.append(info[i]); // Adiciona o elemento atual
        if (i < tamanho - 1) {
            sb.append(","); // Adiciona a vírgula entre elementos
        }
    }
    return sb.toString();
    }

    public void inverter() {
    for (int i = 0; i < tamanho / 2; i++) { //Cada troca manipula dois elementos
        Object temp = info[i]; // Armazena temporariamente o elemento atual
        info[i] = info[tamanho - 1 - i]; // Substitui o elemento atual pelo elemento oposto
        info[tamanho - 1 - i] = temp; // Substitui o elemento oposto pelo valor temporário
    }
}

}
