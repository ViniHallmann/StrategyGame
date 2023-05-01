/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import java.util.HashSet;
import java.util.Set;
import javax.swing.JButton;

/**
 *
 * @author jvlai
 */
public class Celula extends JButton{
    private final char tipo;
    private Peça peca;
    
    public Celula(char t , Peça peca)
    {
        this.tipo = t;
        this.peca = peca;
        setText(peca.getText());
    }
    
    public static void adicionaPeca(Peça p)
    {
     
    }
    public static void removePeca()
    {
        
    }
    public static void substituiPeca(Peça p)
    {
        
    }
    public void setTipo(Peça tipo)
    {
        this.peca = tipo;
    }
    
    public Peça getTipo()
    {
        return this.peca;
    }
}
