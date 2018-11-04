package dnd.Model.Itens;

import dnd.Model.Itens.Item;

/**
 *
 * @author Murilo
 */
public class Elmo extends Item{
    int defesa;
    
    public Elmo(String INnome, String INdescricao, double INpeso, int INqtd,
                int INvalor, boolean INequipavel, int INdefesa){
        super(INnome, INdescricao, INpeso, INqtd, INvalor, INequipavel);
        this.defesa = INdefesa;
    }
}
