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
import javax.swing.JLabel;

/**
 *
 * @author jvlai
 */
public class BoardSub extends JFrame{
    Tabuleiro tabuleiro = new Tabuleiro();
    BotoesPecas botoesPecas = new BotoesPecas(tabuleiro);
    JButton pecasAdversario = new JButton("Pecas do Adversario");
    JButton pecasJogador = new JButton("Pecas Aleatorias");
    JButton resetTabuleiro = new JButton("Resetar Tabuleiro");
    JButton mudaRodada = new JButton("Muda Rodada");
    JButton debug = new JButton("debug");
    JButton imprimeMatriz = new JButton("Imprime Matriz");
    JLabel imprimePeca = new JLabel("Nenhuma peça selecionada");
    
    private final int NUMERO_DE_ROLES = 6; 
    private boolean flagPosicionada = false;
    
    public BoardSub()
    {
       setTitle("STRATEGY GAME");
       setSize(800,600);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       
       setLayout(new GridBagLayout());
       GridBagConstraints  g = new GridBagConstraints();
       g.gridx = 0;
       g.gridy = 0;
       add(tabuleiro,g);
       g.gridy = 1;
       add(botoesPecas,g);
       g.insets = new java.awt.Insets(5, 1, 1, 1);
       addPecasAdversario(g);
       addPecasJogador(g);
       addResetTabuleiro(g);
       addMudaRodada(g);
       addDebug(g);
       addImprimeMatriz(g);
       rodadaPosicionarFlag();
       
    }
    
    public void addPecasAdversario(GridBagConstraints g){
        g.gridx = 1;
        g.gridy = 0;
        
        pecasAdversario.setSize(50, 10);
        pecasAdversario.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                   tabuleiro.setPecasAleatorias(-1);
                   tabuleiro.repaint();
                   tabuleiro.revalidate();     
            }
        });
        add(pecasAdversario,g);
    }
    
    public void addPecasJogador(GridBagConstraints g){
        g.gridx = 2;
        g.gridy = 0;
        pecasJogador.setSize(50, 10);
        pecasJogador.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                   tabuleiro.setPecasAleatorias(1);
                   tabuleiro.repaint();
                   tabuleiro.revalidate();
                   
                }
            });
        add(pecasJogador,g);
    }
       
    public void addResetTabuleiro(GridBagConstraints g){
        g.gridx = 1;
        g.gridy = 1;
        resetTabuleiro.setSize(50, 10);
        resetTabuleiro.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                   tabuleiro.resetaTabuleiro();
                   flagPosicionada = false;
                   g.gridx = 0;
                   g.gridy = 1;
                   add(botoesPecas,g);
                   botoesPecas.resetaBotoesPecas();
                   rodadaPosicionarFlag();
                   remove(pecasJogador);
                   remove(pecasAdversario);
                   addPecasJogador(g);
                   addPecasAdversario(g);
                   tabuleiro.repaint();
                   tabuleiro.revalidate();
                }
            });
        add(resetTabuleiro,g);
    }
    
    public void addMudaRodada(GridBagConstraints g){
        g.gridx = 2;
        g.gridy = 1;
        mudaRodada.setSize(50, 10);
        mudaRodada.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                   tabuleiro.mudaRodada();
                   remove(pecasAdversario);
                   remove(pecasJogador);
                   remove(botoesPecas);
                   repaint();
                   tabuleiro.repaint();
                }
            });
        add(mudaRodada,g);
    }
    
    public void addDebug(GridBagConstraints g){
        g.gridx = 1;
        g.gridy = 3;
       
        debug.setSize(50, 10);
        debug.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                   tabuleiro.debugBoard();
                }
            });
        add(debug,g);
    }
       
    public void addImprimeMatriz(GridBagConstraints g){
        g.gridx = 2;
        g.gridy = 3;
       
        imprimeMatriz.setSize(50, 10);
        imprimeMatriz.addMouseListener(new MouseAdapter() {
                 public void mouseClicked(MouseEvent e) {
                    tabuleiro.dicaBomba();
                 }
             });
        add(imprimeMatriz,g);
    }
       
    public void addImprimePeca(GridBagConstraints g){
        g.gridx = 2;
        g.gridy = 2;

        imprimePeca.setSize(50, 10);
        imprimePeca.setText(tabuleiro.imprimePeca());
        //add(imprimePeca,g);
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

}
