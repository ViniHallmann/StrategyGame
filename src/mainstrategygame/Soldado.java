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
    private boolean podeAtacar;
    private char tipo;
    private int nivel;
    
    public Soldado (){
        this.peçaEscondida  = true;
        this.podeAtacar     = true;
        this.podeCorrer     = true;
        this.setNome("S");
        this.nivel = 2;
    }

    public boolean isPodeCorrer() {
        return podeCorrer;
    }

    public void setPodeCorrer(boolean podeCorrer) {
        this.podeCorrer = podeCorrer;
    }

    public boolean isPodeAtacar() {
        return podeAtacar;
    }

    public void setPodeAtacar(boolean podeAtacar) {
        this.podeAtacar = podeAtacar;
    }

    public int getNivel() {
        return nivel;
    }
    
}
