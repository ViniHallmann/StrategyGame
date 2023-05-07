/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import java.awt.Color;
import static java.awt.Color.GREEN;
import java.awt.GridBagLayout;
import static java.lang.Math.sqrt;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
    
    private Color corAdversario = new Color(255,204,204);
    private Color corJogador = new Color(175,175,255);
    
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
                tabuleiro[i][j] = CelulaFactory.factory(' ',0);
                tabuleiro[i][j].setCoord(i,j);
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
                else
                {
                    tabuleiro[i][j].addMouseListener(new MouseAdapter(){
                            @Override
                            public void mouseClicked(MouseEvent e) {
                            if(peçaSelecionada != null)
                            {    
                                Celula botaoClicado = (Celula) e.getSource();
                                colocaPeçaNoTabuleiro(botaoClicado, x, y);
                                revalidate();
                                repaint();

                                setPeçaSelecionada(null);
                            }
                        }
                    });
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
                        Celula novaCelula = CelulaFactory.factory(getTipoDePeça(),1);
                        
                        if (verificaPeçasDisponiveis(getTipoDePeça()))
                        {
                            iteradorPeçasDisponiveis(getTipoDePeça());
                            if ( getTipoDePeça() == 'F' && y == 3) // A bandeira só pode ficar na ultima linha da matriz!!
                            {
                                return;
                            }
                            tabuleiro[i][j] = novaCelula;
                            
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
        Peça pecaOrigem = origem.getPeca();

        Celula destino = botaoClicado;
        int coordenadaXDestino = x;
        int coordenadaYDestino = y;
        
        origem = ultimoBotaoClicado;
        //SWAP
        //tabuleiro[coordenadaXDestino][coordenadaYDestino] = destino;
        //g.insets = new java.awt.Insets(1, 1, 1, 1); 
        g.gridx = coordenadaXDestino;
        g.gridy = coordenadaYDestino;
        remove(tabuleiro[coordenadaXDestino][coordenadaYDestino]);
        remove(tabuleiro[coordenadaXOrigem][coordenadaYOrigem]);
        tabuleiro[coordenadaXDestino][coordenadaYDestino] = origem;
        tabuleiro[coordenadaXDestino][coordenadaYDestino].setCoord(coordenadaXDestino,coordenadaYDestino);
        add(tabuleiro[coordenadaXDestino][coordenadaYDestino], g);
        
       
      
        g.gridx = coordenadaXOrigem;
        g.gridy = coordenadaYOrigem;
        tabuleiro[coordenadaXOrigem][coordenadaYOrigem] = destino;
        tabuleiro[coordenadaXOrigem][coordenadaYOrigem].setCoord(coordenadaXOrigem,coordenadaYOrigem);
        add(tabuleiro[coordenadaXOrigem][coordenadaYOrigem], g);
        ultimoBotaoClicado = null;
        revalidate();
        repaint(); 
    }
    public boolean verifica(Celula botao)
    {
        if (!(botao.getPeca() instanceof Vazio))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean validaMovimento(Celula botaoClicado, int x, int y)
    {
        if (verifica (botaoClicado)){
            /*if (ultimoBotaoClicado.getPeca() instanceof Vazio)
            {
                return false;
            }*/
            if(botaoClicado.getEquipe() == ultimoBotaoClicado.getEquipe())
            {
                verifica(botaoClicado);
            }
            if((x == 1 && y == 2)||(x == 3 && y == 2))
            {
                resetaUltimoBotaoClicado();
                return false;
            }
            if ( ultimoBotaoClicado.getPeca() instanceof Bomba    ||
                 ultimoBotaoClicado.getPeca() instanceof Bandeira || 
                 ultimoBotaoClicado.getPeca() instanceof Vazio)
            {
                resetaUltimoBotaoClicado();
                if(!(botaoClicado.getPeca() instanceof Vazio))
                {
                    verifica(botaoClicado);
                }
                else 
                {
                    System.out.println("Movimento inválido. Bomba/Bandeira não se mexem!!");
                    return false;
                }
            }
        }
        return true;
    }
    
    public void resetaUltimoBotaoClicado(){
        this.ultimoBotaoClicado = null;
    }
    
    /*public void selecionaPeca(){
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
                            coordenadaXUltimoBotao = x;
                            coordenadaYUltimoBotao = y;
                            System.out.println(ultimoBotaoClicado.getPeca());
                            if (ultimoBotaoClicado.getPeca() instanceof Vazio)
                                ultimoBotaoClicado = null;
                        }
                        
                        else if (validaMovimento(botaoClicado,x,y))
                        {
                            
                            movePeca(botaoClicado, x, y);
                            resetaUltimoBotaoClicado();
                            System.out.println(botaoClicado.getPeca());
                        } 
                    }
                });
            }
        }
    }*/
    public String imprimePeca(){
        if (ultimoBotaoClicado == null) 
        {
            return "Nenhuma peça selecionada ainda";
        } else 
        {
            String nomePeca = ultimoBotaoClicado.getPeca().getNome();
            return nomePeca;
        }
    }
    
    public void mudaRodada(){
        for (int i = 0; i < sqrt(NUMERO_DE_CASAS); i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                tabuleiro[i][j].setEnabled(true);
                        final int x = i;
                        final int y = j;
                        tabuleiro[i][j].addMouseListener(new MouseAdapter() 
                        {
                            public void mouseClicked(MouseEvent e) 
                            {
                                Celula botaoClicado = (Celula) e.getSource();
                                if ( ultimoBotaoClicado!= null && validaMovimento(botaoClicado,x,y))
                                {
                                    movePeca(botaoClicado, botaoClicado.getPosX(), botaoClicado.getPosY());
                                    resetaUltimoBotaoClicado();
                                    //System.out.println(botaoClicado.getPeca());
                                } 
                            }
                        });
            }
        }
        
        for (int i = 0; i < 5; i++)
        {
            for (int j = 3; j < 5; j++)
            {
                tabuleiro[i][j].setEnabled(true);
                final int x = i;
                final int y = j;
                tabuleiro[i][j].addMouseListener(new MouseAdapter() 
                {
                    @Override
                    public void mouseClicked(MouseEvent e) 
                    {   
                        Celula botaoClicado = (Celula) e.getSource();
                        if (ultimoBotaoClicado == null)
                        {
                            ultimoBotaoClicado = botaoClicado;
                            System.out.println(ultimoBotaoClicado.getPeca());
                            
                            coordenadaXUltimoBotao = botaoClicado.getPosX();
                            coordenadaYUltimoBotao = botaoClicado.getPosY();
                            
                            System.out.println(botaoClicado.getPosX() +" "+ botaoClicado.getPosY());
                        }
                       
                    }
                });   
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

    public void setPecasAleatorias(int time){
        Random rand = new Random();
        int gerado = rand.nextInt(5);
        int ladoFlag;
        int lado;
        int ate;
        if(time == 1)
        {
            ladoFlag = 4;
            lado = 3;
            ate = 5;
        }
        else
        {
            ladoFlag = 0;
            lado = 0;
            ate = 2;
        }
        remove(tabuleiro[gerado][ladoFlag]);
        tabuleiro[gerado][ladoFlag] = CelulaFactory.factory('F',time);
        tabuleiro[gerado][ladoFlag].setCoord(gerado, ladoFlag);
        tabuleiro[gerado][ladoFlag].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                   
                   
            }
        });
                
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
                    tabuleiro[i][j] = setPecaAleatoria(bombas,soldados,cabos,marechal,espiao,time);
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
                    tabuleiro[i][j].setCoord(i,j);
                    add(tabuleiro[i][j], g);
                    atualizaTabuleiro();
                }
            }
        }
        if(time == 1)
        {
            this.bombasDisponiveis = bombas;
            this.soldadosDisponiveis = soldados;
            this.caboArmeiroDisponiveis = cabos;
            this.marechalDisponivel = marechal;
            this.espiaoDisponivel = espiao;
        }
            
    }

    private static Celula setPecaAleatoria(int bombas, int soldados, int cabos, boolean marechal, boolean espiao, int equipe)
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
        celula = CelulaFactory.factory(escolhido,equipe);
        
        //System.out.println(celula.getTipo());

        return celula;
        
    }
    
    public void debugBoard()
    {
        for(int i = 0; i < sqrt(NUMERO_DE_CASAS); i++)
        {
            for(int j = 0; j < sqrt(NUMERO_DE_CASAS); j++)
            {
                tabuleiro[i][j].debugCelula();
            }
        }
    }
    public static void clearConsole() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
    }
}
    
    public void imprimeMatriz()
    {
        clearConsole();
        for(int j = 0; j < sqrt(NUMERO_DE_CASAS); j++)
        {
            for(int i = 0; i < sqrt(NUMERO_DE_CASAS); i++)
            {
                System.out.printf("[%d][%d] = %s",j,i,tabuleiro[i][j].getPeca().getNome());
            }
            System.out.println("\n");
        }
        clearConsole();
    }

}

    
