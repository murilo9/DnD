package dnd;

import dnd.Model.*;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Murilo
 */
public class Partida {
    public DefaultComboBoxModel jogadores;
    
    public Partida(){
        jogadores = new DefaultComboBoxModel();
    }
    
    public void addJogador(Jogador jogador){
        jogadores.addElement(jogador);
    }
    
    public void removeJogador(int index){
            jogadores.removeElementAt(index);
    }
    
    public DefaultComboBoxModel getListaJogadores(){
        return this.jogadores;
    }
}
