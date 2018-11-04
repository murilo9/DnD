package dnd;

import dnd.Model.Itens.*;
import dnd.Model.Npc;

public abstract class BdDefaultInstancer {
    static Npc npc;
    static Item item;
    
    /**
     * Esta função insere todos os itens e NPCs padrão na base de dados da partida
     */
    public static void createDefaultDB(){
        //--------------- Itens ---------------
        //TODO
        item = new Arma();
        //--------------- NPCs ---------------
        //TODO
        
        //TODO: feitiços
    }
}
