/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Math.sqrt;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static mainstrategygame.Tabuleiro.NUMERO_DE_CASAS;

/**
 *
 * @author jvlai
 */
public class BoardSub extends JFrame{
    Tabuleiro tabuleiro = new Tabuleiro();  
    Tabuleiro reserva;
    BotoesPecas botoesPecas = new BotoesPecas();
    BotoesUtil botoesUtil = new BotoesUtil();

    GridBagConstraints  g = new GridBagConstraints();

    private final int NUMERO_DE_ROLES = 6; 
    private boolean flagPosicionada = false;
    
    private boolean bandeiraJogadorDisponivel = false;
    private boolean marechalJogadorDisponivel = false;
    private boolean espiaoJogadorDisponivel = false;
    private int soldadosJogadorDisponiveis = 0;
    private int caboArmeiroJogadorDisponiveis = 0;
    private int bombasJogadorDisponiveis = 0;
    
    public BoardSub()
    {
       setTitle("STRATEGY GAME");
       setSize(600,600);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       
       setLayout(new GridBagLayout());
       
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
                    
                   botoesPecas.resetaBotoesPecas();
                   tabuleiro.resetaTabuleiro();
                   resetNumeroDePecas();
                   bandeiraJogadorDisponivel = false;
                   g.gridx = 0;
                   g.gridy = 1;
                   add(botoesPecas,g);
                   
                   GridBagConstraints r = botoesUtil.getConstrains();
                   r.gridx = 0;
                   r.gridy = 0;
                   botoesUtil.add(botoesUtil.getBotao(0),r);
                   r.gridy = 1;
                   botoesUtil.add(botoesUtil.getBotao(1),r);
                   addPecasAdversario(botoesUtil.getBotao(0));
                   addPecasJogador(botoesUtil.getBotao(1));
                   
                   botoesPecas.repaint();
                   botoesPecas.revalidate();
                   tabuleiro.repaint();
                   tabuleiro.revalidate();
                   
                   rodadaPosicionarFlag();
                }
            });
    }
    
    public void addMudaRodada(JButton mudaRodada){
        mudaRodada.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if(verificaPeçasPosicionadas())
                    {    
                        tabuleiro.copiaTabuleiro();
                        mudaRodada();
                        tabuleiro.resetQuantidadeDePecas();
                        botoesUtil.remove(botoesUtil.getBotao(0));
                        botoesUtil.remove(botoesUtil.getBotao(1));
                        remove(botoesPecas);
                        repaint();
                        tabuleiro.repaint();
                        revalidate();
                    }
                    else
                    {
                        //PARA VINI: IMPLEMENTAR UMA JANELA DE AVISO FALANDO QUE FALTA PECAS A SEREM ADICIONADAS
                    }
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
            
                tabuleiro.getCelula(i,4).addMouseListener(new MouseAdapter(){
                        @Override
                        public void mouseClicked(MouseEvent e) {
                        if(tabuleiro.getCelulaSelecionada() != null)
                        {    
                            System.out.println("CLICADO");
                            Celula botaoClicado = (Celula) e.getSource();
                            tabuleiro.colocaPeçaNoTabuleiro(botaoClicado, botaoClicado.getPosX(), botaoClicado.getPosY());
                            if(bandeiraJogadorDisponivel)
                            {
                                iteradorPeçasDisponiveis(tabuleiro.getCelulaSelecionada());
                            }
                            revalidate();
                            repaint();
                            tabuleiro.setCelulaSelecionada(null);
                            tabuleiro.atualizaTabuleiro();
                            if(!bandeiraJogadorDisponivel)
                            {
                                bandeiraJogadorDisponivel = true;
                                rodadaPosicionarResto();
                            }
                        }
                    }
                });
            
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
        for(int i = 0 ; i < sqrt(NUMERO_DE_CASAS); i++)
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
                            iteradorPeçasDisponiveis(tabuleiro.getCelulaSelecionada());
                            revalidate();
                            repaint();
                            tabuleiro.setCelulaSelecionada(null);
                            tabuleiro.atualizaTabuleiro();
                            
                        }
                    }
                });
            }
        }
        
        botoesPecas.getBotoes(5).setEnabled(false);
        
        for(MouseListener al : botoesPecas.getBotoes(5).getMouseListeners())
            botoesPecas.getBotoes(5).removeMouseListener(al);
        
        
    }

 
    public void mudaRodada(){
        System.out.println("            "+bombasJogadorDisponiveis);
        for (int i = 0; i < sqrt(NUMERO_DE_CASAS); i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                tabuleiro.getCelula(i, j).setEnabled(true);
                tabuleiro.getCelula(i, j).addMouseListener(new MouseAdapter() 
                {
                    public void mouseClicked(MouseEvent e) 
                    {
                        
                        Celula botaoClicado = (Celula) e.getSource();
                        System.out.println("botaoClicado:"+botaoClicado.getPosX()+" "+botaoClicado.getPosY());
                        if ( tabuleiro.getUltimoBotaoClicado() != null && tabuleiro.validaMovimento(botaoClicado,botaoClicado.getPosX(),botaoClicado.getPosY()))
                        {
                            tabuleiro.movePeca(botaoClicado, botaoClicado.getPosX(), botaoClicado.getPosY(),tabuleiro.getUltimoBotaoClicado(), tabuleiro.getCoordenadasUltimoBotao('x'),tabuleiro.getCoordenadasUltimoBotao('y'));
                            tabuleiro.resetaUltimoBotaoClicado();
                            if(tabuleiro.getResuldadoCombate() == 3)
                                vitoriaDoJogador(true);
                            else
                            {
                                tabuleiro.movePecaAdversaria();
                                if(tabuleiro.getResuldadoCombate() == 3)
                                    vitoriaDoJogador(false);
                                
                            }
                                
                        } 
                    }
                });
            }
        }
        
        for (int i = 0; i < 5; i++)
        {
            for (int j = 3; j < 5; j++)
            {
                tabuleiro.getCelula(i, j).setEnabled(true);
                tabuleiro.getCelula(i, j).addMouseListener(new MouseAdapter() 
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                    {   
                        Celula botaoClicado = (Celula) e.getSource();

                        tabuleiro.setUltimoBotaoClicado(botaoClicado);
                       // System.out.println(tabuleiro.getUltimoBotaoClicado().getPeca());

                        tabuleiro.setCoordenadasUltimoBotao(botaoClicado.getPosX(),botaoClicado.getPosY());
                        System.out.println(tabuleiro.getCoordenadasUltimoBotao('x') +" "+ tabuleiro.getCoordenadasUltimoBotao('y'));
                       
                    }
                });   
            }
        }
        
        
    }
    public void adicionarListener(Celula celula)
    {
        
        celula.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) 
                    {
                        
                        Celula botaoClicado = (Celula) e.getSource();
                        System.out.println("botaoClicado:"+botaoClicado.getPosX()+" "+botaoClicado.getPosY());
                        if ( tabuleiro.getUltimoBotaoClicado() != null && tabuleiro.validaMovimento(botaoClicado,botaoClicado.getPosX(),botaoClicado.getPosY()))
                        {
                            tabuleiro.movePeca(botaoClicado, botaoClicado.getPosX(), botaoClicado.getPosY(),tabuleiro.getUltimoBotaoClicado(), tabuleiro.getCoordenadasUltimoBotao('x'),tabuleiro.getCoordenadasUltimoBotao('y'));
                            tabuleiro.resetaUltimoBotaoClicado();
                        } 
                    }
                });
    }

    public void vitoriaDoJogador(boolean equipeGanhadora) 
    {
        
        Object[] opcoes = {"Fechar jogo", "Reiniciar Jogo", "Novo Jogo"};
        int opcao;
        if(equipeGanhadora)
            opcao = JOptionPane.showOptionDialog(null,"O Jogador venceu o jogo!", "",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[2]);
        else
            opcao = JOptionPane.showOptionDialog(null,"O Jogador PERDEU o jogo!", "",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes,opcoes[2]);
            
        if (opcao == 0)
        {
            System.exit(0);
        }
        if (opcao == 1)
        {
            tabuleiro.trocaTabuleiro();
            mudaRodada();
        }
        if (opcao == 2)
        {
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
    }
    public void iteradorPeçasDisponiveis(Celula tipoDePeça)
    {
        switch(tipoDePeça.getPeca().getTipo()){
            case 'B':
                if(bombasJogadorDisponiveis < 2)
                {
                    bombasJogadorDisponiveis++;
                    if(bombasJogadorDisponiveis == 2)
                    {
                        botoesPecas.getBotoes(0).setEnabled(false);

                        for(MouseListener ml : botoesPecas.getBotoes(0).getMouseListeners())
                            botoesPecas.getBotoes(0).removeMouseListener(ml);

                    }
                }
                   
                return;
            case 'C':
                if(caboArmeiroJogadorDisponiveis < 2)
                {
                    caboArmeiroJogadorDisponiveis++;
                    if(caboArmeiroJogadorDisponiveis == 2)
                    {
                        botoesPecas.getBotoes(1).setEnabled(false);

                        for(MouseListener ml : botoesPecas.getBotoes(1).getMouseListeners())
                            botoesPecas.getBotoes(1).removeMouseListener(ml);

                    }
                }
                return;
            case 'S':
                if(soldadosJogadorDisponiveis < 3)
                {
                    soldadosJogadorDisponiveis++;
                    if(soldadosJogadorDisponiveis == 3)
                    {
                        botoesPecas.getBotoes(2).setEnabled(false);

                        for(MouseListener ml : botoesPecas.getBotoes(2).getMouseListeners())
                            botoesPecas.getBotoes(2).removeMouseListener(ml);

                    }
                }
                return;
            case 'M':
                if(marechalJogadorDisponivel == false)
                {
                    marechalJogadorDisponivel = true;
                    if(marechalJogadorDisponivel)
                    {
                        botoesPecas.getBotoes(3).setEnabled(false);

                        for(MouseListener ml : botoesPecas.getBotoes(3).getMouseListeners())
                            botoesPecas.getBotoes(3).removeMouseListener(ml);

                    }
                }
                return;
            case 'E':
                if(espiaoJogadorDisponivel == false)
                {
                    espiaoJogadorDisponivel = true;
                    if(espiaoJogadorDisponivel)
                    {
                        botoesPecas.getBotoes(4).setEnabled(false);

                        for(MouseListener ml : botoesPecas.getBotoes(4).getMouseListeners())
                            botoesPecas.getBotoes(4).removeMouseListener(ml);

                    }
                }
                return;
        }
    }
    
    public boolean verificaPeçasPosicionadas(){
        
        return bombasJogadorDisponiveis == 2 &&
                caboArmeiroJogadorDisponiveis == 2 &&
                soldadosJogadorDisponiveis == 3 &&
                marechalJogadorDisponivel == true &&
                espiaoJogadorDisponivel == true &&
                bandeiraJogadorDisponivel == true;
        
        
    }
    public void resetNumeroDePecas()
    {
        bandeiraJogadorDisponivel = false;
        marechalJogadorDisponivel = false;
        espiaoJogadorDisponivel = false;
        soldadosJogadorDisponiveis = 0;
        caboArmeiroJogadorDisponiveis = 0;
        bombasJogadorDisponiveis = 0;
    }
}
