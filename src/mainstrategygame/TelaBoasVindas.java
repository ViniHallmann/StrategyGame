/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame; 

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
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
    private final JLabel boasVindas = new JLabel("Bem-vindo ao Strategy Game!!! \n ");

    private final JLabel textoBoasVindas = new JLabel("<html><div style='text-align: center;'>" +
        "Nesse jogo você lutará em um campo de batalha onde seu objetivo é capturar a bandeira inimiga 🏴<br><br>" +
        "Prepare seu exército, monte sua melhor estratégia e derrote seu inimigo 🎖 Boa sorte ⭐⭐⭐" +
        "</div></html>");
    private final JButton continuar = new JButton();
    GridBagConstraints g = new GridBagConstraints();
    public TelaBoasVindas(){
        
        setSize(800,600);
        setLocationRelativeTo(null);
        setTitle("STRATEGY GAME");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        Color corBotao = new java.awt.Color(204, 255, 204);
        g.insets = new java.awt.Insets(25, 1, 1, 1);
        g.gridx = 0;
        g.gridy = 0;
        boasVindas.setFont(new Font("Segoe UI", Font.PLAIN, 50));
        //boasVindas.setForeground(corBotao);
        add(boasVindas,g);
        g.gridx = 0;
        g.gridy = 3;
        continuar.setPreferredSize(new java.awt.Dimension(300,50));
        continuar.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        continuar.setBackground(new java.awt.Color(204,255,204));
        continuar.setText("Continuar");
        add(continuar,g);
        g.gridy = 2;

        textoBoasVindas.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        add(textoBoasVindas, g);
    }
    public JButton getBotaoContinuar() {
        return continuar;
    }
}
