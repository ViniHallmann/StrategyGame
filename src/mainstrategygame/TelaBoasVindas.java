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
    private final JLabel textoBoasVindas = new JLabel("<html>Nesse jogo você lutará em um campo de batalha onde seu objetivo é capturar a bandeira inimiga 🏴 <br> Prepare seu exercíto, monte sua melhor estratégia e derreto seu inimigo 🎖 Boa Sorte ⭐⭐⭐<br><html>");
    private final JButton continuar = new JButton();
    GridBagConstraints g = new GridBagConstraints();
    public TelaBoasVindas(){
       setSize(800,600);
       setLocationRelativeTo(null);
       setTitle("STRATEGY GAME");
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(new GridBagLayout());
       
       g.insets = new java.awt.Insets(25, 1, 1, 1);
       g.gridx = 0;
       g.gridy = 0;
       boasVindas.setFont(new Font("Segoe UI", Font.PLAIN, 25));
       add(boasVindas,g);
        g.gridx = 0;
        g.gridy = 3;
        continuar.setPreferredSize(new java.awt.Dimension(300,50));
        continuar.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        continuar.setBackground(new java.awt.Color(204,255,204));
        continuar.setText("Continuar");
        add(continuar,g);
        g.gridy = 2;
        //g.anchor = GridBagConstraints.NORTHWEST;
        //g.fill = GridBagConstraints.HORIZONTAL;
        //g.gridwidth = GridBagConstraints.REMAINDER;
        add(textoBoasVindas, g);
        
    }
}
