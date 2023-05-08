/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author vinic
 */
public class TelaBoasVindas extends JFrame{
    //private JButton comecar = new JButton("Start");
    private final JLabel boasVindas = new JLabel("Olá, bem-vindo ao Strategy Game!!! \n ");
    private final JLabel textoBoasVindas = new JLabel("Nesse jogo você lutará em um campo de batalha onde seu objetivo principal é capturar a bandeira inimiga 🏴, boa sorte!!!");
    
    GridBagConstraints g = new GridBagConstraints();
    public TelaBoasVindas(){
       setSize(500,500);
       setLocationRelativeTo(null);
       setTitle("Strategy Game!");
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(new GridBagLayout());
       
       g.insets = new java.awt.Insets(1, 1, 1, 1);
       g.gridx = 0;
       g.gridy = 0;
       boasVindas.setFont(new Font("Segoe UI", Font.PLAIN, 20));
       add(boasVindas,g);
       
        g.gridx = 0;
        g.gridy = 2;
        g.weightx = 1.0;
        g.weighty = 1.0;
        g.anchor = GridBagConstraints.NORTHWEST;
        g.fill = GridBagConstraints.BOTH;
        g.gridwidth = GridBagConstraints.REMAINDER;
        add(textoBoasVindas, g);
    }
    
}
