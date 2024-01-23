/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.OverlayLayout;

/**
 *
 * @author jvlai
 */
public class Celula extends JButton{
    
    private int posX;
    private int posY;
    private Peça peca;
    private int equipe;
    boolean eLago = false; 
    private JLabel labelImagemPeca;
    
    public Celula( char t , Peça peca, int equipe)
    {
        this.peca = peca;
        this.equipe = equipe;
        this.peca.setTipo(t);
    }

    public Celula()
    {
        setText(peca.getNome());
    }
    
    public void colocaImagemCelula(char tipo)
    {
        setPreferredSize(new java.awt.Dimension(150, 100));
        setLayout(new OverlayLayout(this));
        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Resources/tile2.png"));
        setIcon(backgroundImage);
        
        String stringEquipe = "aliado";
        if (getEquipe() == 1 )
        {
            ImageIcon imagemPecaIcon = null;
            switch (tipo) 
            {
             case 'B':
                 imagemPecaIcon = new ImageIcon(getClass().getResource("/Resources/bomba_" + stringEquipe + ".png"));
                 break;
             case 'C':
                 imagemPecaIcon = new ImageIcon(getClass().getResource("/Resources/cabo_" + stringEquipe + ".png"));
                 break;
             case 'S':
                 imagemPecaIcon = new ImageIcon(getClass().getResource("/Resources/soldado_" + stringEquipe + ".png"));
                 break;
             case 'E':
                 imagemPecaIcon = new ImageIcon(getClass().getResource("/Resources/espiao_" + stringEquipe + ".png"));
                 break;
             case 'F':
                 imagemPecaIcon = new ImageIcon(getClass().getResource("/Resources/bandeira_" + stringEquipe + ".png"));
                 break;
             case 'M':
                 imagemPecaIcon = new ImageIcon(getClass().getResource("/Resources/marechal_" + stringEquipe + ".png"));
                 break;
            }
            setIcon(backgroundImage);
            Image imagemPeca = imagemPecaIcon.getImage();
            Image imagemPecaRedimensionada = imagemPeca.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon imagemPecaRedimensionadaIcon = new ImageIcon(imagemPecaRedimensionada);

            labelImagemPeca = new JLabel(imagemPecaRedimensionadaIcon);
            labelImagemPeca.setAlignmentX(CENTER_ALIGNMENT);
            labelImagemPeca.setAlignmentY(CENTER_ALIGNMENT);
            add(labelImagemPeca);
        }
        else
        {
            stringEquipe = "inimigo";
        }
        
        if (tipo != ' ')
        {
            ImageIcon imagemPecaIcon = new ImageIcon(getClass().getResource("/Resources/peca_" + stringEquipe + ".png"));
            setIcon(backgroundImage);
            Image imagemPeca = imagemPecaIcon.getImage();
            Image imagemPecaRedimensionada = imagemPeca.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon imagemPecaRedimensionadaIcon = new ImageIcon(imagemPecaRedimensionada);

            labelImagemPeca = new JLabel(imagemPecaRedimensionadaIcon);
            labelImagemPeca.setAlignmentX(CENTER_ALIGNMENT);
            labelImagemPeca.setAlignmentY(CENTER_ALIGNMENT);
            add(labelImagemPeca); 
        }
        
    }
    public void colocaImagemLago()
    {
        if(getLago() == true)
        {
            ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/Resources/tile3.jpg"));
            Image image = backgroundImage.getImage();
            Image resizedImage = image.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
            ImageIcon resizedBackgroundImage = new ImageIcon(resizedImage);
            setIcon(resizedBackgroundImage);
        }
    }
    public void revelaCelula(char tipo)
    {
        if (labelImagemPeca != null) 
        {
            remove(labelImagemPeca);
            labelImagemPeca = null;
        }
        if (equipe == -1)
        {
            ImageIcon imagemPecaIcon = null;
            switch (tipo) 
            {
             case 'B':
                 imagemPecaIcon = new ImageIcon(getClass().getResource("/Resources/bomba_inimigo.png"));
                 break;
             case 'C':
                 imagemPecaIcon = new ImageIcon(getClass().getResource("/Resources/cabo_inimigo.png"));
                 break;
             case 'S':
                 imagemPecaIcon = new ImageIcon(getClass().getResource("/Resources/soldado_inimigo.png"));
                 break;
             case 'E':
                 imagemPecaIcon = new ImageIcon(getClass().getResource("/Resources/espiao_inimigo.png"));
                 break;
             case 'F':
                 imagemPecaIcon = new ImageIcon(getClass().getResource("/Resources/bandeira_inimigo.png"));
                 break;
             case 'M':
                 imagemPecaIcon = new ImageIcon(getClass().getResource("/Resources/marechal_inimigo.png"));
                 break;
            } 

            if (imagemPecaIcon != null)
            {
                Image imagemPeca = imagemPecaIcon.getImage();
                Image imagemPecaRedimensionada = imagemPeca.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                ImageIcon imagemPecaRedimensionadaIcon = new ImageIcon(imagemPecaRedimensionada);

                labelImagemPeca = new JLabel(imagemPecaRedimensionadaIcon);
                labelImagemPeca.setAlignmentX(CENTER_ALIGNMENT);
                labelImagemPeca.setAlignmentY(CENTER_ALIGNMENT);
                add(labelImagemPeca);
            }
        }
        repaint();
    }
    
    public void setLago()
    {
        this.eLago = true;
    }
    
    public boolean getLago()
    {
        return this.eLago;
    }
    
    public void setPeça(Peça peça)
    {
        this.peca = peça;
    }
    
    public Peça getPeca()
    {
        return this.peca;
    }
    
    public void setEquipe(int equipe)
    {
        this.equipe = equipe;
    }
    
    public int getEquipe()
    {
        return this.equipe;
    }
    
    public void setCoord(int posx, int posy)
    {
        this.posX = posx;
        this.posY = posy;
    }
    
    public int getPosX()
    {
        return this.posX;
    }
    
    public int getPosY()
    {
        return this.posY;
    }
    
}
