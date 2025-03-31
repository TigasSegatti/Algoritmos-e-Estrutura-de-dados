/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExceptionsPersonalizadas;

/**
 *
 * @author Tiago
 */
public class PilhaCheiaException extends RuntimeException {

    public PilhaCheiaException(String message) {
        super("Pilha está cheia");
    }
}
