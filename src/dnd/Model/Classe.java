package dnd.Model;

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
}
