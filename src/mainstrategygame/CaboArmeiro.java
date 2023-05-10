/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

/**
 *
 * @author vinic
 */
public class CaboArmeiro extends Peça {
    private boolean peçaEscondida;
    private boolean desarmaBomba;
    private int nivel;
    
    public CaboArmeiro (){
        this.peçaEscondida  = true;
        this.desarmaBomba   = true;
        this.setNome("🔧");
        this.nivel = 3;
    }

    public boolean isDesarmaBomba() {
        return desarmaBomba;
    }

    public int getNivel() {
        return nivel;
    }
    
}
