package dnd.Model;

import java.util.Map;
import javax.swing.DefaultListModel;

public abstract class Personagem {
    public int str, con, dex, itl, wis, cha, hp;
    public String nome;
    Raca raca;
    public DefaultListModel pericias;   //Mapa de perícias (par perícia-valor), instanciado no construtor
    
    /**
     * Este construtor não faz tratamento de dados!
     * @param INnome
     * @param INraca
     * @param INpericias
     * @param INstr
     * @param INcon
     * @param INdex
     * @param INitl
     * @param INwis
     * @param INcha
     */
    public Personagem(String INnome, Raca INraca, DefaultListModel INpericias,
            int INstr, int INcon, int INdex, int INitl, int INwis, int INcha){    //Construtor da classe
        this.nome = INnome;
        this.raca = INraca;
        this.str = INstr;
        this.con = INcon;
        this.dex = INdex;
        this.itl = INitl;
        this.wis = INwis;
        this.cha = INcha;
        this.pericias = new DefaultListModel();
        this.pericias = INpericias;
    }
    
    /**
     * Retorna o modificador de um atributo.
     * @param atributo O atributo que se deseja obter o modificador
     * @return O modificador do atributo
     */
    public static int getMod(int atributo){
        return (int)Math.floor((atributo - 10)/2);
    }
    
    public static Personagem testResist(Personagem per1, Personagem per2){
        //TODO
        return null;
    }
    
    /**
     * Retorna o dano potencial mínimo do personagem
     * @param per
     * @return 
     */
    public static int getDmgMin(Personagem per){
        //TODO
        return 0;
    }
    
    /**
     * Retorna o dano potencial máximo do personagem
     * @param per
     * @return 
     */
    public static int getDmgMax(Personagem per){
        //TODO
        return 0;
    }
    
    public abstract int getHpMax();
    
    public abstract boolean tryAtack(Personagem alvo);     //Método abstrato a ser implementado pelas sub-classes
}
