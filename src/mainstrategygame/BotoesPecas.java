/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

/**
 *
 * @author jvlai
 */
public final class BotoesPecas extends JPanel{
    private final Celula[] botoes;
    public static final int NUMERO_DE_ROLES = 6;
    
    public BotoesPecas()
    {
        botoes = new Celula[NUMERO_DE_ROLES];
        setLayout(new GridBagLayout());
        constroiBotoesPecas();
        
    }
    public void constroiBotoesPecas(){
        GridBagConstraints  r = new GridBagConstraints();
        r.insets = new java.awt.Insets(40, 1, 1, 1);
        
        r.gridx = 0;
        botoes[0] = CelulaFactory.factory('B');
        add(botoes[0],r);
        
        r.gridx = 1;
        botoes[1] = CelulaFactory.factory('C');
        add(botoes[1],r);
        
        r.gridx = 2;
        botoes[2] = CelulaFactory.factory('S');
        add(botoes[2],r);
        
        r.gridx = 3;
        botoes[3] = CelulaFactory.factory('M');
        add(botoes[3],r);
        
        r.gridx = 4;
        botoes[4] = CelulaFactory.factory('E');
        add(botoes[4],r);
        
        r.gridx = 5;
        botoes[5] = CelulaFactory.factory('F');
        add(botoes[5],r);
        
        //
        for(int i = 0; i < NUMERO_DE_ROLES ; i++)
            botoes[i].setPreferredSize(new java.awt.Dimension(50, 50));
       
    }
}
