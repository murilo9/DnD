package dnd;

import dnd.Model.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Murilo
 */
public class Partida {
    public DefaultComboBoxModel jogadores;
    public DefaultListModel npcs;
    
    public Partida(){
        jogadores = new DefaultComboBoxModel();
        npcs = new DefaultListModel();
    }
    
    public void addJogador(Jogador jogador){
        jogadores.addElement(jogador);
    }
    
    public void addNPC(Npc npc){
        npcs.addElement(npc);
    }
    
    public void removeJogador(int index){
        jogadores.removeElementAt(index);
    }
    
    public void removeNPC(int index){
        npcs.removeElementAt(index);
    }
    
    public DefaultComboBoxModel getListaJogadores(){
        return this.jogadores;
    }
    
    public DefaultListModel getListaNPCs(){
        return this.npcs;
    }
}
