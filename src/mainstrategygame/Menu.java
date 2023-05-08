/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;


import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author jvlai
 */
public class Menu extends JFrame{
    private JButton comecar = new JButton("Start");
    private final JLabel strategyGame = new JLabel("STRATEGY GAME");
    
    GridBagConstraints g = new GridBagConstraints();
    public Menu()
    {
       setTitle("STRATEGY GAME");
       setSize(800,600);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(new GridBagLayout());
       g.insets = new java.awt.Insets(25, 1, 1, 1);
       
       strategyGame.setFont(new Font("Segoe UI", Font.PLAIN, 50));
       
       g.gridx = 0;
       g.gridy = 0;
       
       add(strategyGame,g);
       
       g.gridy = 1;
       comecar.setPreferredSize(new java.awt.Dimension(300,100));
       comecar.setFont(new Font("Segoe UI", Font.PLAIN, 30));
       comecar.setBackground(new java.awt.Color(204,255,204));
       
       
       add(comecar,g);
    }
    public JButton getBotao()
    {
        return this.comecar;
    }
}
