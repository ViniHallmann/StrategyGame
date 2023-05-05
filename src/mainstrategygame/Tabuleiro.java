/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Math.sqrt;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.Border;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 *
 * @author jvlai
 */
public class Tabuleiro extends JPanel{
    public static final int NUMERO_DE_CASAS = 25;
    private Celula[][] tabuleiro;
    
    private Peça peçaSelecionada;
    private String nomeDaPeça;
    private char tipoDePeça;
    
    private Peça peçaPosicionada;
    
    public Tabuleiro()
    {
        tabuleiro = new Celula[(int)(sqrt(NUMERO_DE_CASAS))][(int)(sqrt(NUMERO_DE_CASAS))];
        setLayout(new GridBagLayout());
        constroiTabuleiro();
    }
    //Coloquei esses getters e setters pra conseguir fazer os bagulho
    public void setPeçaSelecionada(Peça peçaSelecionada) {
        this.peçaSelecionada = peçaSelecionada;
        atualizaTabuleiro();
    }
    public void setTipoDePeça(char tipoDePeça){
        this.tipoDePeça = tipoDePeça;
    }
    public void setNomeDaPeça(String nomeDaPeça){
        this.nomeDaPeça = nomeDaPeça;
    }
    
    public Peça getPeçaSelecionada() {
        return peçaSelecionada;
    }

    public String getNomeDaPeça() {
        return nomeDaPeça;
    }

    public char getTipoDePeça() {
        return tipoDePeça;
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
                g.gridy=j;
                //Cria o tabuleiro
                tabuleiro[i][j] = CelulaFactory.factory(' ');
                tabuleiro[i][j].setBackground(new java.awt.Color(204, 255, 204));
                tabuleiro[i][j].setPreferredSize(new java.awt.Dimension(50, 50));
                
                //Seta o tabuleiro como falso
                tabuleiro[i][j].setEnabled(false);
                //Pega as coordenadas da matriz
                final int x = i;
                final int y = j;
                //Ao clicar no botão pega as "informações do botão" e chama a função que coloca uma peça na posição desse botão
                tabuleiro[i][j].addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent e) 
                    {   
                        Celula botãoClicado = (Celula) e.getSource();
                        colocaPeçaNoTabuleiro(botãoClicado, x, y);
                    }
                });
                //MUDEI AS POSIÇÕES DO LAGO!!!
                if((i == 1 && j == 2)||(i == 3 && j == 2))
                {
                    tabuleiro[i][j].setEnabled(false);
                    tabuleiro[i][j].setBackground(new java.awt.Color(204, 204, 255));
                }
                
                add(tabuleiro[i][j],g);
            }
        }
    }
   
    public void colocaPeçaNoTabuleiro(Celula botãoClicado, int x, int y)
    {
        for (int i = 0; i < sqrt(NUMERO_DE_CASAS); i++) 
        {
            for (int j = 0; j < sqrt(NUMERO_DE_CASAS); j++) 
            {
                if (x == i && y == j){
                    if (j > 2){
                        
                        Celula novaCelula = CelulaFactory.factory(getTipoDePeça());
                        tabuleiro[i][j] = novaCelula;
                        //Só copiei o botão já feito, mas não ta ficando igual, não sei o que mais tem que mudar nele
                        //r.setBackground(new Color(255, 255, 255));
                        GridBagConstraints  r = new GridBagConstraints();
                        r.insets = new java.awt.Insets(20, 1, 1, 1); 
                        r.gridx = x;
                        r.gridy = y;
                        
                        //ChatGPT fez a boa nessa daqui, pq eu não sabia como colocar um bagulho em cima do outro
                        remove(botãoClicado);
                        add(novaCelula, r);
                        revalidate();
                        repaint();
                        

                        setPeçaSelecionada(null);
                        //Não to conseguindo zerar o tipoDePeça????
                        //setTipoDePeça(null);
                        setNomeDaPeça(null);
                    }
                    
                }
            }
        }
    }
    
    private void atualizaTabuleiro() {
        for (int i = 0; i < sqrt(NUMERO_DE_CASAS); i++) {
            for (int j = 0; j < sqrt(NUMERO_DE_CASAS); j++) {
                if (peçaSelecionada != null) {
                    tabuleiro[i][j].setEnabled(true);
                }   else {
                    tabuleiro[i][j].setEnabled(false);
                }
            }
        }
    }

}
