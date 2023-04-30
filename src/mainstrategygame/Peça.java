/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

/**
 *
 * @author vinic
 */
public class Peça {
    private String nomeDaPeça;
    private int nivelDaPeça;
    private int[] posiçãoDaPeça;
    
    public Peça(String nomeDaPeça, int nivelDaPeça, int[]posição) {
        this.nomeDaPeça = nomeDaPeça;
        this.nivelDaPeça = nivelDaPeça;
        this.posiçãoDaPeça = posição;
    }

    public String getNome() {
        return nomeDaPeça;
    }

    public int getNivel() {
        return nivelDaPeça;
    }

    public int[] getPosicao() {
        return posiçãoDaPeça;
    }
    
    public void setPosiçãoDaPeça(int[] posiçãoDaPeça) {
        this.posiçãoDaPeça = posiçãoDaPeça;
    }
}
