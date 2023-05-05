/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import javax.swing.JLabel;

/**
 *
 * @author vinic
 */
public abstract class Peça extends JLabel{
    private int posX;
    private int posY;
    private String nome;
    public Peça() {
    }
    
    public void setCoord(int x ,int y)
    {
        this.posX = x;
        this.posY = y;
    }

    public String getNome() {
        return nome;
    }
    
}
