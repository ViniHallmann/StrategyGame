/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import java.awt.Color;

/**
 *
 * @author jvlai
 */
public abstract class CelulaFactory{
     
    private static final Color COR_ADVERSARIO = new Color(255,204,204);
    private static final Color COR_JOGADOR = new Color(175,175,255);
    private static final Color COR_VAZIO = new Color(204,255,204);
    private static final Color COR_BRANCO = new Color(255,255,255);
    
    private static int equipe = 0;
    public static Celula factory(char tipo)
    {
       switch(tipo)
       {
           case ' ' : return criaCelulaVazio();
           case 'B' : return criaCelulaBomba(COR_BRANCO);
           case 'C' : return criaCelulaCabo(COR_BRANCO);
           case 'S' : return criaCelulaSoldado(COR_BRANCO);
           case 'E' : return criaCelulaEspiao(COR_BRANCO);
           case 'F' : return criaCelulaBandeira(COR_BRANCO);
           case 'M' : return criaCelulaMarechal(COR_BRANCO);
       }
        return null; 
    }
    public static Celula factory(char tipo, int equipe)
    {
        Celula nova;
        CelulaFactory.equipe = equipe;
        if(equipe == 1 && tipo != ' ')
        {
            switch(tipo)
            {
               case 'B' :  nova = criaCelulaBomba(COR_JOGADOR);
                           nova.setEquipe(equipe);
                           return nova;
               case 'C' :  nova = criaCelulaCabo(COR_JOGADOR);
                           nova.setEquipe(equipe);
                           return nova;
               case 'S' :  nova = criaCelulaSoldado(COR_JOGADOR);
                           nova.setEquipe(equipe);
                           return nova;
               case 'E' :  nova = criaCelulaEspiao(COR_JOGADOR);
                           nova.setEquipe(equipe);
                           return nova;
               case 'F' :  nova = criaCelulaBandeira(COR_JOGADOR);
                           nova.setEquipe(equipe);
                           return nova;
               case 'M' :  nova = criaCelulaMarechal(COR_JOGADOR);
                           nova.setEquipe(equipe);
                           return nova;
            }
            
        }else if(equipe == -1 && tipo != ' ')
        {
            switch(tipo)
            {
               case 'B' :  nova = criaCelulaBomba(COR_ADVERSARIO);
                           nova.setEquipe(equipe);
                           return nova;
               case 'C' :  nova = criaCelulaCabo(COR_ADVERSARIO);
                           nova.setEquipe(equipe);
                           return nova;
               case 'S' :  nova = criaCelulaSoldado(COR_ADVERSARIO);
                           nova.setEquipe(equipe);
                           return nova;
               case 'E' :  nova = criaCelulaEspiao(COR_ADVERSARIO);
                           nova.setEquipe(equipe);
                           return nova;
               case 'F' :  nova = criaCelulaBandeira(COR_ADVERSARIO);
                           nova.setEquipe(equipe);
                           return nova;
               case 'M' :  nova = criaCelulaMarechal(COR_ADVERSARIO);
                           nova.setEquipe(equipe);
                           return nova;
            }
        }
        else
        {
            nova = criaCelulaVazio();
            return nova;
        }
        
        return null;
    }
    
    private static Celula criaCelulaVazio()
    {
        Celula celula = new Celula(' ',new Vazio(),equipe);
        celula.setBackground(COR_VAZIO);
        celula.setEquipe(0);
        return celula;
    }
    
    private static Celula criaCelulaBomba(Color cor)
    {
        Celula celula = new Celula('B', new Bomba(),equipe);
        celula.setBackground(cor);
        return celula;
    }
    
    private static Celula criaCelulaCabo(Color cor)
    {
        Celula celula = new Celula('C', new CaboArmeiro(),equipe);
        celula.setBackground(cor);
        return celula; 
    }
    
    private static Celula criaCelulaEspiao(Color cor)
    {
        Celula celula = new Celula('E', new Espiao(),equipe);
        celula.setBackground(cor);
        return celula; 
    }
    
    private static Celula criaCelulaMarechal(Color cor)
    {
        Celula celula = new Celula('M', new Marechal(),equipe);
        celula.setBackground(cor);
        return celula; 
    }
    
    private static Celula criaCelulaBandeira(Color cor)
    {
        Celula celula = new Celula('F', new Bandeira(),equipe);
        celula.setBackground(cor);
        return celula; 
    }
    
    private static Celula criaCelulaSoldado(Color cor)
    {
        Celula celula = new Celula('S', new Soldado(),equipe);
        celula.setBackground(cor);
        return celula; 
    }   
    
}
