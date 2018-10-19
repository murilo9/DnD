package dnd.Model.Itens;

/**
 *
 * @author Murilo
 */
public class Item {
    public String nome, descricao;
    double peso;
    public int qtd, valor;
    boolean equipavel;
    
    public Item(){      //Construtor
        
    }
    
    public double getPeso(){
        return (this.peso*this.qtd);
    }
}
