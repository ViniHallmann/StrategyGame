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
    private Peça peca;
    private boolean equipe;
    //boolean getPeca;
    
    public Celula(char t , Peça peca, boolean equipe)
    {
        addMouseListener(this);
        this.peca = peca;
        this.equipe = equipe;
        if(equipe)
            setText(peca.getNome());
        this.peca.setTipo(t);
        setPreferredSize(new java.awt.Dimension(50, 50));
    }
    public Celula()
    {
        addMouseListener(this);
        setText(peca.getNome());
    }
    
    public void debugCelula()
    {
        if(!equipe)
        {
            setText(peca.getNome());
            repaint();
        }
    }
    
    public static void adicionaPeca(Celula botaoSelecionado, Tabuleiro tabuleiro)
    {
        
    }
    public static void removePeca()
    {
        
    }
    public static void substituiPeca(Peça p)
    {
        
    }
    
    public void setPeça(Peça peça)
    {
        this.peca = peça;
    }
    
    public Peça getPeca()
    {
        return this.peca;
    }
    
    public void setEquipe(boolean equipe)
    {
        this.equipe = equipe;
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
