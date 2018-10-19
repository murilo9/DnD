package dnd.Model;

import java.util.Map;

public abstract class Personagem {
    public int str, con, dex, itl, wis, cha, level;
    public String nome;
    Raca raca;
    public Map<Pericia,Integer> pericias;   //Mapa de perícias (par perícia-valor), instanciado no construtor
    
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
    }
    
    /**
     * Retorna o dano potencial mínimo do personagem
     * @param per
     * @return 
     */
    public static int getDmgMin(Personagem per){
        //TODO
    }
    
    /**
     * Retorna o dano potencial máximo do personagem
     * @param per
     * @return 
     */
    public static int getDmgMax(Personagem per){
        //TODO
    }
    
    public abstract int getHpMax(Personagem per);
    
    public abstract boolean tryAtack(Personagem alvo);     //Método abstrato a ser implementado pelas sub-classes
}
