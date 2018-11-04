package dnd;

import dnd.Model.Itens.*;
import static dnd.Model.Itens.EquipTipo.*;
import dnd.Model.Npc;

public abstract class BdDefaultInstancer {
    static Npc npc;
    static Item item;
    
    /**
     * Esta função insere todos os itens e NPCs padrão na base de dados da partida
     */
    public static void createDefaultDB(){
        //--------------- Itens ---------------
        //Armas:
        DND.partida.basedados.addItem(new Arma("Adaga","", 0.5, 1, 200, true, SIMPLE_WEAPON, 1, 4));
        DND.partida.basedados.addItem(new Arma("Maça","", 1, 1, 500, true, SIMPLE_WEAPON, 1, 6));
        DND.partida.basedados.addItem(new Arma("Lança","", 1.5, 1, 100, true, SIMPLE_WEAPON_2H, 1, 8));
        DND.partida.basedados.addItem(new Arma("Arco Curto","", 1, 1, 2500, true, SIMPLE_AMMO, 1, 6));
        DND.partida.basedados.addItem(new Arma("Funda","", 0.1, 1, 10, true, SIMPLE_AMMO, 1, 4));
        DND.partida.basedados.addItem(new Arma("Dardo","", 0.1, 20, 100, true, SIMPLE_THROW, 1, 6));
        DND.partida.basedados.addItem(new Arma("Espada Curta","", 1, 1, 1000, true, MARTIAL_WEAPON, 1, 6));
        DND.partida.basedados.addItem(new Arma("Espada Longa","", 1.5, 1, 5000, true, MARTIAL_WEAPON, 1, 8));
        DND.partida.basedados.addItem(new Arma("Alabarda","", 2, 1, 2000, true, MARTIAL_WEAPON_2H, 1, 10));
        DND.partida.basedados.addItem(new Arma("Machado de Guerra","", 4, 1, 3000, true, MARTIAL_WEAPON_2H, 1, 12));
        DND.partida.basedados.addItem(new Arma("Machado","", 1, 1, 1000, true, MARTIAL_WEAPON, 1, 8));
        DND.partida.basedados.addItem(new Arma("Arco Longo","", 1.5, 1, 5000, true, MARTIAL_AMMO, 1, 8));
        DND.partida.basedados.addItem(new Arma("Balestra","", 3, 1, 5000, true, MARTIAL_AMMO, 1, 8));
        //Worn:
        DND.partida.basedados.addItem(new Armadura("Armadura de Couro","", 5, 1, 1000, true, LIGHT_ARMOR, 1));
        DND.partida.basedados.addItem(new Armadura("Armadura de Couro Batido","", 6.5, 1, 4500, true, LIGHT_ARMOR, 2));
        DND.partida.basedados.addItem(new Armadura("Camisão de Argolas","", 10, 1, 5000, true, MEDIUM_ARMOR, 3));
        DND.partida.basedados.addItem(new Armadura("Cota de Escamas","", 12, 1, 1000, true, MEDIUM_ARMOR, 4));
        DND.partida.basedados.addItem(new Armadura("Cota de Placas","", 20, 1, 12000, true, HEAVY_ARMOR, 5));
        DND.partida.basedados.addItem(new Escudo("Escudo de Madeira","", 3, 1, 1000, true, 1));
        DND.partida.basedados.addItem(new Escudo("Escudo Torre","", 7, 1, 5000, true, 2));
        DND.partida.basedados.addItem(new Elmo("Elmo","", 4, 1, 1000, true, 1));
        //Misc:
        DND.partida.basedados.addItem(new Item("Algemas","", 2, 1, 200, false));
        DND.partida.basedados.addItem(new Item("Ampulheta","", 0.5, 1, 2500, false));
        DND.partida.basedados.addItem(new Item("Apito","", 0.5, 1, 2500, false));
        DND.partida.basedados.addItem(new Item("Balde","", 1, 1, 5, false));
        DND.partida.basedados.addItem(new Item("Caixa de Fogo","", 0.5, 1, 50, false));
        DND.partida.basedados.addItem(new Item("Canenca","", 0.5, 1, 2, false));
        DND.partida.basedados.addItem(new Item("Cantil","", 2.5, 1, 20, false));
        DND.partida.basedados.addItem(new Item("Cobertor","", 1.5, 1, 50, false));
        DND.partida.basedados.addItem(new Item("Corda","", 5, 1, 100, false));
        DND.partida.basedados.addItem(new Item("Corrente","", 5, 1, 500, false));
        DND.partida.basedados.addItem(new Item("Frasco","", 1, 1, 2, false));
        DND.partida.basedados.addItem(new Item("Garrafa de Vidro","", 1, 1, 200, false));
        DND.partida.basedados.addItem(new Item("Giz","", 0, 1, 1, false));
        DND.partida.basedados.addItem(new Item("Jarra","", 2, 1, 4, false));
        DND.partida.basedados.addItem(new Item("Lente de Aumento","", 0, 1, 10000, false));
        DND.partida.basedados.addItem(new Item("Luneta","", 0.5, 1, 100000, false));
        DND.partida.basedados.addItem(new Item("Marreta","", 5, 1, 200, false));
        DND.partida.basedados.addItem(new Item("Martelo","", 1.5, 1, 100, false));
        DND.partida.basedados.addItem(new Item("Flecha","", 0.25, 20, 100, false));
        DND.partida.basedados.addItem(new Item("Panela de Ferro","", 5, 1, 200, false));
        DND.partida.basedados.addItem(new Item("Folha de Papel","", 0, 1, 5, false));
        DND.partida.basedados.addItem(new Item("Pé de Cabra","", 2.5, 1, 200, false));
        DND.partida.basedados.addItem(new Item("Pergaminho","", 0, 1, 20, false));
        DND.partida.basedados.addItem(new Item("Picareta","", 5, 1, 20, false));
        DND.partida.basedados.addItem(new Item("Prego de Ferro","", 2.5, 10, 100, false));
        DND.partida.basedados.addItem(new Item("Rações de Viagem","", 1, 1, 50, false));
        DND.partida.basedados.addItem(new Item("Sabão","", 0, 1, 2, false));
        DND.partida.basedados.addItem(new Item("Saco","", 0.25, 1, 1, false));
        DND.partida.basedados.addItem(new Item("Saco de Dormir","", 3.5, 1, 100, false));
        DND.partida.basedados.addItem(new Item("Tenda para Dois","", 10, 1, 200, false));
        DND.partida.basedados.addItem(new Item("Tocha","", 0.5, 1, 1, false));
        DND.partida.basedados.addItem(new Item("Frasco de Tinta","", 0, 1, 1000, false));
        DND.partida.basedados.addItem(new Item("Vara","", 3.5, 1, 5, false));
        DND.partida.basedados.addItem(new Item("Vela","", 0, 1, 1, false));
        DND.partida.basedados.addItem(new Item("Seta de Balestra","", 1.5, 20, 150, false));
        //--------------- NPCs ---------------
        //TODO
        
        //--------------- Feitiços ---------------
        //TODO
    }
}
