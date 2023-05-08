/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JButton;

/**
 *
 * @author jvlai
 */
public class Celula extends JButton implements MouseListener{
   // private char tipo;
    private int posX;
    private int posY;
    private Peça peca;
    private int equipe;
    boolean eLago = false;
    
    public Celula(char t , Peça peca, int equipe)
    {
        addMouseListener(this);
        this.peca = peca;
        this.equipe = equipe;
        if(equipe > -1)
            setText(peca.getNome());
        
        this.peca.setTipo(t);
        setPreferredSize(new java.awt.Dimension(50, 50));
    }
    public Celula()
    {
        addMouseListener(this);
        setText(peca.getNome());
    }
    
    public void revelaCelula()
    {
        if(equipe == -1)
        {
            setText(peca.getNome());
            repaint();
        }
    }
    
    public void setLago()
    {
        this.eLago = true;
    }
    public boolean getLago()
    {
        return this.eLago;
    }
    public void setPeça(Peça peça)
    {
        this.peca = peça;
    }
    
    public Peça getPeca()
    {
        return this.peca;
    }
    
    public void setEquipe(int equipe)
    {
        this.equipe = equipe;
    }
    public int getEquipe(){
        return this.equipe;
    }
    public void setCoord(int posx, int posy)
    {
        this.posX = posx;
        this.posY = posy;
    }
    
    public int getPosX()
    {
        return this.posX;
    }
    public int getPosY()
    {
        return this.posY;
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

}
