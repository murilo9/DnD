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
    
    public Item(String INnome, String INdescricao, double INpeso, int INqtd,
                int INvalor, boolean INequipavel){      //Construtor
        this.nome = INnome;
        this.descricao = INdescricao;
        this.peso = INpeso;
        this.qtd = INqtd;
        this.valor = INvalor;
        this.equipavel = INequipavel;
    }
    
    public double getPeso(){
        return (this.peso*this.qtd);
    }
    
    public int getQtd(){
        return this.qtd;
    }
    
    public boolean setQtd(int valor){
        if(this.qtd + valor < 0)
            return false;
        else{
            this.qtd += valor;
            return true;
        }
    }
    
    @Override
    public String toString(){
        if(this.qtd > 1)
            return this.nome;
        else
            return this.nome + "(x" + this.qtd + ")";
    }
}
