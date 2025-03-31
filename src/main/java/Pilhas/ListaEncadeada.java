/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilhas;

/**
 *
 * @author Tiago
 */
public class ListaEncadeada<T> {

    private NoLista<T> primeiro;

    public ListaEncadeada() {
        this.primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T info) {
        NoLista<T> novoNo = new NoLista<>();//Cria um novo nó
        novoNo.setInfo(info);  //Coloca o valor dentro desta nova cédula
        novoNo.setProximo(primeiro); //Agora este nó se torna o primeiro da lista
        this.primeiro = novoNo; //Atualiza o ponteiro para o novoNó
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoLista<T> buscar(T info) {
        NoLista<T> atual = primeiro;
        while (atual != null) { //Enquanto o nó atual nn for nulo, execute

            if (atual.getInfo().equals(info)) { //Se o nó atual tiver o elemento  que busco, retorna
                return atual;
            }
            atual = atual.getProximo(); //caso não for, avance 
        }
        return null; //Retorne nulo caso não encontre
    }

    public void retirar(T info) {
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;

        // Procura o nó que contém o valor, guardando o anterior
        while (p != null && !p.getInfo().equals(info)) {
            anterior = p;
            p = p.getProximo();
        }

        // Se encontrou o nó, retira-o da lista
        if (p != null) {
            if (p == primeiro) {
                this.primeiro = p.getProximo(); // Remove o primeiro nó
            } else {
                anterior.setProximo(p.getProximo()); // Remove um nó do meio ou do final
            }
        }
    }

    public int obterComprimento() {
        int contador = 0;
        NoLista<T> atual = new NoLista<>();
        while (atual != null) {
            atual = atual.getProximo();
            contador++;
        }
        return contador;
    }

    public NoLista<T> obterNo(int idx) throws IndexOutOfBoundsException {
        if (idx < 0 || idx >= obterComprimento()) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        NoLista<T> atual = primeiro; //Recebe o primeiro nó
        for (int i = 0; i < idx; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    @Override
    public String toString() {
        String s = "";
        NoLista<T> atual = primeiro;
        while (atual != null) {
            s += atual.getInfo() + "";
            atual = atual.getProximo();
        }
        return s;
    }
    
   
}
