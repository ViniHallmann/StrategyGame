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
    
    public static Celula criaCelulaVazio()
    {
        Celula celula = new Celula(' ',new Vazio());
        celula.setBackground(new Color(255, 255, 255));
        return celula;
    }
    public static Celula criaCelulaBomba()
    {
        Celula celula = new Celula('B', new Bomba());
        celula.setBackground(new Color(255, 255, 255));
        return celula;
    }
    public static Celula criaCelulaCabo()
    {
        Celula celula = new Celula('C', new CaboArmeiro());
        celula.setBackground(new Color(255, 255, 255));
        return celula; 
    }
    public static Celula criaCelulaEspiao()
    {
        Celula celula = new Celula('E', new Espiao());
        celula.setBackground(new Color(255, 255, 255));
        return celula; 
    }
    public static Celula criaCelulaMarechal()
    {
        Celula celula = new Celula('M', new Marechal());
        celula.setBackground(new Color(255, 255, 255));
        return celula; 
    }
    public static Celula criaCelulaBandeira()
    {
        Celula celula = new Celula('F', new Bandeira());
        celula.setBackground(new Color(255, 255, 255));
        return celula; 
    }
    public static Celula criaCelulaSoldado()
    {
        Celula celula = new Celula('S', new Soldado());
        celula.setBackground(new Color(255, 255, 255));
        return celula; 
    }
}
