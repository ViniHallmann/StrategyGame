/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author jvlai
 */
public final class BotoesPecas extends JPanel{
    public static final int NUMERO_DE_ROLES = 6;
    
    private final Celula[] botoes;
    
    private boolean flagColocada = false;
    
    GridBagConstraints  r = new GridBagConstraints();
    
    int numerosCabosArmeiros;
    int numerosBombas;
    int numerosSoldados;
    
    public BotoesPecas()
    {
        botoes = new Celula[NUMERO_DE_ROLES];
        setLayout(new GridBagLayout());
        constroiBotoesPecas();
    }
    
    public void constroiBotoesPecas(){
        
        r.insets = new java.awt.Insets(40, 1, 1, 1);
        
        r.gridx = 0;
        botoes[0] = CelulaFactory.factory('B');
        add(botoes[0],r);
        
        r.gridx = 1;
        botoes[1] = CelulaFactory.factory('C');
        add(botoes[1],r);
        
        r.gridx = 2;
        botoes[2] = CelulaFactory.factory('S');
        add(botoes[2],r);
        
        r.gridx = 3;
        botoes[3] = CelulaFactory.factory('M');
        add(botoes[3],r);
        
        r.gridx = 4;
        botoes[4] = CelulaFactory.factory('E');
        add(botoes[4],r);
        
        r.gridx = 5;
        botoes[5] = CelulaFactory.factory('F');
        add(botoes[5],r);

        for(int i = 0 ; i < NUMERO_DE_ROLES; i ++)
            botoes[i].setEnabled(false);
        
        r.gridy = 1;
        r.insets = new java.awt.Insets(1, 1, 1, 1);
    }
    
    public void setFlagPosicionada(boolean flagPosicionada)
    {
        this.flagColocada = flagPosicionada;
    }
    public void resetaBotoesPecas()
    {
        for(int i = 0 ; i < NUMERO_DE_ROLES; i++)
        {
            remove(botoes[i]);
        }
        constroiBotoesPecas();
    }
   /* public void setMouseListeners(Tabuleiro tabuleiro)
    {
        if(flagColocada)
        {
            for(int i = 0; i < NUMERO_DE_ROLES-1 ; i++)
            {   
                botoes[i].setEnabled(true);
                botoes[5].setEnabled(false);
                botoes[i].addMouseListener(new MouseAdapter() 
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
        }
        else
        {
            botoes[5].setEnabled(true);
            botoes[5].addMouseListener(new MouseAdapter() 
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
    }*/
    public Celula getBotoes(int index)
    {
        return botoes[index];
    }
}
