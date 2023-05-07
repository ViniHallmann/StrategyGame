/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import javax.swing.JLabel;

/**
 *
 * @author vinic
 */
public abstract class Peça extends JLabel{
    private String nome;
    private char tipo;   
    private int nivel;
    public Peça() {
        //setText(nome);
    }
    
    public void setTipo(char tipo)
    {
        this.tipo = tipo;
    }
    public char getTipo()
    {
        return tipo;
    }
   // public void setCoord(int x ,int y)
   // {
   //     this.posX = x;
   //     this.posY = y;
   // }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
}
