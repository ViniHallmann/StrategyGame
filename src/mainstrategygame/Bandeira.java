/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

/**
 *
 * @author vinic
 */
public class Bandeira extends Peça{
    private boolean peçaEscondida;
    private boolean peçaCapturada;
    
    public Bandeira (String nomeDaPeça, int nivelDaPeça, int[] posição){
        super(nomeDaPeça, nivelDaPeça, posição);
        this.peçaEscondida = true;
        this.peçaCapturada = false;
    }

   
}
