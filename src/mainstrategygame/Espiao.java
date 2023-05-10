/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

/**
 *
 * @author vinic
 */
public class Espiao extends Peça {
    private boolean peçaEscondida;
    private boolean derrotaMarechal;
    private int nivel;
    
    public Espiao(){
        this.peçaEscondida   = true;
        this.derrotaMarechal = true;
        this.nivel = 1;
        this.setNome("🕵");
    }
    
    public void setEscondida(boolean peçaEscondida) {
        this.peçaEscondida = peçaEscondida;
    } 
    public boolean isEscondida() {
        return peçaEscondida;
    }
    public boolean isDerrotaMarechal(){
        return derrotaMarechal;
    }
    public int getNivel(){
        return nivel;
    }
}
