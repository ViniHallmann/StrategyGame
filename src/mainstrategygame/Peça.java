/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

/**
 *
 * @author vinic
 */
public abstract class Peça{
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
 