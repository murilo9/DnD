package dnd.Model;

public class Classe {
    EnumClasse tipo;
    int level;
    int hitDiceSize;
    
    public Classe(EnumClasse INtipo, int INlevel){
        this.tipo = INtipo;
        this.level = INlevel;
        switch(INtipo){
            case BARBARIAN:
                this.hitDiceSize = 12;
                break;
            case WARRIOR:
                this.hitDiceSize = 10;
                break;
            case RANGER:
                this.hitDiceSize = 8;
                break;
            case CLERIC:
                this.hitDiceSize = 8;
                break;
            case WIZARD:
                this.hitDiceSize = 6;
                break;
        }
    }
}
