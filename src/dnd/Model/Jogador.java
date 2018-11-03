package dnd.Model;

import dnd.Model.Itens.Item;
import javax.swing.DefaultListModel;

/**
 *
 * @author Murilo
 */
public class Jogador extends Personagem{
    public String descricao, genero;
    public DefaultListModel classes, pericias;
    public Align align;
    int level, xp, xpNext;
    double carga, cargaMax;
    public DefaultListModel inventario;
    public Item cabeca, torso, mao1, mao2, botas, acessorio1, acessorio2;
    boolean morrendo;
    
    public Jogador(String INnome, EnumRaca INraca, DefaultListModel INpericias,
            int INstr, int INcon, int INdex, int INitl, int INwis, int INcha,
            String INdescri, String INgenero, EnumClasse INclasse, Align INalign){       //Construtor da classe
        //Faz as atribuições da superclasse:
        super(INnome, INraca, INstr, INcon, INdex, INitl, INwis, INcha);
        this.pericias = INpericias;
        //Faz as demais atribuições (descrição, classe, alinhamento, pericias):
        this.descricao = INdescri;
        this.genero = INgenero;
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
        this.hp = getClasse(0).hpDiceSize + Personagem.getMod(this.con);
        this.morrendo = false;
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
    public int dieRollBonus(){
        //TODO
        return 0;
    }
    
    @Override
    public int getHitDices(){
        return 1;
        //TODO armas
    }
    
    @Override
    public int getHitDicesSize(){
        return 2;
        //TODO armas
    }
    
    @Override
    public int getDamageBonus(){
        //TODO outros bônus
        return Personagem.getMod(str);
    }
    
    @Override
    public String getRacaString(){
        switch(this.raca){
            case HUMAN:
                if(this.genero == "Masculino")
                    return "Humano";
                else
                    return "Humana";
            case ELF:
                if(this.genero == "Masculino")
                    return "Elfo";
                else
                    return "Elfa";
            case DWARF:
                if(this.genero == "Masculino")
                    return "Anão";
                else
                    return "Anã";
            case HALFORC:
                return "Orc";
            default:
                return "null";
        }
    }
    
    public int getLevel(){
        return this.level;
    }
    
    public String getDmgPotString(){
        String minDmg = Integer.toString(this.getHitDices() + Personagem.getMod(this.str));     //Hit dices + mod. força
        String maxDmg = Integer.toString((this.getHitDices()*this.getHitDicesSize()) +
                                            Personagem.getMod(this.str));     //Hit dices(max) + mod. força
        return minDmg + " ~ " + maxDmg;
    }
    
    public String getHpDicesString(){
        String hitDices = "";
        int classesNumber = classes.getSize();      //Pega o número de classes que jogador possui
        for(int i=0;i<classesNumber;i++){   //Para cada classe
            //Adiciona a hitDices o tamanho do dado desta classe vezes o nível dela (em string):
            String classLevel = Integer.toString(getClasse(i).level);
            String classDices = Integer.toString(getClasse(i).hpDiceSize);
            hitDices += classLevel + "d" + classDices + "+";
        }
        return hitDices.substring(0, hitDices.length()-1);  //Retonra a string hitDices menos o último sinal de '+'
    }
    
    public String getClassesString(){
        String classesNome = "";
        int classesNumber = this.classes.getSize();
        for(int i=0;i<classesNumber;i++){
            Classe classe = (Classe)this.classes.getElementAt(i);
            switch(classe.tipo){    //gera a string com o nome da classe
                case WARRIOR:
                    if (this.genero == "Masculino")
                        classesNome += "Guerreiro";
                    else
                        classesNome += "Guerreira";
                    break;
                case BARBARIAN:
                    if (this.genero == "Masculino")
                        classesNome += "Bárbaro";
                    else
                        classesNome += "Bárbara";
                    break;
                case RANGER:
                    if (this.genero == "Masculino")
                        classesNome += "Ladino";
                    else
                        classesNome += "Ladina";
                    break;
                case CLERIC:
                    if (this.genero == "Masculino")
                        classesNome += "Clérigo";
                    else
                        classesNome += "Clériga";
                    break;
                case WIZARD:
                    if (this.genero == "Masculino")
                        classesNome += "Mago";
                    else
                        classesNome += "Bruxa";
                    break;
            }
            classesNome += " (" + Integer.toString(classe.level) + "), ";    //Adiciona o level
        }
        return classesNome.substring(0, classesNome.length()-2);    //Retorna a string sem a última vírgula ", "
    }
    
    @Override
    public int getAC(){
        return 10 + Personagem.getMod(this.con);    //Retorna 10 + mod. de constituição
        //TODO pontos do equipamento (armadura, escudo, elmo);
    }
    
    @Override
    public int getHpMax(){
        int conMod = Personagem.getMod(this.con);
        int hitDices = 0;
        int classesNumber = classes.getSize();
        for(int i=0;i<classesNumber;i++){
            //Adiciona a hitDices o tamanho do dado desta classe vezes o nível dela:
            hitDices += (getClasse(i).hpDiceSize)*(getClasse(i).level);
        }
        return hitDices + conMod*level;     //HP max = dados de vida por level de classe + (level * mod. de constituição)
    }
    
    @Override
    public void tookDamage(int damage){
        hp -= damage;
        if(hp <= 0){
            hp = 0;
            morrendo = true;
        }
    }
    
    /**
     * Retorna a classe número index da lista de classes deste jogador
     * @param index
     * @return 
     */
    public Classe getClasse(int index){
        return (Classe)this.classes.get(index);
    }
    
    @Override
    public String toString(){
        if(morrendo)
            return this.nome + " (morrendo)";
        else
            return this.nome + " (" + this.hp + "/" + this.getHpMax() + " HP)";
    }
    
    @Override
    public void cura(int valor){
        this.hp += valor;
        if(this.hp > this.getHpMax())
            this.hp = this.getHpMax();
        if(this.morrendo)
            this.morrendo = false;
    }
}
