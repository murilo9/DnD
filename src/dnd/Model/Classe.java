package dnd.Model;

/**
 * Cada jogador possui uma classe ou mais (no caso de multiclasse), onde cada uma
 * é representada por um objeto Classe, que indica o tipo, o nível da classe atual,
 * e o tamanho do dado de vida.
 * @author Murilo
 */
public class Classe {
    public EnumClasse tipo;
    public int level, hpDiceSize;
    
    public Classe(EnumClasse INtipo, int INlevel){
        this.tipo = INtipo;
        this.level = INlevel;
        switch(INtipo){
            case BARBARIAN:
                this.hpDiceSize = 12;
                break;
            case WARRIOR:
                this.hpDiceSize = 10;
                break;
            case RANGER:
                this.hpDiceSize = 8;
                break;
            case CLERIC:
                this.hpDiceSize = 8;
                break;
            case WIZARD:
                this.hpDiceSize = 6;
                break;
        }
    }
    
    /**
     * Aumenta o level desta classe em 1.
     */
    public void levelUp(){
        this.level++;
    }
}
