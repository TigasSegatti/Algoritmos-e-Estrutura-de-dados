package Arvores;

/**
 *
 * @author Tiago
 */
public class ArvoreBinaria<T> {

    private NoArvoreBinaria<T> raiz;

    public ArvoreBinaria() {
        this.raiz = raiz;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public boolean pertence(T info) {
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return false;
        }
        if (no.getInfo().equals(info)) {
            return true;
        }
        return pertence(no.getEsquerda(), info) || pertence(no.getDireita(), info);
    }

    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public String toString() {
        return arvorePre(raiz);
    }

    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }
          return "<" + no.getInfo() + arvorePre(no.getEsquerda()) + arvorePre(no.getDireita()) + ">";

    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
    }  
    /**
 * Método público que busca um valor na árvore e retorna o nó correspondente.
 * 
 * @param info valor a ser buscado
 * @return nó que contém o valor, ou null se não encontrado
 */
public NoArvoreBinaria<T> buscar(T info) {
    return buscar(raiz, info); // Chama o método recursivo a partir da raiz
}

/**
 * Método privado recursivo para buscar um valor em um nó da árvore.
 * 
 * @param no nó atual sendo analisado
 * @param info valor que estamos procurando
 * @return nó que contém o valor, ou null se não for encontrado
 */
private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
    if (no == null) {
        // Se o nó for null, significa que chegamos a uma folha e não encontramos o valor
        return null;
    }
    if (no.getInfo().equals(info)) {
        // Se o valor do nó atual for igual ao procurado, retornamos o próprio nó
        return no;
    }

    // Tenta buscar na subárvore da esquerda
    NoArvoreBinaria<T> resultadoEsquerda = buscar(no.getEsquerda(), info);
    if (resultadoEsquerda != null) {
        // Se encontrou na esquerda, retorna o nó encontrado
        return resultadoEsquerda;
    }

    // Caso contrário, tenta buscar na subárvore da direita
    return buscar(no.getDireita(), info);
}

/**
 * Método que retorna uma representação em String da subárvore
 * a partir de um nó específico, usando percurso em pré-ordem.
 * 
 * @param no nó raiz da subárvore que será representada
 * @return string representando a subárvore
 */
public String toString(NoArvoreBinaria<T> no) {
    if (no == null) {
        // Se o nó for nulo, retorna a marca de árvore vazia
        return "<>";
    }

    // Retorna a String no formato <infoSubarvoreEsquerdaSubarvoreDireita>
    // Isso forma uma visualização recursiva da árvore
    return "<" 
        + no.getInfo()                         // valor do nó atual
        + toString(no.getEsquerda())          // representação da subárvore esquerda
        + toString(no.getDireita())           // representação da subárvore direita
        + ">";
}  
}
