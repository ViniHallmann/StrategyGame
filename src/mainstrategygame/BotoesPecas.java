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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jvlai
 */
public final class BotoesPecas extends JPanel{
    public static final int NUMERO_DE_ROLES = 6;
    
    private final Celula[] botoes;
    
    private Celula botãoSelecionado = null;
    private Peça peçaSelecionada = null;
    private Tabuleiro tabuleiro;
    
    int numerosCabosArmeiros;
    int numerosBombas;
    int numerosSoldados;
    
    public BotoesPecas(Tabuleiro tabuleiro)
    {
        this.tabuleiro = tabuleiro;
        botoes = new Celula[NUMERO_DE_ROLES];
        setLayout(new GridBagLayout());
        constroiBotoesPecas();
    }
    
    public void constroiBotoesPecas(){
        GridBagConstraints  r = new GridBagConstraints();
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

        
        r.gridy = 1;
        r.insets = new java.awt.Insets(1, 1, 1, 1);
      
        int numeroMarechal;
        int numeroEspiao;
        int numeroBandeira;
        
        if ( tabuleiro.isMarechalDisponivel())
        {
            numeroMarechal = 1;
        }
        else {
            numeroMarechal = 0;
        }
        if ( tabuleiro.isEspiaoDisponivel())
        {
            numeroEspiao = 1;
        }
        else {
            numeroEspiao = 0;
        }
        if ( tabuleiro.isBandeiraDisponivel())
        {
            numeroBandeira = 1;
        }
        else {
            numeroBandeira = 0;
        }
        /*numerosBombas = tabuleiro.getBombasDisponiveis();
        numerosCabosArmeiros = tabuleiro.getBombasDisponiveis();
        numerosSoldados = tabuleiro.getBombasDisponiveis();
        r.gridx = 0;
        JLabel titulo_1 = new JLabel(" "+numerosBombas);
        add(titulo_1,r);
        
        r.gridx = 1;
        
        JLabel titulo_2 = new JLabel(" "+numerosCabosArmeiros);
        add(titulo_2,r);
        
        r.gridx = 2;
        JLabel titulo_3 = new JLabel(" " +numerosSoldados);
        add(titulo_3,r);
        
        r.gridx = 3;
        JLabel titulo_4 = new JLabel(" "+numeroMarechal);
        add(titulo_4,r);
        
        r.gridx = 4;
        JLabel titulo_5 = new JLabel(" "+numeroEspiao);
        add(titulo_5,r);
        
        r.gridx = 5;
        JLabel titulo_6 = new JLabel(" "+numeroBandeira);
        add(titulo_6,r);
        */

        //
        for(int i = 0; i < NUMERO_DE_ROLES ; i++)
        {   
            Celula botãoAtual = botoes[i];
            botoes[i].addMouseListener(new MouseAdapter() 
            {
                public void mouseClicked(MouseEvent e) 
                {   
                    Peça peça = botãoAtual.getPeca();
                    String nome = peça.getNome();
                    char tipo = botãoAtual.getPeca().getTipo();

                    tabuleiro.setPeçaSelecionada(peça);
                    tabuleiro.setTipoDePeça(tipo);
                    tabuleiro.setNomeDaPeça(nome);
                }
            });
        }
    }
}
