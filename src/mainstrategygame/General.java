/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

/**
 *
 * @author vinic
 */
public class General extends Peça{
    private boolean peçaEscondida;
    
    public General (String nomeDaPeça, int nivelDaPeça, int[] posição){
        super(nomeDaPeça, nivelDaPeça, posição);
        this.peçaEscondida = true;
    }
}
