/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import java.awt.Color;
import static java.awt.Color.GREEN;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.sqrt;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jvlai
 */
public class Tabuleiro extends JPanel{
    
    public static final int NUMERO_DE_CASAS = 25;
    
    private Celula ultimoBotaoClicado = null;
    private int coordenadaXUltimoBotao;
    private int coordenadaYUltimoBotao;
    private Celula[][] tabuleiro;
    private int rodada = 1;
    
    private Peça peçaSelecionada;
    private String nomeDaPeça;
    private char tipoDePeça;
    
    private boolean bandeiraDisponivel = true;
    private boolean marechalDisponivel = true;
    private boolean espiaoDisponivel = true;
    private int soldadosDisponiveis = 3;
    private int caboArmeiroDisponiveis = 2;
    private int bombasDisponiveis = 2;
    
    GridBagConstraints  g = new GridBagConstraints();
       
    public Tabuleiro()
    {
        tabuleiro = new Celula[(int)(sqrt(NUMERO_DE_CASAS))][(int)(sqrt(NUMERO_DE_CASAS))];
        setLayout(new GridBagLayout());
        constroiTabuleiro();
    }
    
    public void atualizaPeçasDisponiveis(){
        int numerosCabosArmeiros = getCaboArmeiroDisponiveis();
        int numerosBombas = getBombasDisponiveis();
        int numerosSoldados = getSoldadosDisponiveis();
    }
    public void setPeçaSelecionada(Peça peçaSelecionada) {
        this.peçaSelecionada = peçaSelecionada;
        atualizaTabuleiro();
    }
    
    public void setTipoDePeça(char tipoDePeça){
        this.tipoDePeça = tipoDePeça;
    }
    
    public void setNomeDaPeça(String nomeDaPeça){
        this.nomeDaPeça = nomeDaPeça;
    }
    
    public Peça getPeçaSelecionada() {
        return peçaSelecionada;
    }

    public String getNomeDaPeça() {
        return nomeDaPeça;
    }

    public char getTipoDePeça() {
        return tipoDePeça;
    }
    
    public int getRodada(){
        return rodada;
    }
    public int getSoldadosDisponiveis() {
        return soldadosDisponiveis;
    }
    
    public int getCaboArmeiroDisponiveis() {
        return caboArmeiroDisponiveis;
    }
    
    public int getBombasDisponiveis() {
        return bombasDisponiveis;
    }
    
    public boolean isBandeiraDisponivel() {
        return bandeiraDisponivel;
    }

    public boolean isMarechalDisponivel() {
        return marechalDisponivel;
    }

    public boolean isEspiaoDisponivel() {
        return espiaoDisponivel;
    }
                    
    private void constroiTabuleiro()
    {
        g.insets = new java.awt.Insets(1, 1, 1, 1);
        for(int i = 0 ; i < sqrt(NUMERO_DE_CASAS); i++)
        {
            for(int j = 0; j < sqrt(NUMERO_DE_CASAS); j++)
            {
                g.gridx=i;
                g.gridy=j;
                //Cria o tabuleiro
                tabuleiro[i][j] = CelulaFactory.factory(' ');
                tabuleiro[i][j].setBackground(new java.awt.Color(204, 255, 204));
                tabuleiro[i][j].setPreferredSize(new java.awt.Dimension(50, 50));
                
                //Seta o tabuleiro como falso
                tabuleiro[i][j].setEnabled(false);
                //Pega as coordenadas da matriz
                final int x = i;
                final int y = j;
                //Ao clicar no botão pega as "informações do botão" e chama a função que coloca uma peça na posição desse botão
                tabuleiro[i][j].addActionListener(new ActionListener() 
                    {
                        public void actionPerformed(ActionEvent e) 
                        {   
                            Celula botãoClicado = (Celula) e.getSource();
                            colocaPeçaNoTabuleiro(botãoClicado, x, y);
                        }
                    });

                if((i == 1 && j == 2)||(i == 3 && j == 2))
                {
                    tabuleiro[i][j].setEnabled(false);
                    tabuleiro[i][j].setBackground(new java.awt.Color(204, 204, 255));
                }
                
                add(tabuleiro[i][j],g);
            }
        }
    }
    
    public void resetaTabuleiro()
    {
        for(int i = 0; i < sqrt(NUMERO_DE_CASAS); i++)
        {
            for(int j = 0; j < sqrt(NUMERO_DE_CASAS); j++)
            {
                remove(tabuleiro[i][j]);
            }
        }
        
        this.bandeiraDisponivel = true;
        this.marechalDisponivel = true;
        this.espiaoDisponivel = true;
        this.soldadosDisponiveis = 3;
        this.caboArmeiroDisponiveis = 2;
        this.bombasDisponiveis = 2;
        
        constroiTabuleiro();
        
    }
    
    public void iteradorPeçasDisponiveis(char tipoDePeça)
    {
        switch(tipoDePeça){
            case 'B':
                bombasDisponiveis--;
                return;
            case 'C':
                caboArmeiroDisponiveis--;
                return;
            case 'S':
                soldadosDisponiveis--;
                return;
            case 'M':
                marechalDisponivel = false;
                return;
            case 'E':
                espiaoDisponivel = false;
                return;
            case 'F':
                bandeiraDisponivel = false;
                return;
        }
    }
    
    public boolean verificaPeçasDisponiveis(char tipoDePeça){
        switch(tipoDePeça){
            case 'B':
                return (bombasDisponiveis > 0);
            case 'C':
                return (getCaboArmeiroDisponiveis() > 0);
            case 'S':
                return (getSoldadosDisponiveis() > 0);
            case 'M':
                return isMarechalDisponivel();
            case 'E':
                return isEspiaoDisponivel();
            case 'F':
                return isBandeiraDisponivel();
            default:
                return false;
        }
    }
    
    public void colocaPeçaNoTabuleiro(Celula botãoClicado, int x, int y)
    {
        for (int i = 0; i < sqrt(NUMERO_DE_CASAS); i++) 
        {
            for (int j = 3; j < sqrt(NUMERO_DE_CASAS); j++) 
            {
                if (x == i && y == j)
                {
                    if (j > 2)
                    {
                        Celula novaCelula = CelulaFactory.factory(getTipoDePeça());
                        
                        if (verificaPeçasDisponiveis(getTipoDePeça()))
                        {
                            iteradorPeçasDisponiveis(getTipoDePeça());
                            if ( getTipoDePeça() == 'F' && y == 3) // A bandeira só pode ficar na ultima linha da matriz!!
                            {
                                return;
                            }
                            rodada++;
                            tabuleiro[i][j] = novaCelula;
                            novaCelula.setBackground(new java.awt.Color(175, 175, 255));
                            novaCelula.setPreferredSize(new java.awt.Dimension(50, 50));
                            g.insets = new java.awt.Insets(1, 1, 1, 1); 
                            g.gridx = x;
                            g.gridy = y;
                        
                            remove(botãoClicado);
                            add(novaCelula, g);
                            revalidate();
                            repaint();

                            setPeçaSelecionada(null);
                        }
                        else
                        {
                            System.out.println("Peça indisponivel...");
                        }
                    }
                }
            }
        }
    }
    
    public void limpaPeca(Celula ultimoBotaoClicado){
        ultimoBotaoClicado.setIcon(null);
        ultimoBotaoClicado.setText(null);
        Color cor = new Color(204,255,204);
        ultimoBotaoClicado.setBackground(cor);
    }
    
    public void movePeca(Celula botaoClicado, int x, int y)
    {
        Celula origem = ultimoBotaoClicado;
        int coordenadaXOrigem = coordenadaXUltimoBotao;
        int coordenadaYOrigem = coordenadaYUltimoBotao;
        
        Celula destino = botaoClicado;
        int coordenadaXDestino = x;
        int coordenadaYDestino = y;
        
        
        Peça pecaOrigem = origem.getPeca();
        
        //Celula novoDestino = CelulaFactory.factory(pecaOrigem.getTipo());
        
        for (int i = 0; i < sqrt(NUMERO_DE_CASAS); i++) 
        {
            for (int j = 0; j < sqrt(NUMERO_DE_CASAS); j++) 
            {
                Celula novoDestino = CelulaFactory.factory(pecaOrigem.getTipo());
                novoDestino.setBackground(new java.awt.Color(175, 175, 255));
                novoDestino.setPreferredSize(new java.awt.Dimension(50, 50));
                g.insets = new java.awt.Insets(1, 1, 1, 1); 
                g.gridx = coordenadaXDestino;
                g.gridy = coordenadaYDestino;

                remove(botaoClicado);
                add(novoDestino, g);
                Celula novaOrigem = CelulaFactory.factory(' ');
                novaOrigem.setPeça(pecaOrigem);
                novaOrigem.setBackground(new java.awt.Color(204, 255, 204));
                novaOrigem.setPreferredSize(new java.awt.Dimension(50, 50));
                g.insets = new java.awt.Insets(1, 1, 1, 1);
                g.gridx = coordenadaXOrigem;
                g.gridy = coordenadaYOrigem;
                remove(ultimoBotaoClicado);
                add(novaOrigem, g);
                revalidate();
                repaint();
            }
        }
        /*
        destino.setBorder(origem.getBorder());
        destino.setMargin(origem.getMargin());
        destino.setIcon(origem.getIcon());
        destino.setText(origem.getText());
        destino.setFont(origem.getFont());
        destino.setBackground(origem.getBackground());
        destino.setForeground(origem.getForeground());*/
    }
    
    public void selecionaPeca(){
        for (int i = 0; i < sqrt(NUMERO_DE_CASAS); i++) 
        {
            for (int j = 0; j < sqrt(NUMERO_DE_CASAS); j++) 
            {
                final int x = i;
                final int y = j;
                tabuleiro[i][j].addMouseListener(new MouseAdapter() 
                {
                    public void mouseClicked(MouseEvent e) 
                    {   
                        Celula botaoClicado = (Celula) e.getSource();
                        if (ultimoBotaoClicado == null)
                        {
                            ultimoBotaoClicado = botaoClicado;
                            System.out.println(ultimoBotaoClicado.getText());
                            coordenadaXUltimoBotao = x;
                            coordenadaYUltimoBotao = y;
                        }
                        else 
                        {
                            movePeca(botaoClicado, x, y);
                            limpaPeca(ultimoBotaoClicado);
                            ultimoBotaoClicado = null;
                        }

                    }
                });
            }
        }
    }
    
    public void mudaRodada(){
        for (int i = 0; i < sqrt(NUMERO_DE_CASAS); i++) 
        {
            for (int j = 0; j < sqrt(NUMERO_DE_CASAS); j++) 
            {
                tabuleiro[i][j].setEnabled(true);
            }
        }
    }
    private void atualizaTabuleiro() {
        for (int i = 0; i < sqrt(NUMERO_DE_CASAS); i++) 
        {
            for (int j = 0; j < sqrt(NUMERO_DE_CASAS); j++) 
            {
                if (peçaSelecionada != null) 
                {
                    tabuleiro[i][j].setEnabled(true);
                }
                else
                {
                    tabuleiro[i][j].setEnabled(false);
                }
            }
        }
    }

    public void setPecasAleatorias(boolean time){
        Random rand = new Random();
        int gerado = rand.nextInt(5);
        int ladoFlag;
        int lado;
        int ate;
        Color cor;
        if(time)
        {
            cor = new Color(175,175,255);
            ladoFlag = 4;
            lado = 3;
            ate = 5;
        }
        else
        {
            cor = new Color(255,204,204);
            ladoFlag = 0;
            lado = 0;
            ate = 2;
        }
        remove(tabuleiro[gerado][ladoFlag]);
        tabuleiro[gerado][ladoFlag] = CelulaFactory.factory('F');
        tabuleiro[gerado][ladoFlag].setBackground(cor);
        tabuleiro[gerado][ladoFlag].setPreferredSize(new java.awt.Dimension(50, 50));
                
        g.insets = new java.awt.Insets(1, 1, 1, 1); 
        g.gridx = gerado; g.gridy = ladoFlag;
        add(tabuleiro[gerado][ladoFlag], g);
        atualizaTabuleiro();
        
        
        boolean marechal = true;
        boolean espiao = true;
        int bombas = 2;
        int soldados = 3;
        int cabos = 2;
        
        for(int i = 0; i < 5; i++)
        {            
            for(int j = lado; j < ate; j++)
            {
                if((j != ladoFlag) || (i != gerado))
                {
                    remove(tabuleiro[i][j]);
                    tabuleiro[i][j] = setPecaAleatoria(bombas,soldados,cabos,marechal,espiao);
                    if(tabuleiro[i][j].getPeca().getTipo() == 'B')
                        bombas--;
                    if(tabuleiro[i][j].getPeca().getTipo() == 'S')
                        soldados--;
                    if(tabuleiro[i][j].getPeca().getTipo() == 'C')
                        cabos--;
                    if(tabuleiro[i][j].getPeca().getTipo() == 'M')
                        marechal = false;
                    if(tabuleiro[i][j].getPeca().getTipo() == 'E')
                        espiao = false;
                    
                    g.insets = new java.awt.Insets(1, 1, 1, 1); 
                    g.gridx = i;
                    g.gridy = j;
                    tabuleiro[i][j].setBackground(cor);
                    add(tabuleiro[i][j], g);
                    atualizaTabuleiro();
                }
            }
        }
        if(time)
        {
            this.bombasDisponiveis = bombas;
            this.soldadosDisponiveis = soldados;
            this.caboArmeiroDisponiveis = cabos;
            this.marechalDisponivel = marechal;
            this.espiaoDisponivel = espiao;
        }
            
    }

    private static Celula setPecaAleatoria(int bombas, int soldados, int cabos, boolean marechal, boolean espiao )
    {
        
        List<Character> tipos = new ArrayList<>();
        if(bombas > 0)
            tipos.add('B');
        if(soldados > 0)
            tipos.add('S');
        if(cabos > 0)
            tipos.add('C');
        if(marechal)
            tipos.add('M');
        if(espiao)
            tipos.add('E');
        Celula celula;
        Random random = new Random();
        
        char escolhido = tipos.get(random.nextInt(tipos.size()));
        celula = CelulaFactory.factory(escolhido);
        
        
        celula.setPreferredSize(new java.awt.Dimension(50, 50));
        //System.out.println(celula.getTipo());

        return celula;
        
    }
}

    
