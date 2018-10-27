package dnd.Model;

import javax.swing.DefaultListModel;

public class Npc extends Personagem{
    public DefaultListModel pericias;
    int ac, hpMax;
    
    public Npc(String INnome, EnumRaca INraca, DefaultListModel INpericias, int INhp, 
            int INac, int INstr, int INcon, int INdex, int INitl, int INwis, int INcha){
        super(INnome, INraca, INstr, INcon, INdex, INitl, INwis, INcha);
        this.pericias = INpericias;
        this.hp = this.hpMax = INhp;
        this.ac = INac;
    }
    
    @Override
    public int getAC(){
        return this.ac;
    }
    
    @Override
    public int getHpMax(){
        return this.hpMax;
    }
    
    @Override
    public int dieRoll(){
        //TODO
        return 0;
    }
    
    @Override
    public String toString(){
        return this.nome + " (" + this.hp + "/" + this.getHpMax() + " HP)";
    }
}
