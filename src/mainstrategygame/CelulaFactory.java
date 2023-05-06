/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import java.awt.Color;
import javax.swing.BorderFactory;

/**
 *
 * @author jvlai
 */
public final class CelulaFactory{
    
    private static final Color corAdversario = new Color(255,204,204);
    private static final Color corJogador = new Color(175,175,255);
    private static final Color corVazio = new Color(204,255,204);
    private static final Color corBranco = new Color(255,255,255);
    
    private static boolean equipe = false;
    public static Celula factory(char tipo)
    {
       switch(tipo)
       {
           case ' ' : return criaCelulaVazio(corBranco);
           case 'B' : return criaCelulaBomba(corBranco);
           case 'C' : return criaCelulaCabo(corBranco);
           case 'S' : return criaCelulaSoldado(corBranco);
           case 'E' : return criaCelulaEspiao(corBranco);
           case 'F' : return criaCelulaBandeira(corBranco);
           case 'M' : return criaCelulaMarechal(corBranco);
       }
        return null;
    }
    public static Celula factory(char tipo, boolean equipe)
    {
        Celula nova;
        CelulaFactory.equipe = equipe;
        if(equipe)
        {
            switch(tipo)
            {
               case ' ' :  nova = criaCelulaVazio(corVazio);
                           return nova;
               case 'B' :  nova = criaCelulaBomba(corJogador);
                           nova.setEquipe(equipe);
                           return nova;
               case 'C' :  nova = criaCelulaCabo(corJogador);
                           nova.setEquipe(equipe);
                           return nova;
               case 'S' :  nova = criaCelulaSoldado(corJogador);
                           nova.setEquipe(equipe);
                           return nova;
               case 'E' :  nova = criaCelulaEspiao(corJogador);
                           nova.setEquipe(equipe);
                           return nova;
               case 'F' :  nova = criaCelulaBandeira(corJogador);
                           nova.setEquipe(equipe);
                           return nova;
               case 'M' :  nova = criaCelulaMarechal(corJogador);
                           nova.setEquipe(equipe);
                           return nova;
            }
            
        }else
        {
            switch(tipo)
            {
               case ' ' :  nova = criaCelulaVazio(corVazio);
                            nova.setEquipe(equipe);
                           return nova;
               case 'B' :  nova = criaCelulaBomba(corAdversario);
                           nova.setEquipe(equipe);
                           return nova;
               case 'C' :  nova = criaCelulaCabo(corAdversario);
                           nova.setEquipe(equipe);
                           return nova;
               case 'S' :  nova = criaCelulaSoldado(corAdversario);
                           nova.setEquipe(equipe);
                           return nova;
               case 'E' :  nova = criaCelulaEspiao(corAdversario);
                           nova.setEquipe(equipe);
                           return nova;
               case 'F' :  nova = criaCelulaBandeira(corAdversario);
                           nova.setEquipe(equipe);
                           return nova;
               case 'M' :  nova = criaCelulaMarechal(corAdversario);
                           nova.setEquipe(equipe);
                           return nova;
            }
        }
        return null;
    }
    
    public static Celula criaCelulaVazio(Color cor)
    {
        Celula celula = new Celula(' ',new Vazio(),equipe);
        celula.setBackground(cor);
        return celula;
    }
    public static Celula criaCelulaBomba(Color cor)
    {
        Celula celula = new Celula('B', new Bomba(),equipe);
        celula.setBackground(cor);
        return celula;
    }
    public static Celula criaCelulaCabo(Color cor)
    {
        Celula celula = new Celula('C', new CaboArmeiro(),equipe);
        celula.setBackground(cor);
        return celula; 
    }
    public static Celula criaCelulaEspiao(Color cor)
    {
        Celula celula = new Celula('E', new Espiao(),equipe);
        celula.setBackground(cor);
        return celula; 
    }
    public static Celula criaCelulaMarechal(Color cor)
    {
        Celula celula = new Celula('M', new Marechal(),equipe);
        celula.setBackground(cor);
        return celula; 
    }
    public static Celula criaCelulaBandeira(Color cor)
    {
        Celula celula = new Celula('F', new Bandeira(),equipe);
        celula.setBackground(cor);
        return celula; 
    }
    public static Celula criaCelulaSoldado(Color cor)
    {
        Celula celula = new Celula('S', new Soldado(),equipe);
        celula.setBackground(cor);
        return celula; 
    }   
}
