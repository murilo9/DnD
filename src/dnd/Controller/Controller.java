package dnd.Controller;

import dnd.Model.EnumRaca;
import dnd.Model.*;
import dnd.DND;     //necessária para acessar os membros estáticos da classe principal
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public abstract class Controller {
    public static String message, errorMessage;
    static Random random = new Random();
    
    public static void refreshNpcList(){
        DND.janelaPrincipal.refreshListaNPCs();
    }
    
    public static void refreshJogList(){
        DND.janelaPrincipal.refreshComboBoxJogadores();
    }
    
    public static void refreshView(){
        DND.janelaPrincipal.refreshView();
    }
    
    public static boolean dinheiro(int index, String INvalor, boolean remove){
        //Tratamento do valor:
        int valor;
        Jogador jogador = (Jogador)DND.partida.jogadores.getElementAt(index);
        try{
            valor = Integer.parseInt(INvalor);
            if(Integer.signum(valor) == -1)
                valor = 0 - valor;      //Tira o módulo caso o valor seja negativo
        }catch(NumberFormatException e){
            errorMessage = "Insira um valor válido";
            return false;
        }
        if(remove){
            if(jogador.getDinheiro() < valor){
                errorMessage = "Este jogador não tem tanto dinheiro";
                return false;
            }else
                jogador.setDinheiro(-valor);
        }else{
            jogador.setDinheiro(valor);
        }
        return true;
    }
    
    public static boolean diceRoll(String INdices, String INsize, String INbonus, String tipo){
        //Validação dos dados:
        int dices, size, bonus;
        try{
            dices = Integer.parseInt(INdices);
            size = Integer.parseInt(INsize);
            bonus = Integer.parseInt(INbonus);
        }catch(NumberFormatException e){
            errorMessage = "Insira valores válidos";
            return false;
        }
        if(dices < 1 || size < 1){
            errorMessage = "Insira valores válidos";
            return false;
        }
        //Rolagem de dados:
        int roll = 0;
        int roll2 = 0;
        String tipoLabel = "";
        for(int i = 0; i < dices; i++)
            roll += 1 + random.nextInt(size-1);
        if(tipo == "vantagem"){     //Jogada de vantagem
            tipoLabel = "(vantagem)";
            for(int i = 0; i < dices; i++)
                roll2+= 1 + random.nextInt(size-1);
            if(roll2 > roll)    //Se a segunda jogada for maior, aplica ela
                roll = roll2;
        }else if(tipo == "desvantagem"){        //Jogada de desvantagem
            tipoLabel = "(desvantagem)";
            for(int i = 0; i < dices; i++)
                roll2+= 1 + random.nextInt(size-1);
            if(roll2 < roll)    //Se a segunda jogada for menor, aplica ela
                roll = roll2;
        }
        //Escrevea mensagem que será exibida:
        message = dices + "d" + size + " + (" + bonus + ") " + tipoLabel + " = " + (roll+bonus);
        return true;
    }
    
    public static boolean cura(int index, String INvalor, boolean player){
        //Valida o valor recebido:
        int valor;
        try{
            valor = Integer.parseInt(INvalor);
        }catch (NumberFormatException e){
            errorMessage = "Insira um valor válido";
            return false;
        }
        if(valor < 1){
            errorMessage = "Insira um valor válido";
            return false;
        }
        //Aplica a cura ao personagem indicado:
        Jogador jogador;
        Npc npc;
        if(player){     //Cura jogador
            jogador = (Jogador)DND.partida.jogadores.getElementAt(index);
            jogador.cura(valor);
        }else{      //Cura NPC
            npc = (Npc)DND.partida.npcs.getElementAt(index);
            npc.cura(valor);
        }
        //Se chegou até aqui, então deu tudo certo
        return true;
    }
    
    public static boolean atack(int atacanteIndex, int alvoIndex, boolean jogAtac, boolean jogAlvo, String tipo){
        Personagem atacante, alvo;
        //Pega os personagens:
        if(jogAtac)     //Jogador ataca
            atacante = (Jogador)DND.partida.jogadores.getElementAt(atacanteIndex);
        else        //NPC ataca
            atacante = (Npc)DND.partida.npcs.getElementAt(atacanteIndex);
        if(jogAlvo)     //Jogador alvo
            alvo = (Jogador)DND.partida.jogadores.getElementAt(alvoIndex);
        else        //NPC alvo
            alvo = (Npc)DND.partida.npcs.getElementAt(alvoIndex);
        //Die roll do atacante:
        boolean critical = false;
        boolean vantagem = false;
        boolean desvantagem = false;
        String atacName = atacante.nome;
        String alvoName = alvo.nome;
        message = atacName + " ataca " + alvoName;
        int dieRoll = 1 + random.nextInt(19);   //Joga o die roll
        if(tipo == "vantagem"){
            vantagem = true;
            message += " (vantagem)";
            int dieRoll2 = 1 + random.nextInt(19);
            if(dieRoll < dieRoll2)  //Se a segunda jogada for maior, utiliza ela
                dieRoll = dieRoll2;
        }else if(tipo == "desvantagem"){
            desvantagem = true;
            message += " (desvantagem)";
            int dieRoll2 = 1 + random.nextInt(19);
            if(dieRoll > dieRoll2)  //Se a segunda jogada for menor, utiliza ela
                dieRoll = dieRoll2;
        }
        message += "\n";
        String dr = Integer.toString(dieRoll);  //Grava o die roll numa string
        int bonus = atacante.dieRollBonus();
        if(dieRoll == 20)
            critical = true;
        //Verifica falha crítica:
        if(dieRoll == 1){
            message += "d20 = 1 + ( " + bonus + ") vs " + alvo.getAC() + ": falha crítica!";
            return false;
        }
        if(critical){
            //Acerto crítico:
            int hitDices = atacante.getHitDices();
            int size = atacante.getHitDicesSize();
            int damage = hitDices*size + atacante.getDamageBonus();
            alvo.tookDamage(damage);
            //TODO joga dado extra pra ver se há dano extra
            message += "Die roll = 20 + (" + bonus + ") vs " + alvo.getAC()+ 
                    ": acerto crítico! \n" + damage + " de dano";
            return true;
        }else if(dieRoll+atacante.dieRollBonus() > alvo.getAC()){
            //Acerto comum:
            int hitDices = atacante.getHitDices();
            int size = atacante.getHitDicesSize();
            int damage = hitDices*size + atacante.getDamageBonus();
            alvo.tookDamage(damage);
            message += "Die roll = " + dieRoll + " + (" + bonus +") vs " + alvo.getAC() +
                    ": acerto \n" + damage + " de dano";
            return true;
        }else{
            //Miss
            message += "Die roll = " + dieRoll + " + (" + bonus + ") vs " + alvo.getAC() + ": falha";
            return false;
        }
    }
    
    /**
     * Retorna a string que possui os dados a serem exibidos na view para o valor indicado
     * @param index
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
            case "dinheiro":
                return Integer.toString(jAlvo.getDinheiro()) + " $";
            case "xp":
                return jAlvo.getXp() + " / " + jAlvo.getXpNext();
            default:
                return "null..";
        }
    }
    
    public static boolean tryCriaNPC(String INnome, String INraca, String INhp, 
            String INac, String INhitDices, String INhitDicesSize, 
            String INstr, String INcon, String INdex, String INitl, 
            String INwis, String INcha, DefaultListModel INpericias){
        //Declarando variáveis que serão passadas ao construtor do NPC:
        int hp, ac, hitDices, hitDicesSize, str, con, dex, itl, wis, cha;
        EnumRaca raca;
        try{
            hp = Integer.parseInt(INhp);
            ac = Integer.parseInt(INac);
            hitDices = Integer.parseInt(INhitDices);
            hitDicesSize = Integer.parseInt(INhitDicesSize);
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
        if(hitDices == 0 || hitDicesSize == 0){
            errorMessage = "O NPC deve ter ao menos 1 dado de ataque.";
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
        DND.partida.addNPC(new Npc(INnome, raca, INpericias, hp, ac, hitDices,
                hitDicesSize, str, con, dex, itl, wis, cha));
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
     * Esta função retorna um comboBoxModel com a lista de todos os NPCs.
     * O índice é necessário pois cada comboBox exibindo a lista de NPCs
     * precisa se basear num model diferente.
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
        }else
            return null;
        if(index == 0)
            return model1;
        else
            return model2;
    }
    
    /**
     * Esta função retorna uma ComboBoxModel com a lista de todos os jogadores.
     * O índice é necessário pois cada comboBox exibindo a lista de NPCs
     * precisa se basear num model diferente.
     * @param index
     * @return 
     */
    public static DefaultComboBoxModel getComboJogadores(int index){
        DefaultComboBoxModel model1 = new DefaultComboBoxModel();
        DefaultComboBoxModel model2 = new DefaultComboBoxModel();
        int jogSize = DND.partida.jogadores.getSize();
        if(jogSize > 0){
            for(int i=0;i<jogSize;i++){
                model1.addElement(DND.partida.jogadores.getElementAt(i));
                model2.addElement(DND.partida.jogadores.getElementAt(i));
            }
        }else
            return null;
        if(index == 0)
            return model1;
        else
            return model2;
    }
}
