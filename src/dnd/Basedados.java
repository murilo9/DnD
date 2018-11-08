package dnd;

import dnd.Model.Itens.*;
import dnd.Model.Npc;
import javax.swing.DefaultListModel;

public class Basedados {
    public DefaultListModel itemList, npcList;
    
    public Basedados(){
        itemList = new DefaultListModel();
        npcList = new DefaultListModel();
    }
    
    public void addItem(Item item){
        itemList.addElement(item);
    }
    
    public void addNPC(Npc npc){
        itemList.addElement(npc);
    }
    
    public void removeItem(int index){
        itemList.remove(index);
    }
    
    public void removeNPC(int index){
        itemList.remove(index);
    }
}
