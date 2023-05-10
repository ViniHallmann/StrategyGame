/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

/**
 *
 * @author vinic
 */
public class Soldado extends Peça {
    private boolean peçaEscondida;
    private boolean podeCorrer;
    private int nivel;
    
    public Soldado (){
        this.peçaEscondida  = true;
        this.podeCorrer     = true;
        this.setNome("S");
        this.nivel = 2;
    }

    public void setEscondida(boolean peçaEscondida) {
        this.peçaEscondida = peçaEscondida;
    }
    
    public boolean isEscondida() {
        return peçaEscondida;
    }
    
    public boolean isPodeCorrer() {
        return podeCorrer;
    }

    public int getNivel() {
        return nivel;
    }
    
}
