package Filas;

public class FilaVetor<T> implements Fila<T> {

    private Object[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        this.info = new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
        this.inicio = 0;
        this.tamanho = limite;
    }

    public Object[] getInfo() {
        return info;
    }

    public void setInfo(Object[] info) {
        this.info = info;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    @Override
    public void inserir(T valor) {
        if (tamanho == limite) {
            throw new RuntimeException("Fila está cheia");
        }
        int posicaoInserir = (inicio + tamanho) % limite;
        info[posicaoInserir] = valor;
        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new RuntimeException("Fila está vazia");
        }
        return (T) info[inicio];
    }

    @Override
    public T retirar() {
        if (estaVazia()) {
            throw new RuntimeException("Está vazia");
        }

        T valor = peek();
        inicio = (inicio + 1) % limite;
        tamanho--;
        return valor;

    }

    @Override
    public void liberar() {
        info = new Object[limite];
        tamanho = 0;
        inicio = 0;
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> novaFila = new FilaVetor<>(this.limite + f2.limite);
        for (int i = 0; i < tamanho; i++) {
            novaFila.inserir((T) this.info[(inicio + i) % limite]);
        }
        for (int i = 0; i < f2.tamanho; i++) {
            novaFila.inserir((T) f2.info[(f2.inicio + i) % f2.limite]);
        }
        return novaFila;
    }

    public String toString() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia");
        }

        /*
        for(int i=-; i<tamanho;i++){
        int indice= (indce+i)% limite;
        resultado+= "[ "+ 
        }
         */
        String resultado = "[";
        for (int i = 0; i < tamanho; i++) {
            resultado += info[(inicio + i) % limite];
            if (i < tamanho - 1) {
                resultado += ", ";
            }
        }
        resultado += "]";
        return resultado;

    }

}
