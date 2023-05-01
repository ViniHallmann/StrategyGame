/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import static java.lang.Math.sqrt;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.Border;

/**
 *
 * @author jvlai
 */
public class Tabuleiro extends JPanel {
    public static final int NUMERO_DE_CASAS = 25;
    
    private Celula[][] tabuleiro;
    
    public JSeparator separador = new JSeparator();
    
    public Tabuleiro()
    {
        tabuleiro = new Celula[(int)(sqrt(NUMERO_DE_CASAS))][(int)(sqrt(NUMERO_DE_CASAS))];
        setLayout(new GridBagLayout());
        constroiTabuleiro();
    }
    
    private void constroiTabuleiro()
    {
        
        GridBagConstraints  g = new GridBagConstraints();
        g.insets = new java.awt.Insets(1, 1, 1, 1);
        for(int i = 0 ; i < sqrt(NUMERO_DE_CASAS); i++)
        {
            for(int j = 0; j < sqrt(NUMERO_DE_CASAS); j++)
            {
                g.gridx=i;
                g.gridx=j;
                tabuleiro[i][j] = CelulaFactory.factory(' ');
                tabuleiro[i][j].setBackground(new java.awt.Color(204, 255, 204));
                tabuleiro[i][j].setPreferredSize(new java.awt.Dimension(50, 50));
                
                if((i == 2 && j == 1)||(i == 2 && j == 3))
                {
                    tabuleiro[i][j].setEnabled(false);
                    tabuleiro[i][j].setBackground(new java.awt.Color(204, 204, 255));
                }
                
                add(tabuleiro[i][j],g);
            }
        }
    }
    
    
    
}
