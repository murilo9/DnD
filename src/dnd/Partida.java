package dnd;

import dnd.Model.*;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Murilo
 */
public class Partida {
    DefaultComboBoxModel jogadores;
    
    public Partida(){
        jogadores = new DefaultComboBoxModel();
    }
    
    public void addJogador(Jogador jogador){
        jogadores.addElement(jogador);
    }
    
    public DefaultComboBoxModel getListaJogadores(){
        return this.jogadores;
    }
}
