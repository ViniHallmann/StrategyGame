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
    private boolean pecaEscondida = true;
    public Peça() {
        
    }
    
    public void setTipo(char tipo)
    {
        this.tipo = tipo;
    }
    
    public void setPecaRevelada()
    {
        this.pecaEscondida = false;
    }
    
    public boolean getPecaEscondida()
    {
        return this.pecaEscondida = false;
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
 