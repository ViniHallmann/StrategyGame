/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainstrategygame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author vinic
 */
public class MainStrategyGame{
    public static void main(String[] args) {
       
       BoardSub board = new BoardSub();
       Menu menu = new Menu();
       menu.setVisible(true);
       
       menu.getBotao().addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    menu.setVisible(false);
                    board.setVisible(true);
            }
        });
       
    }
}
