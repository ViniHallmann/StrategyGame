/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

/**
 *
 * @author vinic
 */
public class Bomba extends Peça{
    private boolean peçaEscondida;
    private char tipo;
    private String nome = "💣";
    
    @Override
    public String getNome(){
        return nome;
    }
    public Bomba (){
        this.peçaEscondida = true;
        this.setText("💣");
    }
}
