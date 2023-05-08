/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author jvlai
 */
public class BoardSub extends JFrame{
    Tabuleiro tabuleiro = new Tabuleiro();
    BotoesPecas botoesPecas = new BotoesPecas();
    BotoesUtil botoesUtil = new BotoesUtil();
    private final int NUMERO_DE_ROLES = 6; 
    private boolean flagPosicionada = false;
    
    public BoardSub()
    {
       setTitle("STRATEGY GAME");
       setSize(600,600);
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
       add(botoesUtil,g);
       g.insets = new java.awt.Insets(5, 1, 1, 1);
       
       addPecasAdversario(botoesUtil.getBotao(0));
       addPecasJogador(botoesUtil.getBotao(1));
       addResetTabuleiro(g,botoesUtil.getBotao(2));
       addMudaRodada(botoesUtil.getBotao(3));
       addDebug(botoesUtil.getBotao(4));
       addDica(botoesUtil.getBotao(5));
       
       rodadaPosicionarFlag();
       
    }
    
    public void addPecasAdversario( JButton pecasAdversario){
        pecasAdversario.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                   tabuleiro.setPecasAleatorias(-1);
                   tabuleiro.repaint();
                   tabuleiro.revalidate();     
            }
        });
    }
    
    public void addPecasJogador( JButton pecasJogador){
        pecasJogador.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                   tabuleiro.setPecasAleatorias(1);
                   tabuleiro.repaint();
                   tabuleiro.revalidate();
                   
                }
            });
    }
       
    public void addResetTabuleiro(GridBagConstraints g,JButton resetTabuleiro){
        resetTabuleiro.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                   tabuleiro.resetaTabuleiro();
                   flagPosicionada = false;
                   g.gridx = 0;
                   g.gridy = 1;
                   add(botoesPecas,g);
                   botoesPecas.resetaBotoesPecas();
                   rodadaPosicionarFlag();
                   botoesUtil.remove(botoesUtil.getBotao(0));
                   botoesUtil.remove(botoesUtil.getBotao(1));
                   GridBagConstraints r = botoesUtil.getConstrains();
                   r.gridx = 0;
                   r.gridy = 0;
                   botoesUtil.add(botoesUtil.getBotao(0),r);
                   r.gridy = 1;
                   botoesUtil.add(botoesUtil.getBotao(1),r);
                   addPecasAdversario(botoesUtil.getBotao(0));
                   addPecasJogador(botoesUtil.getBotao(1));
                   tabuleiro.repaint();
                   tabuleiro.revalidate();
                }
            });
    }
    
    public void addMudaRodada(JButton mudaRodada){
        mudaRodada.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                   tabuleiro.copiaTabuleiro();
                   tabuleiro.mudaRodada();
                   botoesUtil.remove(botoesUtil.getBotao(0));
                   botoesUtil.remove(botoesUtil.getBotao(1));
                   remove(botoesPecas);
                   repaint();
                   tabuleiro.repaint();
                   tabuleiro.revalidate();
                }
            });
    }
    
    public void addDebug(JButton debug){
        debug.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                   tabuleiro.debugBoard();
                }
            });
    }
       
    public void addDica(JButton imprimeMatriz){
        imprimeMatriz.setSize(50, 10);
        imprimeMatriz.addMouseListener(new MouseAdapter() {
                 public void mouseClicked(MouseEvent e) {
                    tabuleiro.dicaBomba();
                 }
             });
    }
       
    public void rodadaPosicionarFlag()
    {
        for(int i = 0 ; i < NUMERO_DE_ROLES-1; i++)
        {
            botoesPecas.getBotoes(i).setEnabled(false);
        }
            botoesPecas.getBotoes(5).setEnabled(true);
            botoesPecas.getBotoes(5).addMouseListener(new MouseAdapter() 
                {
                    public void mouseClicked(MouseEvent e) 
                    {   
                        Celula botaoClicado = (Celula)e.getSource();
                        System.out.println(botaoClicado.getPeca().getTipo()+" selecionado");
                        tabuleiro.setCelulaSelecionada(botaoClicado);
                        tabuleiro.atualizaTabuleiro();
                    }
                });
        for(int i = 0; i < 5; i++)
        {
            for(int j = 3; j < 5; j++)
            {
                tabuleiro.getCelula(i,j).addMouseListener(new MouseAdapter(){
                        @Override
                        public void mouseClicked(MouseEvent e) {
                        if(tabuleiro.getCelulaSelecionada() != null)
                        {    
                            System.out.println("CLICADO");
                            Celula botaoClicado = (Celula) e.getSource();
                            tabuleiro.colocaPeçaNoTabuleiro(botaoClicado, botaoClicado.getPosX(), botaoClicado.getPosY());
                            revalidate();
                            repaint();
                            tabuleiro.setCelulaSelecionada(null);
                            tabuleiro.atualizaTabuleiro();
                            if(!flagPosicionada)
                            {
                                flagPosicionada = true;
                                rodadaPosicionarResto();
                            }

                        }
                    }
                });
            }
        }
        
    }
    
    public void rodadaPosicionarResto()
    {
        for(int i = 0 ; i < NUMERO_DE_ROLES-1; i++)
        {
            botoesPecas.getBotoes(i).setEnabled(true);
            botoesPecas.getBotoes(i).addMouseListener(new MouseAdapter() 
                {
                    public void mouseClicked(MouseEvent e) 
                    {   
                        Celula botaoClicado = (Celula)e.getSource();
                        System.out.println(botaoClicado.getPeca().getTipo()+" selecionado");
                        tabuleiro.setCelulaSelecionada(botaoClicado);
                        tabuleiro.atualizaTabuleiro();
                    }
                });
        }
        botoesPecas.getBotoes(5).setEnabled(false);
    }
    
    /*public void addLabelPecasDisponiveis(GridBagConstraints g)
    {
        for (int i = 0; i < 5; i++){
            g.gridx = i;
            g.gridy = 1;
            JLabel label = new JLabel("TESTE");
            add(label,g);
        }
    }*/
}
