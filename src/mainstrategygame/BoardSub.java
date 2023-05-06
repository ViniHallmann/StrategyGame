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
    JButton pecasAdversario = new JButton("Pecas do Adversario");
    JButton pecasJogador = new JButton("Pecas Aleatorias");
    JButton resetTabuleiro = new JButton("Resetar Tabuleiro");
    
    
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
       g.insets = new java.awt.Insets(5, 1, 1, 1);
       pecasAdversario.setSize(50, 10);
       pecasAdversario.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                   tabuleiro.setPecasAleatorias(false);
                   tabuleiro.repaint();
                   tabuleiro.revalidate();
                   
            }
        });
       add(pecasAdversario,g);
       
       g.gridy = 3;
       pecasJogador.setSize(50, 10);
       pecasJogador.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                   tabuleiro.setPecasAleatorias(true);
                   tabuleiro.repaint();
                   tabuleiro.revalidate();
                   
                }
            });
       add(pecasJogador,g);
       
       g.gridy = 0;
       g.gridx = 1;
       resetTabuleiro.setSize(50, 10);
       resetTabuleiro.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                   tabuleiro.resetaTabuleiro();
                   tabuleiro.repaint();
                   tabuleiro.revalidate();
                }
            });
       add(resetTabuleiro,g);
       
    }
    
    
}
