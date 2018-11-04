package dnd.Model.Itens;

import dnd.Model.Itens.Item;

/**
 *
 * @author Murilo
 */
public class Armadura extends Item{
    EquipTipo tipo;
    int defesa;
    
    public Armadura(String INnome, String INdescricao, double INpeso, int INqtd,
                int INvalor, boolean INequipavel, EquipTipo INtipo, int INdefesa){
        super(INnome, INdescricao, INpeso, INqtd, INvalor, INequipavel);
        this.tipo = INtipo;
        this.defesa = INdefesa;
    }
}
