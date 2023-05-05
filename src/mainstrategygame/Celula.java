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
    private char tipo;
    private Peça peca;
    boolean getPeca;
    
    public Celula(char t , Peça peca)
    {
        addMouseListener(this);
        this.tipo = t;
        this.peca = peca;
        setText(peca.getText());
    }
    public Celula()
    {
        addMouseListener(this);
        setText(peca.getText());
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
    public void setTipo(char tipo)
    {
        this.tipo = tipo;
    }
    public void setPeça(Peça peça)
    {
        this.peca = peça;
    }
    
    public char getTipo()
    {
        return this.tipo;
    }
    public Peça getPeca()
    {
        return this.peca;
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
