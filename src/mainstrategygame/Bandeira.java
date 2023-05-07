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
    private boolean bandeiraSegura;
    private char tipo;
    
    public Bandeira(){
        this.peçaEscondida  = true;
        this.bandeiraSegura = true;
        this.setNome("🏴");
    }

    public boolean isBandeiraSegura() {
        return bandeiraSegura;
    }
    
    public void setBandeiraCapturada(boolean bandeiraSegura) {
        this.bandeiraSegura = bandeiraSegura;
    }
    
}
