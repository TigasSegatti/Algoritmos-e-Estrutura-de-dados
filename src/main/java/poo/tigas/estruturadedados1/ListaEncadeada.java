package poo.tigas.estruturadedados1;

/**
 *
 * @author tsegatti
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
        if (info == null) {
            throw new IllegalArgumentException("O valor inserido não pode ser nulo");
        }
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        this.primeiro = novo;

    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoLista<T> buscar(T Info) {
        NoLista<T> atual = primeiro;
        while (atual != null) { //Enquanto o nó atual nn for nulo, execute

            if (atual.getInfo().equals(Info)) { //Se o nó atual tiver o elemento  que busco, retorna
                return atual;
            }
            atual = atual.getProximo(); //caso não for, avance 
        }
        return null; //Retorne nulo caso não encontre
    }

    public void retirar(T info) {
        if (primeiro == null) { //Se o primeiro nó for nulo, retorne
            return;
        }

        if (primeiro.getInfo().equals(info)) { //Se o primeiro conter o que procuro
            primeiro = primeiro.getProximo(); //ele recebe o próximo 
            return;
        }
        NoLista<T> atual = primeiro; // instancia um nó e define o primeiro como 
        while (atual.getProximo() != null) {  //Enquanto o nó atual for diferente de nulo
            if (atual.getProximo().getInfo().equals(info)) { //se o nó atual conter o elemento que procuro
                atual.setProximo(atual.getProximo().getProximo()); //Remove o nó da lista. Enquanto o nó atual recebe o próximo nó
                return;
            }
            atual = atual.getProximo(); //Enquanto não for, o ponteiro aponta o próximo nó.

        }

    }

    public int obterComprimento() {
        int contador = 0;
        NoLista<T> atual = primeiro;
        while (atual != null) {
            contador++;
            atual = atual.getProximo();
        }
        return contador;
    }

    public NoLista<T> obterNo(int indice) {
                if (indice < 0 || indice >= obterComprimento()) {
            throw new IndexOutOfBoundsException("Indice fora dos limites");
        }
        NoLista<T> atual = primeiro;
        for (int i = 0; i < indice; i++) {
            atual = atual.getProximo(); //Move a referência para o próximo nó, andando pela lista
        }
        return atual; //retorna o nó que está na posição indica pelo indice.

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoLista<T> atual = primeiro;
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
