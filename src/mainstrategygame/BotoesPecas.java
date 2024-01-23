/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jvlai
 */
public final class BotoesPecas extends JPanel{
    public static final int NUMERO_DE_ROLES = 6;
     
    private final Celula[] botoes;
    private JLabel[] quantidades;
    
    GridBagConstraints  r = new GridBagConstraints();
    
    private boolean bandeiraDisponivel = true;
    private boolean marechalDisponivel = true;
    private boolean espiaoDisponivel = true;
    private int soldadosDisponiveis = 3;
    private int caboArmeiroDisponiveis = 2;
    private int bombasDisponiveis = 2;
    
    
    
    public BotoesPecas()
    {
        botoes = new Celula[NUMERO_DE_ROLES];
        quantidades = new JLabel[NUMERO_DE_ROLES];
        for(int i = 0; i < NUMERO_DE_ROLES ; i++){
            quantidades[i] = new JLabel("teste");
            add(quantidades[i],r);
        }
        setLayout(new GridBagLayout());
        constroiBotoesPecas();
    }
    
    public void constroiBotoesPecas()
    {
        r.insets = new java.awt.Insets(40, 1, 1, 1);
        r.gridx = 0;
        botoes[0] = CelulaFactory.factory('B',1);
        add(botoes[0],r);
        
        r.gridx = 1;
        botoes[1] = CelulaFactory.factory('C',1);
        add(botoes[1],r);
        
        r.gridx = 2;
        botoes[2] = CelulaFactory.factory('S', 1);
        add(botoes[2],r);
        
        r.gridx = 3;
        botoes[3] = CelulaFactory.factory('M',1);
        add(botoes[3],r);
        
        r.gridx = 4;
        botoes[4] = CelulaFactory.factory('E',1);
        add(botoes[4],r);
        
        r.gridx = 5;
        botoes[5] = CelulaFactory.factory('F',1);
        add(botoes[5],r);
        resetaBotoes();
        r.insets = new java.awt.Insets(1, 1, 1, 1);
    }
    
    public void quantidadeDePecas(int bombas, int cabos, int soldados, boolean marechal, boolean espiao, boolean flag)
    {
        
        r.gridy = 1;
        
            
        int marechalVal, flagVal, espiaoVal;
        
        if(marechal)
           marechalVal = 1;
        else
            marechalVal = 0;
        
        if(flag)
           flagVal = 1;
        else
            flagVal = 0;
        
        if(espiao)
           espiaoVal = 1;
        else
            espiaoVal = 0;
        
        int array[] = {bombas, cabos, soldados, marechalVal, espiaoVal, flagVal};
        
        for(int i = 0 ; i < NUMERO_DE_ROLES; i++)
        {
            r.gridx = i;
            r.gridy = 1;
            remove(quantidades[i]);
            quantidades[i].setText(Integer.toString(array[i]));
            add(quantidades[i],r);
            quantidades[i].repaint();
            revalidate();
        }
    }
    public void resetaBotoes()
    {
        for (int i = 0; i < botoes.length; i++) 
        {
            botoes[i].setIcon(null);
            botoes[i].setBackground(new Color(204, 204, 255));
        }
    }
    
    public void resetaBotoesPecas()
    {
        for(int i = 0 ; i < NUMERO_DE_ROLES; i++)
        {
            remove(botoes[i]);
        }
        constroiBotoesPecas();
    } 

    public Celula getBotoes(int index)
    {
        return botoes[index];
    }
    
    public void iteradorPeçasDisponiveis(Celula celula)
    {
        switch(celula.getPeca().getTipo()){
            case 'B':
                bombasDisponiveis--;
                return;
            case 'C':
                caboArmeiroDisponiveis--;
                return;
            case 'S':
                soldadosDisponiveis--;
                return;
            case 'M':
                marechalDisponivel = false;
                return;
            case 'E':
                espiaoDisponivel = false;
                return;
            case 'F':
                bandeiraDisponivel = false;
                return;
        }
    }
}
