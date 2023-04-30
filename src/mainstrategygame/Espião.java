/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

/**
 *
 * @author vinic
 */
public class Espião extends Peça {
    private final boolean derrotaMarechal = true;
    private boolean peçaEscondida;
    
    public Espião (String nomeDaPeça, int nivelDaPeça, int[] posição){
        super(nomeDaPeça, nivelDaPeça, posição);
        this.peçaEscondida = true;
    }
    public boolean isDerrotaMarechal() {
        return derrotaMarechal;
    }
}
