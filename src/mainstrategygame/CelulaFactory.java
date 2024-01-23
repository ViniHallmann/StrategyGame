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
    private static int equipe = 1;
    
    public static Celula factory(char tipo)
    {
       switch(tipo)
       {
           case ' ' : return criaCelulaVazio();
           case 'B' : return criaCelulaBomba();
           case 'C' : return criaCelulaCabo();
           case 'S' : return criaCelulaSoldado();
           case 'E' : return criaCelulaEspiao();
           case 'F' : return criaCelulaBandeira();
           case 'M' : return criaCelulaMarechal();
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
               case 'B' :  nova = criaCelulaBomba();
                           nova.setEquipe(equipe);
                           return nova;
               case 'C' :  nova = criaCelulaCabo();
                           nova.setEquipe(equipe);
                           return nova;
               case 'S' :  nova = criaCelulaSoldado();
                           nova.setEquipe(equipe);
                           return nova;
               case 'E' :  nova = criaCelulaEspiao();
                           nova.setEquipe(equipe);
                           return nova;
               case 'F' :  nova = criaCelulaBandeira();
                           nova.setEquipe(equipe);
                           return nova;
               case 'M' :  nova = criaCelulaMarechal();
                           nova.setEquipe(equipe);
                           return nova;
            }
            
        }else if(equipe == -1 && tipo != ' ')
        {
            switch(tipo)
            {
               case 'B' :  nova = criaCelulaBomba();
                           nova.setEquipe(equipe);
                           return nova;
               case 'C' :  nova = criaCelulaCabo();
                           nova.setEquipe(equipe);
                           return nova;
               case 'S' :  nova = criaCelulaSoldado();
                           nova.setEquipe(equipe);
                           return nova;
               case 'E' :  nova = criaCelulaEspiao();
                           nova.setEquipe(equipe);
                           return nova;
               case 'F' :  nova = criaCelulaBandeira();
                           nova.setEquipe(equipe);
                           return nova;
               case 'M' :  nova = criaCelulaMarechal();
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
        celula.setEquipe(0);
        celula.colocaImagemCelula(' ');
        return celula;
    }
    
    private static Celula criaCelulaBomba()
    {
        Celula celula = new Celula('B', new Bomba(),equipe);
        celula.colocaImagemCelula('B');
        return celula;
    }
    
    private static Celula criaCelulaCabo()
    {
        Celula celula = new Celula('C', new CaboArmeiro(),equipe);
        celula.colocaImagemCelula('C');
        return celula; 
    }
    
    private static Celula criaCelulaEspiao()
    {
        Celula celula = new Celula('E', new Espiao(),equipe);
        celula.colocaImagemCelula('E');
        return celula; 
    }
    
    private static Celula criaCelulaMarechal()
    {
        Celula celula = new Celula('M', new Marechal(),equipe);
        celula.colocaImagemCelula('M');
        return celula; 
    }
    
    private static Celula criaCelulaBandeira()
    {
        Celula celula = new Celula('F', new Bandeira(),equipe);
        celula.colocaImagemCelula('F');
        return celula; 
    }
    
    private static Celula criaCelulaSoldado()
    {
        Celula celula = new Celula('S', new Soldado(),equipe);
        celula.colocaImagemCelula('S');
        return celula; 
    }   
    
}
