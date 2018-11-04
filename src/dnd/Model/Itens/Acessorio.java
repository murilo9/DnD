package dnd.Model.Itens;

import dnd.Model.Itens.Item;

/**
 *
 * @author Murilo
 */
public class Acessorio extends Item{
    
    public Acessorio(String INnome, String INdescricao, double INpeso, int INqtd,
                int INvalor, boolean INequipavel){
        super(INnome, INdescricao, INpeso, INqtd, INvalor, INequipavel);
    }
}
