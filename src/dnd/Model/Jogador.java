package dnd.Model;

import dnd.Model.Itens.Item;
import java.util.List;

/**
 *
 * @author Murilo
 */
public class Jogador {
    public String genero, descricao, align;
    int xp, xpNext;
    double carga, cargaMax;
    public List<Item> inventario;
    public Item cabeca, torso, mao1, mao2, botas, acessorio1, acessorio2;
    
    public boolean equip(){
        //TODO
        return false;
    }
    
    public boolean unequip(){
        //TODO
        return false;
    }
}
