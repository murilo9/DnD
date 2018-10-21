package dnd.Model;

import dnd.Model.Itens.Item;
import javax.swing.DefaultListModel;

/**
 *
 * @author Murilo
 */
public class Jogador extends Personagem{
    public String descricao;
    public DefaultListModel classes;
    public DefaultListModel pericias;
    public Align align;
    int level, xp, xpNext;
    double carga, cargaMax;
    public DefaultListModel inventario;
    public Item cabeca, torso, mao1, mao2, botas, acessorio1, acessorio2;
    
    public Jogador(String INnome, Raca INraca, DefaultListModel INpericias,
            int INstr, int INcon, int INdex, int INitl, int INwis, int INcha,
            String INdescri, String INgenero, EnumClasse INclasse, Align INalign){       //Construtor da classe
        //Faz as atribuições da superclasse:
        super(INnome, INraca, INpericias, INstr, INcon, INdex, INitl, INwis, INcha);
        //Faz as demais atribuições (descrição, classe, alinhamento, pericias):
        this.descricao = INdescri;
        this.classes = new DefaultListModel();
        this.classes.addElement(new Classe(INclasse, 1));    //Adiciona a primeira classe com nível 1
        this.align = INalign;
        //determina os demais membros da instância:
        this.level = 1;
        this.xp = 0;
        this.xpNext = 300;
        this.carga = 0;
        this.cargaMax = this.str*7.5;
        this.inventario = new DefaultListModel();   //Instancia uma ListModel vazia
        this.hp = getClasse(0).hitDiceSize;
    }
    
    public boolean equip(){
        //TODO
        return false;
    }
    
    public boolean unequip(){
        //TODO
        return false;
    }
    
    @Override
    public int getHpMax(){
        int conMod = Personagem.getMod(this.con);
        int hitDices = 0;
        int classesNumber = classes.getSize();
        for(int i=0;i<classesNumber;i++){
            //Adiciona a hitDices o tamanho do dado desta classe vezes o nível dela:
            hitDices += (getClasse(i).hitDiceSize)*(getClasse(i).level);
        }
        return hitDices + conMod*level;     //HP max = dados de vida por level de classe + (level * mod. de constituição)
    }
    
    @Override
    public boolean tryAtack(Personagem alvo){
        //TODO
        return false;
    }
    
    @Override
    public String toString(){
        return this.nome + " (" + this.hp + "/" + this.getHpMax() + " HP)";
    }
    
    /**
     * Retorna a classe número index da lista de classes deste jogador
     * @param index
     * @return 
     */
    public Classe getClasse(int index){
        return (Classe)this.classes.get(index);
    }
}
