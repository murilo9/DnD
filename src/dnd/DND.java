package dnd;

import dnd.View.JanelaPrincipal;
import javax.swing.UIManager;

public class DND {
    public static Partida partida;
    public static JanelaPrincipal janelaPrincipal;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        novaPartida();
        try {       //Seta o Look and Feel
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch(Exception e){}
        janelaPrincipal = new JanelaPrincipal();    //Instancia a janela principal
        /*OBS: Todos os frames dão um setVisible(true) através do seu próprio contrutor*/
    }
    
    /**
     * Cria nova partida em base de dados padrão
     */
    public static void novaPartida(){
        partida = new Partida();
        BdDefaultInstancer.createDefaultDB();   //Cria base de dados default
    }
    
    /**
     * Cria nova partida em base de dados personalizada
     * @param basedados 
     */
    public static void novaPartida(Basedados basedados){
        partida = new Partida(basedados);
    }
}
