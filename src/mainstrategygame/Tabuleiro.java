/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainstrategygame;

import java.awt.Color;
import java.awt.GridBagLayout;
import static java.lang.Math.sqrt;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author jvlai
 */
public class Tabuleiro extends JPanel implements Cloneable{
      
    public static final int NUMERO_DE_CASAS = 25;
    
    private Celula ultimoBotaoClicado = null;
    
    private Celula celulaOrigem = CelulaFactory.factory(' ');
    private Celula novaOrigem = CelulaFactory.factory(' ');
    private Celula celulaDestino = CelulaFactory.factory(' ');
    private Celula novoDestino = CelulaFactory.factory(' ');
    
    private int coordenadaXUltimoBotao;
    private int coordenadaYUltimoBotao;
    private Celula[][] tabuleiro;
    private Celula[][] copiaTabuleiro = new Celula[(int) sqrt(NUMERO_DE_CASAS)][(int) sqrt(NUMERO_DE_CASAS)];
    
    private int dicasDisponiveis = 2;
    
    private Celula celulaSelecionada;
    
    private int resultadoCombate;
    
    private GridBagConstraints  g = new GridBagConstraints();
       
    public Tabuleiro()
    {
        tabuleiro = new Celula[(int)(sqrt(NUMERO_DE_CASAS))][(int)(sqrt(NUMERO_DE_CASAS))];
        setLayout(new GridBagLayout());
        constroiTabuleiro();
    }
         
    private void constroiTabuleiro()
    {
        g.insets = new java.awt.Insets(1, 1, 1, 1);
        Random rand = new Random();
        int posLago = rand.nextInt(5);
        
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
                //Ao clicar no botão pega as "informações do botão" e chama a função que coloca uma peça na posição desse botão
                
                if((i == posLago && j == 2))
                {
                    tabuleiro[posLago][j].setBackground(new java.awt.Color(204, 204, 255));
                    tabuleiro[posLago][j].setLago();
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
        constroiTabuleiro();
    }
    
    public void colocaPeçaNoTabuleiro(Celula botaoClicado, int x, int y)
    {
        Celula novaCelula = CelulaFactory.factory(celulaSelecionada.getPeca().getTipo(),1);

            tabuleiro[x][y] = novaCelula;
            tabuleiro[x][y].setCoord(x,y);

            g.insets = new java.awt.Insets(1, 1, 1, 1); 
            g.gridx = x;
            g.gridy = y;

            remove(botaoClicado);
            add(novaCelula, g);
            revalidate();
            repaint();
    }

    public void limpaPeca(Celula ultimoBotaoClicado)
    {
        ultimoBotaoClicado.setIcon(null);
        ultimoBotaoClicado.setText(null);
        Color cor = new Color(204,255,204);
        ultimoBotaoClicado.setBackground(cor);
    }
    
    public void movePeca(Celula botaoClicado, int x, int y, Celula origem, int coordenadaXOrigem, int coordenadaYOrigem)
    {
        
        this.celulaOrigem = origem;
        this.celulaDestino = botaoClicado;

        Celula destino = botaoClicado;
        int coordenadaXDestino = x;
        int coordenadaYDestino = y;
        
        this.resultadoCombate = combate(botaoClicado, origem);
       // System.out.println(resultadoCombate);
        
        if (this.resultadoCombate == -1){
            botaoClicado.revelaCelula();
            
            Celula novaOrigem = CelulaFactory.factory(' ');
            
            this.novaOrigem = novaOrigem;
            //adicionarListener(novaOrigem);
            g.gridx = coordenadaXOrigem;
            g.gridy = coordenadaYOrigem;
            remove(tabuleiro[coordenadaXOrigem][coordenadaYOrigem]);
            tabuleiro[coordenadaXOrigem][coordenadaYOrigem] = novaOrigem;
            tabuleiro[coordenadaXOrigem][coordenadaYOrigem].setCoord(coordenadaXOrigem,coordenadaYOrigem);

            add(tabuleiro[coordenadaXOrigem][coordenadaYOrigem],g);
            
            resetaUltimoBotaoClicado();
            revalidate();
            repaint();
        }
        
        else if (this.resultadoCombate == 0)
        {
            
            Celula novaOrigem = CelulaFactory.factory(' ');
            
            this.novaOrigem = novaOrigem;
            
            //adicionarListener(novaOrigem);
            g.gridx = coordenadaXOrigem ;
            g.gridy = coordenadaYOrigem ;
            remove(tabuleiro[coordenadaXOrigem][coordenadaYOrigem]);
            tabuleiro[coordenadaXOrigem][coordenadaYOrigem] = novaOrigem;
            tabuleiro[coordenadaXOrigem][coordenadaYOrigem].setCoord(coordenadaXOrigem,coordenadaYOrigem);
            add(tabuleiro[coordenadaXOrigem][coordenadaYOrigem],g);
            
            Celula novoDestino = CelulaFactory.factory(' ');
            this.novoDestino = novoDestino;
            
            //adicionarListener(novoDestino);
                        
            g.gridx = coordenadaXDestino;
            g.gridy = coordenadaYDestino;
            remove(tabuleiro[coordenadaXDestino][coordenadaYDestino]);
            tabuleiro[coordenadaXDestino][coordenadaYDestino] = novoDestino;
            tabuleiro[coordenadaXDestino][coordenadaYDestino].setCoord(coordenadaXDestino,coordenadaYDestino);
            add(tabuleiro[coordenadaXDestino][coordenadaYDestino], g);
            
            resetaUltimoBotaoClicado();
            revalidate();
            repaint();
        }
        else if (this.resultadoCombate == 1)
        {
            Celula novaOrigem = CelulaFactory.factory(' ');
            this.novaOrigem = novaOrigem;
            
            
            //adicionarListener(novaOrigem);
            
            g.gridx = coordenadaXOrigem;
            g.gridy = coordenadaYOrigem;
            remove(tabuleiro[coordenadaXOrigem][coordenadaYOrigem]);
            tabuleiro[coordenadaXOrigem][coordenadaYOrigem] = novaOrigem;
            tabuleiro[coordenadaXOrigem][coordenadaYOrigem].setCoord(coordenadaXOrigem,coordenadaYOrigem);
            add(tabuleiro[coordenadaXOrigem][coordenadaYOrigem],g);
            
            g.gridx = coordenadaXDestino;
            g.gridy = coordenadaYDestino;
            remove(tabuleiro[coordenadaXDestino][coordenadaYDestino]);
            tabuleiro[coordenadaXDestino][coordenadaYDestino] = origem;
            tabuleiro[coordenadaXDestino][coordenadaYDestino].setCoord(coordenadaXDestino,coordenadaYDestino);
            add(tabuleiro[coordenadaXDestino][coordenadaYDestino], g);
            
            
            resetaUltimoBotaoClicado();
            revalidate();
            repaint();
        }
        
        else if (this.resultadoCombate == 2)
        {
            Celula novaOrigem = CelulaFactory.factory(' ');
            
            this.novaOrigem = novaOrigem;
   
            //adicionarListener(novaOrigem);
            
            g.gridx = coordenadaXDestino;
            g.gridy = coordenadaYDestino;
            remove(tabuleiro[coordenadaXDestino][coordenadaYDestino]);
            tabuleiro[coordenadaXDestino][coordenadaYDestino] = origem;
            tabuleiro[coordenadaXDestino][coordenadaYDestino].setCoord(coordenadaXDestino,coordenadaYDestino);
            add(tabuleiro[coordenadaXDestino][coordenadaYDestino], g);
            
            g.gridx = coordenadaXOrigem;
            g.gridy = coordenadaYOrigem;
            tabuleiro[coordenadaXOrigem][coordenadaYOrigem] = destino;
            tabuleiro[coordenadaXOrigem][coordenadaYOrigem].setCoord(coordenadaXOrigem,coordenadaYOrigem);
            add(tabuleiro[coordenadaXOrigem][coordenadaYOrigem], g);
            
            resetaUltimoBotaoClicado();
            revalidate();
            repaint();
        }
        else if (this.resultadoCombate == 3)
        {
           // vitoriaDoJogador();
            
           Celula novaOrigem = CelulaFactory.factory(' ');
           this.novaOrigem = novaOrigem;
            
            //adicionarListener(novaOrigem);
            g.gridx = coordenadaXOrigem;
            g.gridy = coordenadaYOrigem;
            remove(tabuleiro[coordenadaXOrigem][coordenadaYOrigem]);
            tabuleiro[coordenadaXOrigem][coordenadaYOrigem] = novaOrigem;
            tabuleiro[coordenadaXOrigem][coordenadaYOrigem].setCoord(coordenadaXOrigem,coordenadaYOrigem);
            add(tabuleiro[coordenadaXOrigem][coordenadaYOrigem],g);
            
            Celula novoDestino = CelulaFactory.factory(' ');
            this.novoDestino = novoDestino;
            
            //adicionarListener(novoDestino); 
            g.gridx = coordenadaXDestino;
            g.gridy = coordenadaYDestino;
            remove(tabuleiro[coordenadaXDestino][coordenadaYDestino]);
            tabuleiro[coordenadaXDestino][coordenadaYDestino] = origem;
            tabuleiro[coordenadaXDestino][coordenadaYDestino].setCoord(coordenadaXDestino,coordenadaYDestino);
            add(tabuleiro[coordenadaXDestino][coordenadaYDestino], g);
            
            resetaUltimoBotaoClicado();
            revalidate();
            repaint();
        }
    }
    
    public boolean verifica(Celula botao)
    {
        if (!(botao.getPeca() instanceof Vazio))
            return true;
        
        return false;
    }
    
    public boolean validaMovimento(Celula botaoClicado, int x, int y)
    {
        if (calculaDistancia(botaoClicado)){
            if(botaoClicado.getEquipe() == ultimoBotaoClicado.getEquipe())
            {
                verifica(botaoClicado);
            }
            if(botaoClicado.eLago == true)
            {
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
        else
        {
            return false;
        }
        return true;
    }
    
    public int combate(Celula botaoClicado, Celula recebePeca)
    {
        
        Peça pecaSelecionada = recebePeca.getPeca();
        Peça pecaInimiga = botaoClicado.getPeca();
        
        if (pecaInimiga.getTipo() == 'F')
        {
            ((Bandeira)pecaInimiga).setBandeiraCapturada(true);
            return 3;
        }
        
        switch (pecaSelecionada.getTipo())
        {
            case 'S' -> 
            {
                if      (pecaInimiga instanceof Espiao)     { resultadoCombate = 1; }
                else if (pecaInimiga instanceof Soldado)    { resultadoCombate = 0; }
                else if (pecaInimiga instanceof Vazio)      { resultadoCombate = 2; }
                else                                        { resultadoCombate = -1;}
            }
                
            case 'C' -> 
            {
                if      (pecaInimiga instanceof CaboArmeiro){ resultadoCombate = 0; }
                else if (pecaInimiga instanceof Marechal)   { resultadoCombate = -1;}
                else if (pecaInimiga instanceof Vazio)      { resultadoCombate = 2; }
                else                                        { resultadoCombate = 1; }
            }
                
            case 'E' -> 
            {
                if      (pecaInimiga instanceof Marechal)   { resultadoCombate = 1; }
                else if (pecaInimiga instanceof Espiao)     { resultadoCombate = 0; }
                else if (pecaInimiga instanceof Vazio)      { resultadoCombate = 2; }
                else                                        { resultadoCombate = -1;}
            }
            case 'M' -> 
            {
                if      (pecaInimiga instanceof Bomba || pecaInimiga instanceof Espiao)      { resultadoCombate = -1;}
                else if (pecaInimiga instanceof Marechal)   { resultadoCombate = 0; }
                else if (pecaInimiga instanceof Vazio)      { resultadoCombate = 2; }
                else                                        { resultadoCombate = 1; }
            }
        }  
        return getResultadoCombate();
    }
    
    public void resetaUltimoBotaoClicado()
    {
        this.ultimoBotaoClicado = null;
    }
    
    public void atualizaTabuleiro() 
    {
        for (int i = 0; i < sqrt(NUMERO_DE_CASAS); i++) 
        {
            for (int j = 0; j < sqrt(NUMERO_DE_CASAS); j++) 
            {
                if (celulaSelecionada != null) 
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

    public void setPecasAleatorias(int time)
    {
        
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
                    tabuleiro[i][j] = getPecaAleatoria(bombas,soldados,cabos,marechal,espiao,time);
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
   
    }

    private static Celula getPecaAleatoria(int bombas, int soldados, int cabos, boolean marechal, boolean espiao, int equipe)
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

        return celula;
        
    }
    
    public void debugBoard()
    {
        for(int i = 0; i < sqrt(NUMERO_DE_CASAS); i++)
        {
            for(int j = 0; j < sqrt(NUMERO_DE_CASAS); j++)
            {
                tabuleiro[i][j].revelaCelula();
            }
        }
    }
    
    public static void clearConsole() 
    {
        for (int i = 0; i < 10; i++) {
            System.out.println();
    }
}
    
    public void imprimeMatriz()
    {
        clearConsole();
        for(int i = 0; i < sqrt(NUMERO_DE_CASAS); i++)
        {
            for(int j = 0; j < sqrt(NUMERO_DE_CASAS); j++)
            {
                System.out.printf("[%d][%d] = %s  ",j,i,tabuleiro[j][i].getPeca().getNome());
            }
            System.out.println("\n");
        }
        clearConsole();
    }
    
    public boolean calculaDistancia(Celula botaoClicado)
    {
        int coordenadaXUltimoBotaoClicado = this.coordenadaXUltimoBotao;
        int coordenadaYUltimoBotaoClicado = this.coordenadaYUltimoBotao;
        int coordenadaXBotaoClicado = botaoClicado.getPosX();
        int coordenadaYBotaoClicado = botaoClicado.getPosY();
        int coordenadaXFinal;
        int coordenadaYFinal;
        boolean resultadoCalculoDistancia = false;
        int coordenadaXTemp = coordenadaXUltimoBotaoClicado;
        int coordenadaYTemp = coordenadaYUltimoBotaoClicado;
        coordenadaXFinal = Math.abs(coordenadaXUltimoBotaoClicado - coordenadaXBotaoClicado);
        coordenadaYFinal = Math.abs(coordenadaYUltimoBotaoClicado - coordenadaYBotaoClicado);
        resultadoCalculoDistancia = (coordenadaXFinal == 1 && coordenadaYFinal == 0) || (coordenadaXFinal == 0 && coordenadaYFinal == 1);
        
        if(ultimoBotaoClicado.getPeca() instanceof Soldado)
        {
            if (coordenadaXUltimoBotaoClicado == coordenadaXBotaoClicado || coordenadaYUltimoBotaoClicado == coordenadaYBotaoClicado )
            {
                int incrementoX = 0;
                int incrementoY = 0;
                int x;
                int y;
                int distanciaClicadaX = Math.abs(coordenadaXUltimoBotaoClicado - coordenadaXBotaoClicado);
                int distanciaClicadaY = Math.abs(coordenadaYUltimoBotaoClicado - coordenadaYBotaoClicado);
                if (coordenadaXUltimoBotaoClicado > coordenadaXBotaoClicado)
                {
                    incrementoX = -1;
                }
                if (coordenadaXUltimoBotaoClicado < coordenadaXBotaoClicado)
                {
                    incrementoX = 1;
                }
                if (coordenadaYUltimoBotaoClicado > coordenadaYBotaoClicado)
                {
                    incrementoY = -1;
                }
                if (coordenadaYUltimoBotaoClicado < coordenadaYBotaoClicado)
                {
                    incrementoY = 1;
                }
                
                x = coordenadaXUltimoBotaoClicado + incrementoX;
                y = coordenadaYUltimoBotaoClicado + incrementoY;
                while (x != coordenadaXBotaoClicado || y != coordenadaYBotaoClicado) 
                {
                    if (!(tabuleiro[x][y].getPeca() instanceof Vazio) || (tabuleiro[x][y].getLago() == true) ) 
                    {
                        return false;
                    }
                    x += incrementoX;
                    y += incrementoY;
                }
                if(!(botaoClicado.getPeca() instanceof Vazio) && !resultadoCalculoDistancia)
                {
                    return false;
                } 
                else 
                {
                    return true;
                }
                
            }
        }
        return resultadoCalculoDistancia;
    }
    
    public void adicionarListener(Celula celula)
    {
        
        celula.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) 
            {
                Celula botaoClicado = (Celula) e.getSource();
                System.out.println("botaoClicado:"+botaoClicado.getPosX()+" "+botaoClicado.getPosY());
                if ( ultimoBotaoClicado != null && validaMovimento(botaoClicado,botaoClicado.getPosX(),botaoClicado.getPosY()))
                {
                    movePeca(botaoClicado, botaoClicado.getPosX(), botaoClicado.getPosY(),getUltimoBotaoClicado(), getCoordenadasUltimoBotao('x'),getCoordenadasUltimoBotao('y'));
                    //resetaUltimoBotaoClicado();
                    //System.out.println(botaoClicado.getPeca());
                    movePecaAdversaria();
                } 
            }
        });
    }
    
    public void dicaBomba()
    {
        imprimeMatriz();
        if(dicasDisponiveis > 0)
        {
            Scanner scannerDica = new Scanner(System.in);
            String colunaString= JOptionPane.showInputDialog("Digite a coluna da matriz [0] até [4]:");
            if (colunaString != null)
            {
                int coluna = Integer.parseInt(colunaString);
                for (int i = 0; i < 5; i++){
                    if (tabuleiro[coluna][i].getPeca() instanceof Bomba){
                        tabuleiro[coluna][i].revelaCelula();
                    }
                }
            }
            dicasDisponiveis--;
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Sem dicas disponiveis...");
        }
    }
    
    public void copiaTabuleiro()
    {
        g.insets = new java.awt.Insets(1, 1, 1, 1);
        for (int i = 0; i < sqrt(NUMERO_DE_CASAS); i++)
        {
            for (int j = 0; j < sqrt(NUMERO_DE_CASAS); j++)
            {

                Celula copiaCelula = CelulaFactory.factory(tabuleiro[i][j].getPeca().getTipo(), tabuleiro[i][j].getEquipe());
                adicionarListener(copiaCelula);
                copiaTabuleiro[i][j] = copiaCelula;
                copiaTabuleiro[i][j].setCoord(i,j);
                if (tabuleiro[i][j].getLago() == true)
                {
                    copiaTabuleiro[i][j].setLago();
                    copiaTabuleiro[i][j].setBackground(new java.awt.Color(204, 204, 255));
                }
            }
        }
        for(int i = 0; i < sqrt(NUMERO_DE_CASAS); i++)
        {
            for(int j = 0; j < sqrt(NUMERO_DE_CASAS); j++)
            {
                System.out.printf("[%d][%d] = %s  ",j,i,copiaTabuleiro[j][i].getPeca().getNome());
            }
            System.out.println("\n");
        }
    }
    
    public void trocaTabuleiro()
    {
        g.insets = new java.awt.Insets(1, 1, 1, 1);
        for (int i = 0; i < sqrt(NUMERO_DE_CASAS); i++){
            for (int j = 0; j < sqrt(NUMERO_DE_CASAS); j++){
                g.gridx = i;
                g.gridy = j;
                remove(tabuleiro[i][j]);
                tabuleiro[i][j] = copiaTabuleiro[i][j];
                add(tabuleiro[i][j], g);
            }
        }

        repaint();
        revalidate();
    }
    
    public void movePecaAdversaria()
    {
        Random rand = new Random();
        int listaMovimento[] = new int[3];
        listaMovimento[0] = -1; listaMovimento[1] = 1; listaMovimento[2] = 0;
        int index = rand.nextInt(3);
        int index2 = rand.nextInt(3);
        int x = rand.nextInt(5);
        int y = rand.nextInt(5);
        int proxX;
        int proxY;
        do
        {
            x = rand.nextInt(5);
            y = rand.nextInt(5);
            while(tabuleiro[x][y].getEquipe() != -1 || tabuleiro[x][y].getPeca().getTipo() == 'B' || tabuleiro[x][y].getPeca().getTipo() == 'F')
            {   
                x = rand.nextInt(5);
                y = rand.nextInt(5);
                //System.out.print(". ");
            }

            index = rand.nextInt(3);
            index2 = rand.nextInt(3);

            while( (!(0 < x+listaMovimento[index] && x+listaMovimento[index] < 5) ||  
                   !( 0 < y+listaMovimento[index2] && y+listaMovimento[index2]< 5 )) ||
                    (x == x+listaMovimento[index] && y == y+listaMovimento[index2])
                )
            {
                index = rand.nextInt(3);
                index2 = rand.nextInt(3);  
                //System.out.print("* ");
            }

            proxX = x+listaMovimento[index];
            proxY = y+listaMovimento[index2];

            if(x != x+listaMovimento[index] && y != y+listaMovimento[index2])
            {
                Random temp = new Random();
                int temp2 = rand.nextInt(2);
                if(temp2 == 1)
                {
                    proxX = x;
                }
                if(temp2 == 0)
                {
                    proxY = y;
                }
            }
                  
                
        }while(tabuleiro[proxX][proxY].getEquipe() == -1 || tabuleiro[proxX][proxY].getLago() == true); 
        movePeca(tabuleiro[proxX][proxY], proxX, proxY, tabuleiro[x][y], x, y);
    }
    
    public Celula getCelulaNovoDestino()
    {
        return this.novoDestino;
    }
    
    public Celula getCelulaNovaOrigem()
    {
        return this.novaOrigem;
    }
    
     public Celula getCelulaDestino()
    {
        return this.celulaDestino;
    }
     
    public Celula getCelulaOrigem()
    {
        return this.celulaOrigem;
    }
    
    public int getResultadoCombate()
    {
        return this.resultadoCombate;
    }
      
    public Celula getUltimoBotaoClicado() 
    {
        return this.ultimoBotaoClicado;
    }
    
    public void setUltimoBotaoClicado(Celula botao)
    {
        this.ultimoBotaoClicado = botao;
    }
    
    public int getCoordenadasUltimoBotao(char xy)
    {
        if(xy == 'x')
            return this.coordenadaXUltimoBotao;
        else
            return this.coordenadaYUltimoBotao;
    }
    
    public Celula getCelula(int x,int y)
    {
        return tabuleiro[x][y];
    }
        
    public void setCoordenadasUltimoBotao(int x, int y)
    {
        this.coordenadaXUltimoBotao = x;
        this.coordenadaYUltimoBotao = y;
    }
    
    public void setCelulaSelecionada(Celula celulaSelecionada)
    {
        this.celulaSelecionada = celulaSelecionada; 
    }
    
    public Celula getCelulaSelecionada()
    {
        return celulaSelecionada;
    }
    
    public int getDicasDisponiveis() 
    {
        return dicasDisponiveis;
    }
    
    public void setDicasDisponiveis()
    {
        this.dicasDisponiveis = 2;
    }
}
