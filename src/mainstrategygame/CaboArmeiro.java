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
    private char tipo;
    
    public CaboArmeiro (){
        this.peçaEscondida = true;
        this.setText("🔧");
    }
}
