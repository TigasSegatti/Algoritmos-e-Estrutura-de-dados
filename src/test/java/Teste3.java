/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import ListasDuplas.ListaDupla;
import ListasDuplas.NoListaDupla;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Tiago
 */
public class Teste3 {

    public Teste3() {
    }

    @Test
    public void teste1() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.exibirOrdemInversa();
        assertEquals("20, 15, 10, 5", lista.toString());
    }

    @Test
    public void teste2() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoListaDupla<Integer> noEncontrado = lista.buscar(20);
        assertEquals(20, noEncontrado.getInfo());
    }

    @Test
    public void teste3() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        NoListaDupla no10 = lista.buscar(10);

        assertEquals(10, no10.getInfo());
    }

    @Test
    public void teste4() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.retirar(10);
        NoListaDupla no5 = lista.buscar(5);
        NoListaDupla no15 = lista.buscar(15);
        NoListaDupla no20 = lista.buscar(20);

        assertEquals(15, no20.getProximo().getInfo());
        assertEquals(5, no15.getProximo().getInfo());
        assertNull(no5.getProximo());
    }

    @Test
    public void test07() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.liberar();

        assertNull(lista.getPrimeiro());
    }
}
