/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainstrategygame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author vinic
 */
public class MainStrategyGame{
    public static void main(String[] args) {
       
       BoardSub board = new BoardSub();
       Menu menu = new Menu();
       //TelaBoasVindas tela = new TelaBoasVindas();
       menu.setVisible(true);
       
       
       menu.getBotao().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    menu.setVisible(false);
                    //tela.setVisible(true);
                    board.setVisible(true);
            } 
        });
        /*tela.getBotaoContinuar().addMouseListener(new MouseAdapter() { 
                @Override
                public void mouseClicked(MouseEvent e) {
                    tela.setVisible(false);
                    board.setVisible(true);
            } 
        });*/
       
    }
}
