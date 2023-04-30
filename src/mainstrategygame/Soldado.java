/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

/**
 *
 * @author vinic
 */
public class Soldado extends Peça {
    private final boolean podeCorrer = true;
    private boolean correuNessaRodada;
    private boolean peçaEscondida;
    
    public Soldado (String nomeDaPeça, int nivelDaPeça, int[]posição ){
        super(nomeDaPeça, nivelDaPeça, posição);
        this.peçaEscondida = true;
        this.correuNessaRodada = false;
    }
    public boolean isPodeCorrer() {
        return podeCorrer;
    }
    public boolean isPodeAtacar() {
        if ( correuNessaRodada == false)
            return true;
        else
            return false;
    }
}
