/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

/**
 *
 * @author vinic
 */
public class Bomba extends Peça{

    private boolean peçaEscondida;
    private int nivel;
    
    public Bomba (){
        this.peçaEscondida = true;
        this.setNome("💣");
        this.nivel = 99;
    }

    public void setEscondida(boolean peçaEscondida) {
        this.peçaEscondida = peçaEscondida;
    }
    
    public boolean isEscondida() {
        return peçaEscondida;
    }
    public int getNivel(){
        return nivel;
    }
}
