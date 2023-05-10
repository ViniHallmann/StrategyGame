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

    public Peça() {
        
    }
    
    public void setTipo(char tipo)
    {
        this.tipo = tipo;
    }
    
    public char getTipo()
    {
        return tipo;
    }

    public String getNome() 
    {
        return nome;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
}
 