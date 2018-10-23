package dnd.Controller;

import dnd.Model.*;
import dnd.DND;     //necessária para acessaros membros estáticos da classe principal
import javax.swing.DefaultListModel;

public abstract class Controller {
    public static String errorMessage;
    
    /**
     * Retorna a string que possui os dados a serem exibidos na view para o valor indicado
     * @param playerIndex índice do jogador na DND.partida.jogadores ListModel
     * @param value string indicando a View label cuja string se deseja obter
     * @return 
     */
    public static String getLabel(int playerIndex, String value){
        Jogador jogador = (Jogador)DND.partida.jogadores.getElementAt(playerIndex);
        String atribute, mod;
        switch(value){
            case "str":
                atribute = Integer.toString(jogador.str);
                mod = Integer.toString(Personagem.getMod(jogador.str));
                return atribute+" ("+mod+")";
            case "con":
                atribute = Integer.toString(jogador.con);
                mod = Integer.toString(Personagem.getMod(jogador.con));
                return atribute+" ("+mod+")";
            case "dex":
                atribute = Integer.toString(jogador.dex);
                mod = Integer.toString(Personagem.getMod(jogador.dex));
                return atribute+" ("+mod+")";
            case "itl":
                atribute = Integer.toString(jogador.itl);
                mod = Integer.toString(Personagem.getMod(jogador.itl));
                return atribute+" ("+mod+")";
            case "wis":
                atribute = Integer.toString(jogador.wis);
                mod = Integer.toString(Personagem.getMod(jogador.wis));
                return atribute+" ("+mod+")";
            case "cha":
                atribute = Integer.toString(jogador.cha);
                mod = Integer.toString(Personagem.getMod(jogador.cha));
                return atribute+" ("+mod+")";
            //TODO resto
            default:
                return "null..";
        }
    }
    
    public static boolean tryCriaJogador(String INnome, String INdescri, String INraca,
            String INclasse, String INalign, String INgenero, String INstr, String INcon,
            String INdex, String INitl, String INwis, String INcha, DefaultListModel INpericias){
        //Declarando variáveis que serão passadas ao contrutor do Jogador:
        int str, con, dex, itl, wis, cha;
        EnumClasse classe;
        Align align;
        Raca raca;
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
                raca = Raca.HUMAN;
                break;
            case "Anão":
                raca = Raca.DWARF;
                break;
            case "Elfo":
                raca = Raca.ELF;
                break;
            case "Meio-orc":
                raca = Raca.HALFORC;
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
    
}
