/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import poo.tigas.estruturadedados1.ListaEncadeada;
import poo.tigas.estruturadedados1.NoLista;

/**
 *
 * @author Tiago
 */
public class TesteLista2 {

    public TesteLista2() {
    }

    @Test
    public void test1() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<Integer>();
        assertEquals(true, listaEncadeada.estaVazia());
    }

    @Test
    public void test2() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<Integer>();
        listaEncadeada.inserir(5);
        assertEquals(false, listaEncadeada.estaVazia());
    }

    public void test3() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<Integer>();
        listaEncadeada.inserir(5);
        assertEquals(false, listaEncadeada.estaVazia());
        assertEquals(5, listaEncadeada.getPrimeiro().getInfo());
    }

    @Test
    public void test4() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<>();
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(10);
        listaEncadeada.inserir(15);

        assertEquals(false, listaEncadeada.estaVazia());

        assertEquals(15, listaEncadeada.getPrimeiro().getInfo());
        assertEquals(10, listaEncadeada.getPrimeiro().getProximo().getInfo());
        assertEquals(5, listaEncadeada.getPrimeiro().getProximo().getProximo().getInfo());

        assertNull(listaEncadeada.getPrimeiro().getProximo().getProximo().getProximo());
    }

    @Test
    public void test5() {
        ListaEncadeada<Integer> listaEncadeada = new ListaEncadeada<Integer>();
        listaEncadeada.inserir(5);
        listaEncadeada.inserir(10);
        listaEncadeada.inserir(15);
        listaEncadeada.inserir(20);

        // Buscar o número 20
        NoLista<Integer> resultado = listaEncadeada.buscar(20);

        // Verificar se o nó retornado não é nulo e contém o valor 20
        assertNotNull(resultado);
        assertEquals(20, resultado.getInfo());
    }

}
