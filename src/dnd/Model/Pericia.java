package dnd.Model;

/**
 * Cada personagem (jogador ou NPC) possui uma lista (ListModel) de perícias,
 * representado por objetos da classe Pericia. Esta classe inidica o nome da
 * perícia e seu respectivo level.
 * @author Murilo
 */
public class Pericia {
    String nome;
    int level;
    
    public Pericia(String INnome, int INlevel){
        this.nome = INnome;
        this.level = INlevel;
    }
    @Override
    public String toString(){   //Retorna o nome da classe junto com o level
        return this.nome + " (" + Integer.toString(this.level) + ")";
    }
    
    public void levelUp(int qtd){
        this.level += qtd;
    }
}
