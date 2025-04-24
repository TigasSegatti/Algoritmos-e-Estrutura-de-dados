/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArvoreNArias;

/**
 *
 * @author tsegatti
 */
public class Arvore<T> {

    private NoArvore<T> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public String toString() {
        return obterRepresentacaoTextual(raiz);
    }

    public String obterRepresentacaoTextual(NoArvore<T> no) {
        if (no == null) {
            return "<>";
        }
        String s = "<" + no.getInfo();
        NoArvore<T> filho = no.getPrimeiro();
        while (filho != null) {
            s += obterRepresentacaoTextual(filho);
            filho = filho.getProximo();
        }
        s += ">";
        return s;
    }

    public boolean pertence(T info) {
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvore<T> no, T info) {
        if (no == null) {
            return false;
        }
        if (no.getInfo().equals(info)) {
            return true;
        }
        NoArvore<T> filho = no.getPrimeiro();
        while (filho != null) {
            if (pertence(filho, info)) {
                return true;
            }
            filho = filho.getPrimeiro();
        }
        return false;
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    public int contarNos(NoArvore<T> no) {
        if (no == null) {
            return 0;
        }
        int cont = 1;
        NoArvore<T> filho = no.getPrimeiro();
        while (filho != null) {
            cont += contarNos(filho);
            filho = filho.getProximo();
        }
        return cont;
    }
}
