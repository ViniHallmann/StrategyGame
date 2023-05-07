/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author jvlai
 */
public class BotoesUtil extends JLabel{
    
    GridBagConstraints g = new GridBagConstraints();
    List<JButton> botoes = new ArrayList<>();
    JButton pecasAdversario = new JButton("Pecas do Adversario");
    JButton pecasJogador = new JButton("Pecas Aleatorias");
    JButton resetTabuleiro = new JButton("Resetar Tabuleiro");
    JButton mudaRodada = new JButton("Muda Rodada");
    JButton debug = new JButton("debug");
    JButton imprimeMatriz = new JButton("Imprime Matriz");
    
    BotoesUtil()
    {
        int qnt = 0;
        botoes.add(pecasAdversario);
        botoes.add(pecasJogador);
        botoes.add(resetTabuleiro);
        botoes.add(mudaRodada);
        botoes.add(debug);
        botoes.add(imprimeMatriz);
        
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                
                botoes.get(qnt).setSize(50, 50);
                
                g.gridx = i;
                g.gridy = j;
                
                add(botoes.get(qnt),g);
                qnt++;
            }
        }
    }
    
}
