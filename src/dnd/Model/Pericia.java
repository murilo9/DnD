package dnd.Model;

/**
 *
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
}
