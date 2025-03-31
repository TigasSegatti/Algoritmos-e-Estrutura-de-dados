/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import Pilhas.PilhaVetor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Tiago
 */
public class testePilhas {
    
    public testePilhas() {
    }
    @Test
    public void test1(){
    PilhaVetor<Integer> pilha= new PilhaVetor<Integer>(5);
        assertEquals(true, pilha.estaVazia());
    
    }
    @Test
    public void test2(){
    PilhaVetor<Integer> pilha= new PilhaVetor<Integer>(5);
    pilha.push(10);
    assertEquals(false, pilha.estaVazia());
    
    }   
    @Test
    public void test3(){
    PilhaVetor<Integer> pilha= new PilhaVetor<Integer>(10);
    pilha.push(10);
    pilha.push(20);
    pilha.push(30);
    assertEquals(30, pilha.pop());
    assertEquals(20, pilha.pop());
    assertEquals(10, pilha.pop());
    
        assertTrue(pilha.estaVazia());
    }
    @Test
    public void test4(){
    PilhaVetor<Integer> pilha= new PilhaVetor<Integer>(5);
    pilha.push(10);
    assertEquals(false, pilha.estaVazia());
    
    }  
    
}
