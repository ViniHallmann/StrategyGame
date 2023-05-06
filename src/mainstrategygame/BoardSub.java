/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author jvlai
 */
public class BoardSub extends JFrame{
    Tabuleiro tabuleiro     = new Tabuleiro();
    BotoesPecas botoesPecas = new BotoesPecas(tabuleiro);
    JButton pecasAdversario = new JButton("Colocar Pecas do Adversario");
    
    
    public BoardSub()
    {
       setTitle("STRATEGY GAME");
       setSize(700,500);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       
       setLayout(new GridBagLayout());
       GridBagConstraints  g = new GridBagConstraints();
       g.gridx = 0;
       g.gridy = 0;
       add(tabuleiro,g);
       g.gridy = 1;
       add(botoesPecas,g);
       g.gridy = 2;
       pecasAdversario.setSize(150, 10);
       g.insets = new java.awt.Insets(5, 1, 1, 1);
       pecasAdversario.addMouseListener(new MouseAdapter() 
       {
            public void mouseClicked(MouseEvent e) 
            {
                tabuleiro.setPecasComputador();
                tabuleiro.repaint();
                tabuleiro.revalidate();
                   
            }
        });
       add(pecasAdversario,g);
    }
    
    
}
