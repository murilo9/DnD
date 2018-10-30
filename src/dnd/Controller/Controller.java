package dnd.Controller;

import dnd.Model.EnumRaca;
import dnd.Model.*;
import dnd.DND;     //necessária para acessaros membros estáticos da classe principal
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public abstract class Controller {
    public static String errorMessage;
    
    public void atack(Personagem atacante, Personagem alvo){
        //TODO
    }
    
    /**
     * Retorna a string que possui os dados a serem exibidos na view para o valor indicado
     * @param index
     * @param playerIndex índice do jogador na DND.partida.jogadores ListModel
     * @param value string indicando a View label cuja string se deseja obter
     * @param tipo
     * @return 
     */
    public static String getLabel(int index, String value, String tipo){
        Personagem alvo;
        //jAvlo é uma referência ao jogador usada somente para retirar atributos que só jogadores possuem:
        Jogador jAlvo = (Jogador)DND.partida.jogadores.getElementAt(index);
        if(tipo == "jogador")
            alvo = (Jogador)DND.partida.jogadores.getElementAt(index);
        else if(tipo == "npc")
            alvo = (Npc)DND.partida.npcs.getElementAt(index);
        else
            return "null";
        String atribute, mod;
        switch(value){
            case "str":
                atribute = Integer.toString(alvo.str);
                mod = Integer.toString(Personagem.getMod(alvo.str));
                return atribute+" ("+mod+")";
            case "con":
                atribute = Integer.toString(alvo.con);
                mod = Integer.toString(Personagem.getMod(alvo.con));
                return atribute+" ("+mod+")";
            case "dex":
                atribute = Integer.toString(alvo.dex);
                mod = Integer.toString(Personagem.getMod(alvo.dex));
                return atribute+" ("+mod+")";
            case "itl":
                atribute = Integer.toString(alvo.itl);
                mod = Integer.toString(Personagem.getMod(alvo.itl));
                return atribute+" ("+mod+")";
            case "wis":
                atribute = Integer.toString(alvo.wis);
                mod = Integer.toString(Personagem.getMod(alvo.wis));
                return atribute+" ("+mod+")";
            case "cha":
                atribute = Integer.toString(alvo.cha);
                mod = Integer.toString(Personagem.getMod(alvo.cha));
                return atribute+" ("+mod+")";
            case "descri":
                return jAlvo.descricao;
            case "raca":
                return jAlvo.getRacaString();
            case "level":
                return Integer.toString(jAlvo.getLevel());
            case "hp":
                return Integer.toString(jAlvo.hp)+"/"+Integer.toString(alvo.getHpMax());
            case "hpDices":
                return jAlvo.getHpDicesString();
            case "AC":
                return Integer.toString(alvo.getAC());
            case "dmgPot":
                return jAlvo.getDmgPotString();
            case "classes":
                return jAlvo.getClassesString();
            //TODO resto
            default:
                return "null..";
        }
    }
    
    public static boolean tryCriaNPC(String INnome, String INraca, String INhp, 
            String INac, String INstr, String INcon, String INdex, String INitl, 
            String INwis, String INcha, DefaultListModel INpericias){
        //Declarando variáveis que serão passadas ao construtor do NPC:
        int hp, ac, str, con, dex, itl, wis, cha;
        EnumRaca raca;
        try{
            hp = Integer.parseInt(INhp);
            ac = Integer.parseInt(INac);
            str = Integer.parseInt(INstr);
            con = Integer.parseInt(INcon);
            dex = Integer.parseInt(INdex);
            wis = Integer.parseInt(INwis);
            itl = Integer.parseInt(INitl);
            cha = Integer.parseInt(INcha);
            //TODO verificação de valores mínimo e máximo
        }catch (NumberFormatException e){   //Em caso de erro de conversão:
            errorMessage = "Insira um valor válido nos campos numéricos.";
            return false;
        }
        //Validação do nome:
        if(INnome == ""){
            errorMessage = "Insira um nome.";
            return false;
        }
        if(INnome.length() < 3){
            errorMessage = "O nome deve ter pelo menos 3 caracteres";
            return false;
        }
        //Validação da classe:
        switch(INraca){
            case "Aberração": raca = EnumRaca.ABERRATION; break;
            case "Besta": raca = EnumRaca.FIEND; break;
            case "Celestial": raca = EnumRaca.CELESTIAL; break;
            case "Construto": raca = EnumRaca.CONSTRUCT; break;
            case "Corruptor": raca = EnumRaca.CORRUPTOR; break;
            case "Dragão": raca = EnumRaca.DRAGON; break;
            case "Elemental": raca = EnumRaca.ELEMENTAL; break;
            case "Fada": raca = EnumRaca.FAIRY; break;
            case "Gigante": raca = EnumRaca.GIANT; break;
            case "Humanóide": raca = EnumRaca.HUMANOID; break;
            case "Limo": raca = EnumRaca.SLIME; break;
            case "Monstruosidade": raca = EnumRaca.MONSTRUOSITY; break;
            case "Morto-Vivo": raca = EnumRaca.UNDEAD; break;
            case "Planta":raca = EnumRaca.UNDEAD; break;
            default:
                errorMessage = "Raca indefinida...";
                return false;
        }
        //Instancia o NPC:
        DND.partida.addNPC(new Npc(INnome, raca, INpericias, hp, ac, str, con, dex, itl, wis, cha));
        return true;
    }
    
    /**
     * Recebe as string da View, valida os dados e tenta instanciar um jogador.
     * Retorna true em caso de sucesso. Retorna false e gera uma errorMessage
     * em caso de fracasso.
     * @param INnome
     * @param INdescri
     * @param INraca
     * @param INclasse
     * @param INalign
     * @param INgenero
     * @param INstr
     * @param INcon
     * @param INdex
     * @param INitl
     * @param INwis
     * @param INcha
     * @param INpericias
     * @return 
     */
    public static boolean tryCriaJogador(String INnome, String INdescri, String INraca,
            String INclasse, String INalign, String INgenero, String INstr, String INcon,
            String INdex, String INitl, String INwis, String INcha, DefaultListModel INpericias){
        //Declarando variáveis que serão passadas ao contrutor do Jogador:
        int str, con, dex, itl, wis, cha;
        EnumClasse classe;
        Align align;
        EnumRaca raca;
        //Verifica a conversão dos atributos:
        try{
            str = Integer.parseInt(INstr);
            con = Integer.parseInt(INcon);
            dex = Integer.parseInt(INdex);
            wis = Integer.parseInt(INwis);
            itl = Integer.parseInt(INitl);
            cha = Integer.parseInt(INcha);
        }catch (NumberFormatException e){   //Em caso de erro de conversão:
            errorMessage = "Insira um valor válido nos campos numéricos.";
            return false;
        }
        //Validação do nome:
        if(INnome == ""){
            errorMessage = "Insira um nome.";
            return false;
        }
        if(INnome.length() < 3){
            errorMessage = "O nome deve ter pelo menos 3 caracteres";
            return false;
        }
        //Validação da classe:
        switch(INclasse){
            case "Bárbaro(a)":
                classe = EnumClasse.BARBARIAN;
                break;
            case "Guerreiro(a)":
                classe = EnumClasse.WARRIOR;
                break;
            case "Ladino(a)":
                classe = EnumClasse.RANGER;
                break;
            case "Mago/Bruxa":
                classe = EnumClasse.WIZARD;
                break;
            case "Clérigo(a)":
                classe = EnumClasse.CLERIC;
                break;
            default:
                errorMessage = "Classe indefinida...";
                return false;
        }
        //Validação do alinhamento:
        switch(INalign){
            case "Lawful Good":
                align = Align.LG;
                break;
            case "Neutral Good":
                align = Align.NG;
                break;
            case "Chaotic Good":
                align = Align.CG;
                break;
            case "Lawful Neutral":
                align = Align.LN;
                break;
            case "True Neutral":
                align = Align.TN;
                break;
            case "Chaotic Neutral":
                align = Align.CN;
                break;
            case "Lawful Evil":
                align = Align.LE;
                break;
            case "Neutral Evil":
                align = Align.NE;
                break;
            case "Chaotic Evil":
                align = Align.CE;
                break;
            default:
                errorMessage = "Alinhamento indefinido...";
                return false;    
        }
        //Validação da raça:
        switch(INraca){
            case "Humano":
                raca = EnumRaca.HUMAN;
                break;
            case "Anão":
                raca = EnumRaca.DWARF;
                break;
            case "Elfo":
                raca = EnumRaca.ELF;
                break;
            case "Meio-orc":
                raca = EnumRaca.HALFORC;
                break;
            default:
                errorMessage = "Raça indefinida...";
                return false;
        }
        //Após feitas as validações sem retorno com erro, instancia o jogador
        DND.partida.addJogador(new Jogador(INnome,raca,INpericias,str,con,dex,itl,wis,cha, 
                                            INdescri,INgenero,classe,align));
        //Se chegou até aqui, sucesso:
        return true;
    }
    
    /**
     * Esta função retorna um comboBoxModel com a lista de todos os personagens.
     * O índice é necessário pois cada comboBox exibindo a lista de personagens
     * precisa se basear num model diferent, então na verdade ele retorna um 
     * model que é um índice de um array.
     * @param index
     * @return 
     */
    public static DefaultComboBoxModel getComboNPCs(int index){
        DefaultComboBoxModel model1 = new DefaultComboBoxModel();
        DefaultComboBoxModel model2 = new DefaultComboBoxModel();
        //Pega a lista de NPCs:
        int npcSize = DND.partida.npcs.getSize();
        if(npcSize > 0){
            for(int i=0;i<npcSize;i++){
                model1.addElement(DND.partida.npcs.get(i));
                model2.addElement(DND.partida.npcs.get(i));
            }
        }
        if(index == 0)
            return model1;
        else
            return model2;
    }
    
    public static DefaultComboBoxModel getComboJogadores(int index){
        DefaultComboBoxModel model1 = new DefaultComboBoxModel();
        DefaultComboBoxModel model2 = new DefaultComboBoxModel();
        int jogSize = DND.partida.jogadores.getSize();
        if(jogSize > 0){
            for(int i=0;i<jogSize;i++){
                model1.addElement(DND.partida.jogadores.getElementAt(i));
                model2.addElement(DND.partida.jogadores.getElementAt(i));
            }
        }
        if(index == 0)
            return model1;
        else
            return model2;
    }
}
