/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.View;

import dnd.DND;
import dnd.Controller.Controller;
import dnd.Model.Jogador;
import dnd.Model.Npc;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Murilo
 */
public class JanelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaPrincipal() {
        initComponents();
        this.setVisible(true);
    }
    
    public void refreshListaNPCs(){
        listaNPC.setModel(DND.partida.getListaNPCs());
    }
    
    public void refreshComboBoxJogadores(){
        comboBoxJogadores.setModel(DND.partida.getListaJogadores());   //Atualiza lista de jogadores
    }
    
    public boolean refreshView(){
        int playerIndex = comboBoxJogadores.getSelectedIndex();
        if(playerIndex == -1){     //Reseta a View
            //Atualiza a aba de atributos:
            labelStr.setText("-----");
            labelCon.setText("-----");
            labelDex.setText("-----");
            labelItl.setText("-----");
            labelWis.setText("-----");
            labelCha.setText("-----");
            labelDescri.setText("-----");
            labelHP.setText("-/-");
            labelRaca.setText("-----");
            labelLevel.setText("-----");
            labelDinheiro.setText("-----");
            labelXP.setText("-----");
            //Atualiza a aba de inventário:
            DefaultListModel emptyListModel = new DefaultListModel();
            inventarioList.setModel(emptyListModel);
            itemDescri.setText("");
        }else{      //Exibe os dados do jogador e NPC selecionado
            //Atualiza a aba de atributos:
            labelStr.setText(Controller.getLabel(playerIndex,"str","jogador"));
            labelCon.setText(Controller.getLabel(playerIndex,"con","jogador"));
            labelDex.setText(Controller.getLabel(playerIndex,"dex","jogador"));
            labelItl.setText(Controller.getLabel(playerIndex,"itl","jogador"));
            labelWis.setText(Controller.getLabel(playerIndex,"wis","jogador"));
            labelCha.setText(Controller.getLabel(playerIndex,"cha","jogador"));
            labelDescri.setText(Controller.getLabel(playerIndex, "descri","jogador"));
            labelHP.setText(Controller.getLabel(playerIndex,"hp","jogador"));
            labelRaca.setText(Controller.getLabel(playerIndex, "raca","jogador"));
            labelLevel.setText("Level "+Controller.getLabel(playerIndex, "level","jogador"));
            labelHPDices.setText(Controller.getLabel(playerIndex, "hpDices","jogador"));
            labelAC.setText(Controller.getLabel(playerIndex, "AC","jogador"));
            labelDP.setText(Controller.getLabel(playerIndex, "dmgPot","jogador"));
            labelClasse.setText(Controller.getLabel(playerIndex, "classes","jogador"));
            labelDinheiro.setText(Controller.getLabel(playerIndex, "dinheiro", "jogador"));
            labelXP.setText(Controller.getLabel(playerIndex, "xp", "jogador"));
            Jogador jogador = (Jogador)comboBoxJogadores.getSelectedItem();
            listaPericiasJogador.setModel(jogador.pericias);
            //Atualiza a aba de inventário:
            int jogadorIndex = comboBoxJogadores.getSelectedIndex();
            int itemJogadorIndex = inventarioList.getSelectedIndex();
            inventarioList.setModel(Controller.getInventario(jogadorIndex));    //Atualiza a lista de inventário
            if(inventarioList.getSelectedIndex() > -1)   //Atualiza a descrição do item selecionado, caso haja
                itemDescri.setText(Controller.getJogadorItemDescri(jogadorIndex, itemJogadorIndex));
        }
        int npcIndex = listaNPC.getSelectedIndex();
        if(DND.partida.getListaNPCs().getSize() > 0 && npcIndex > -1){   //Se houver NPCs instanciados
            //atualiza as labels do NPC:
            labelStrN.setText(Controller.getLabel(npcIndex,"str","npc"));
            labelConN.setText(Controller.getLabel(npcIndex,"con","npc"));
            labelDexN.setText(Controller.getLabel(npcIndex,"dex","npc"));
            labelItlN.setText(Controller.getLabel(npcIndex,"itl","npc"));
            labelWisN.setText(Controller.getLabel(npcIndex,"wis","npc"));
            labelChaN.setText(Controller.getLabel(npcIndex,"cha","npc"));
            Npc npc = (Npc)DND.partida.npcs.getElementAt(npcIndex);
            listaPericiasNPC.setModel(npc.pericias);
        }else{      //Caso contrário
            //Reseta as labesd de NPC:
            labelStrN.setText("-----");
            labelConN.setText("-----");
            labelDexN.setText("-----");
            labelItlN.setText("-----");
            labelWisN.setText("-----");
            labelChaN.setText("-----");
            listaPericiasNPC.setModel(new DefaultListModel());
        }
        return true;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        comboBoxJogadores = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        labelHP = new javax.swing.JLabel();
        labelRaca = new javax.swing.JLabel();
        labelLevel = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        labelStr = new javax.swing.JLabel();
        labelCon = new javax.swing.JLabel();
        labelDex = new javax.swing.JLabel();
        labelItl = new javax.swing.JLabel();
        labelWis = new javax.swing.JLabel();
        labelCha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        labelDescri = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaPericiasJogador = new javax.swing.JList<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelHPDices = new javax.swing.JLabel();
        labelAC = new javax.swing.JLabel();
        labelDP = new javax.swing.JLabel();
        labelClasse = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelDinheiro = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelXP = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        inventarioList = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        itemDescri = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaNPC = new javax.swing.JList<>();
        jPanel10 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        labelStrN = new javax.swing.JLabel();
        labelConN = new javax.swing.JLabel();
        labelDexN = new javax.swing.JLabel();
        labelItlN = new javax.swing.JLabel();
        labelWisN = new javax.swing.JLabel();
        labelChaN = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaPericiasNPC = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuArquivoNovaPartida = new javax.swing.JMenuItem();
        menuArquivoCarregarPartida = new javax.swing.JMenuItem();
        menuArquivoSalvarPartida = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuArquivoSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuPersonAddJogador = new javax.swing.JMenuItem();
        menuPersonRemoveJogador = new javax.swing.JMenuItem();
        menuPersonCuraJog = new javax.swing.JMenuItem();
        menuPersonAddNPC = new javax.swing.JMenuItem();
        menuPersonRemoveNPC = new javax.swing.JMenuItem();
        menuPersonCuraNPC = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuAcaoAtaque = new javax.swing.JMenuItem();
        menuAcaoDiceRoll = new javax.swing.JMenuItem();
        menuAcaoDinheiro = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuItensAdd = new javax.swing.JMenuItem();
        menuItemRemove = new javax.swing.JMenuItem();
        menuItemTransfer = new javax.swing.JMenuItem();
        menuItensLoja = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuItensGer = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dungeons & Dragons");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Jogador"));

        comboBoxJogadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxJogadoresActionPerformed(evt);
            }
        });

        jLabel1.setText("HP:");

        labelHP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelHP.setText("-/-");

        labelRaca.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelRaca.setText("--------");

        labelLevel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelLevel.setText("--------");

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Atributos"));

        jLabel16.setText("Força");

        jLabel17.setText("Constituição");

        jLabel18.setText("Destreza");

        jLabel19.setText("Inteligência");

        jLabel20.setText("Conhecimento");

        jLabel21.setText("Carisma");

        labelStr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelStr.setText("------");

        labelCon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCon.setText("------");

        labelDex.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelDex.setText("------");

        labelItl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelItl.setText("------");

        labelWis.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelWis.setText("------");

        labelCha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCha.setText("------");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelCha, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(labelWis, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(labelItl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelStr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(labelStr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(labelCon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(labelDex))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(labelItl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(labelWis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(labelCha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelDescri.setColumns(20);
        labelDescri.setRows(5);
        jScrollPane1.setViewportView(labelDescri);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Perícias"));

        jScrollPane3.setViewportView(listaPericiasJogador);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setText("Dados de Vida:");

        jLabel3.setText("Classe de Armadura:");

        jLabel4.setText("Potencial de Dano:");

        jLabel5.setText("Classe(s):");

        labelHPDices.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelHPDices.setText("------");

        labelAC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAC.setText("------");

        labelDP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelDP.setText("------");

        labelClasse.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelClasse.setText("------");

        jLabel6.setText("Dinheiro:");

        labelDinheiro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelDinheiro.setText("------");

        jLabel7.setText("Experiência:");

        labelXP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelXP.setText("------");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelClasse, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                            .addComponent(labelDP, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                            .addComponent(labelAC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelHPDices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(88, 88, 88)
                        .addComponent(labelDinheiro, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(72, 72, 72)
                        .addComponent(labelXP, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelHPDices))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelAC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelDP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labelClasse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(labelDinheiro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(labelXP))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Dados", jPanel3);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Equipamento"));

        jButton1.setText("Cabeça");

        jButton3.setText("Corpo");

        jButton4.setText("Mão 1");

        jButton5.setText("Mão 2");

        jButton6.setText("Pés");

        jButton7.setText("Acessório");

        jLabel8.setText("Classe de Armadura:");

        jLabel9.setText("Potencial de Dano:");

        jLabel10.setText("-----");

        jLabel11.setText("-----");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens"));

        inventarioList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                inventarioListValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(inventarioList);

        itemDescri.setEditable(false);
        itemDescri.setColumns(20);
        itemDescri.setRows(5);
        jScrollPane6.setViewportView(itemDescri);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Inventário", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 412, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Magias", jPanel5);

        jButton2.setText("Level Up");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(comboBoxJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelHP, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(labelRaca)
                        .addGap(18, 18, 18)
                        .addComponent(labelLevel)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(labelHP)
                    .addComponent(labelRaca)
                    .addComponent(labelLevel)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("NPC"));

        listaNPC.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaNPCValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listaNPC);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Atributos"));

        jLabel23.setText("Força");

        jLabel24.setText("Constituição");

        jLabel25.setText("Destreza");

        jLabel26.setText("Inteligência");

        jLabel27.setText("Conhecimento");

        jLabel33.setText("Carisma");

        labelStrN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelStrN.setText("------");
        labelStrN.setName(""); // NOI18N

        labelConN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelConN.setText("------");

        labelDexN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelDexN.setText("------");

        labelItlN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelItlN.setText("------");

        labelWisN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelWisN.setText("------");

        labelChaN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelChaN.setText("------");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelChaN, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(labelWisN, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(labelItlN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDexN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelConN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelStrN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(labelStrN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(labelConN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(labelDexN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(labelItlN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(labelWisN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(labelChaN))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Perícias"));

        jScrollPane4.setViewportView(listaPericiasNPC);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Arquivo");

        menuArquivoNovaPartida.setText("Nova Partida");
        menuArquivoNovaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArquivoNovaPartidaActionPerformed(evt);
            }
        });
        jMenu1.add(menuArquivoNovaPartida);

        menuArquivoCarregarPartida.setText("Carregar Partida");
        jMenu1.add(menuArquivoCarregarPartida);

        menuArquivoSalvarPartida.setText("Salvar Partida");
        menuArquivoSalvarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArquivoSalvarPartidaActionPerformed(evt);
            }
        });
        jMenu1.add(menuArquivoSalvarPartida);
        jMenu1.add(jSeparator1);

        jMenuItem5.setText("Gerenciar Bases de Dados");
        jMenu1.add(jMenuItem5);
        jMenu1.add(jSeparator2);

        menuArquivoSair.setText("Sair");
        menuArquivoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArquivoSairActionPerformed(evt);
            }
        });
        jMenu1.add(menuArquivoSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Personagens");

        menuPersonAddJogador.setText("Inserir Jogador");
        menuPersonAddJogador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPersonAddJogadorActionPerformed(evt);
            }
        });
        jMenu2.add(menuPersonAddJogador);

        menuPersonRemoveJogador.setText("Remover Jogador");
        menuPersonRemoveJogador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPersonRemoveJogadorActionPerformed(evt);
            }
        });
        jMenu2.add(menuPersonRemoveJogador);

        menuPersonCuraJog.setText("Curar Jogador");
        menuPersonCuraJog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPersonCuraJogActionPerformed(evt);
            }
        });
        jMenu2.add(menuPersonCuraJog);

        menuPersonAddNPC.setText("Inserir NPC");
        menuPersonAddNPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPersonAddNPCActionPerformed(evt);
            }
        });
        jMenu2.add(menuPersonAddNPC);

        menuPersonRemoveNPC.setText("Remover NPC");
        menuPersonRemoveNPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPersonRemoveNPCActionPerformed(evt);
            }
        });
        jMenu2.add(menuPersonRemoveNPC);

        menuPersonCuraNPC.setText("Curar NPC");
        menuPersonCuraNPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPersonCuraNPCActionPerformed(evt);
            }
        });
        jMenu2.add(menuPersonCuraNPC);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ação");

        menuAcaoAtaque.setText("Ataque");
        menuAcaoAtaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAcaoAtaqueActionPerformed(evt);
            }
        });
        jMenu3.add(menuAcaoAtaque);

        menuAcaoDiceRoll.setText("Rolar Dado(s)");
        menuAcaoDiceRoll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAcaoDiceRollActionPerformed(evt);
            }
        });
        jMenu3.add(menuAcaoDiceRoll);

        menuAcaoDinheiro.setText("Gerenciar Dinheiro");
        menuAcaoDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAcaoDinheiroActionPerformed(evt);
            }
        });
        jMenu3.add(menuAcaoDinheiro);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Itens");

        menuItensAdd.setText("Adicionar");
        menuItensAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItensAddActionPerformed(evt);
            }
        });
        jMenu4.add(menuItensAdd);

        menuItemRemove.setText("Remover");
        menuItemRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRemoveActionPerformed(evt);
            }
        });
        jMenu4.add(menuItemRemove);

        menuItemTransfer.setText("Transferir");
        jMenu4.add(menuItemTransfer);

        menuItensLoja.setText("Abrir Loja");
        jMenu4.add(menuItensLoja);
        jMenu4.add(jSeparator3);

        menuItensGer.setText("Gerenciar Lojas");
        jMenu4.add(menuItensGer);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuArquivoNovaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArquivoNovaPartidaActionPerformed
        JanelaNovaPartida janelaNovaPartida;
        if(JOptionPane.showConfirmDialog(null, "Deseja abandonar esta partida e iniciar uma nova?") == 0){
            janelaNovaPartida = new JanelaNovaPartida(this, true);
        }
    }//GEN-LAST:event_menuArquivoNovaPartidaActionPerformed

    private void menuArquivoSalvarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArquivoSalvarPartidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuArquivoSalvarPartidaActionPerformed

    private void menuArquivoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArquivoSairActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Deseja mesmo sair sem salvar?") == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_menuArquivoSairActionPerformed

    private void menuPersonAddJogadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPersonAddJogadorActionPerformed
        JanelaCriaJogador janelaCriaJogador = new JanelaCriaJogador(this, true);
    }//GEN-LAST:event_menuPersonAddJogadorActionPerformed

    private void menuPersonRemoveJogadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPersonRemoveJogadorActionPerformed
        if(DND.partida.getListaJogadores().getSize() > 0){
            int jogadorSelec = comboBoxJogadores.getSelectedIndex();
            if(JOptionPane.showConfirmDialog(null, "Deseja remover o jogador selecionado?") == 0){
                DND.partida.removeJogador(jogadorSelec);    //Remove o jogador
                refreshComboBoxJogadores();     //Atualiza a comboBox de jogadores, ja que ela foi modificada
                refreshView();      //Atualiza a view
            }
        }
    }//GEN-LAST:event_menuPersonRemoveJogadorActionPerformed

    private void comboBoxJogadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxJogadoresActionPerformed
        refreshView();
    }//GEN-LAST:event_comboBoxJogadoresActionPerformed

    private void menuPersonAddNPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPersonAddNPCActionPerformed
        JanelaCriaNPC janelaCriaNPC = new JanelaCriaNPC(this, true);
    }//GEN-LAST:event_menuPersonAddNPCActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.out.println(DND.partida.npcs.get(0).toString());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void listaNPCValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaNPCValueChanged
        refreshView();
    }//GEN-LAST:event_listaNPCValueChanged

    private void menuPersonRemoveNPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPersonRemoveNPCActionPerformed
        int index = listaNPC.getSelectedIndex();
        if(index > -1){
            if(JOptionPane.showConfirmDialog(this, "Deseja mesmo remover o NPC selecionado?") == 0){
                DND.partida.removeNPC(index);
                refreshListaNPCs();     //Atualiza a lista de NPCs
                refreshView();
            }
        }
    }//GEN-LAST:event_menuPersonRemoveNPCActionPerformed

    private void menuAcaoAtaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAcaoAtaqueActionPerformed
        JanelaAtaque janelaAtaque;
        //Verifica se há pelo menos 1 jogador e 1 NPC:
        if(Controller.getComboJogadores(0) != null && Controller.getComboNPCs(0) != null)
            janelaAtaque = new JanelaAtaque(this, true);
    }//GEN-LAST:event_menuAcaoAtaqueActionPerformed

    private void menuPersonCuraNPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPersonCuraNPCActionPerformed
        JanelaCura janelaCura;
        //Verifica se há pelo menos 1 NPC
        if(Controller.getComboNPCs(0) != null)
            janelaCura = new JanelaCura(this, true, false);
    }//GEN-LAST:event_menuPersonCuraNPCActionPerformed

    private void menuPersonCuraJogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPersonCuraJogActionPerformed
        JanelaCura janelaCura;
        //Verifica se há pelo menos 1 jogador
        if(Controller.getComboJogadores(0) != null)
            janelaCura = new JanelaCura(this, true, true);
    }//GEN-LAST:event_menuPersonCuraJogActionPerformed

    private void menuAcaoDiceRollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAcaoDiceRollActionPerformed
        JanelaDados janelaDados = new JanelaDados(this, true);
    }//GEN-LAST:event_menuAcaoDiceRollActionPerformed

    private void menuAcaoDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAcaoDinheiroActionPerformed
        JanelaDinheiro janelaDinheiro;
        if(Controller.getComboJogadores(0) != null)
            janelaDinheiro = new JanelaDinheiro(this, true);
    }//GEN-LAST:event_menuAcaoDinheiroActionPerformed

    private void menuItensAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItensAddActionPerformed
        JanelaAddItem janelaAddItem;
        if(Controller.getComboJogadores(0) != null)
            janelaAddItem = new JanelaAddItem(this, true);
    }//GEN-LAST:event_menuItensAddActionPerformed

    private void inventarioListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_inventarioListValueChanged
        int jogadorIndex = comboBoxJogadores.getSelectedIndex();
        System.out.println(jogadorIndex);
        int itemIndex = inventarioList.getSelectedIndex();
        System.out.println(itemIndex);
        if(jogadorIndex > -1 && itemIndex > -1)
            itemDescri.setText(Controller.getJogadorItemDescri(jogadorIndex, itemIndex));
    }//GEN-LAST:event_inventarioListValueChanged

    private void menuItemRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRemoveActionPerformed
        int playerIndex = comboBoxJogadores.getSelectedIndex();
        int itemIndex = inventarioList.getSelectedIndex();
        if(itemIndex > -1){
            if(JOptionPane.showConfirmDialog(this, "Deseja remover este item do jogador?") == 0){
                Controller.removeItem(playerIndex, itemIndex);
                //TODO: remover quantidade do item
                this.refreshView();
            }
        }
    }//GEN-LAST:event_menuItemRemoveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxJogadores;
    private javax.swing.JList<String> inventarioList;
    private javax.swing.JTextArea itemDescri;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelAC;
    private javax.swing.JLabel labelCha;
    private javax.swing.JLabel labelChaN;
    private javax.swing.JLabel labelClasse;
    private javax.swing.JLabel labelCon;
    private javax.swing.JLabel labelConN;
    private javax.swing.JLabel labelDP;
    private javax.swing.JTextArea labelDescri;
    private javax.swing.JLabel labelDex;
    private javax.swing.JLabel labelDexN;
    private javax.swing.JLabel labelDinheiro;
    private javax.swing.JLabel labelHP;
    private javax.swing.JLabel labelHPDices;
    private javax.swing.JLabel labelItl;
    private javax.swing.JLabel labelItlN;
    private javax.swing.JLabel labelLevel;
    private javax.swing.JLabel labelRaca;
    private javax.swing.JLabel labelStr;
    private javax.swing.JLabel labelStrN;
    private javax.swing.JLabel labelWis;
    private javax.swing.JLabel labelWisN;
    private javax.swing.JLabel labelXP;
    private javax.swing.JList<String> listaNPC;
    private javax.swing.JList<String> listaPericiasJogador;
    private javax.swing.JList<String> listaPericiasNPC;
    private javax.swing.JMenuItem menuAcaoAtaque;
    private javax.swing.JMenuItem menuAcaoDiceRoll;
    private javax.swing.JMenuItem menuAcaoDinheiro;
    private javax.swing.JMenuItem menuArquivoCarregarPartida;
    private javax.swing.JMenuItem menuArquivoNovaPartida;
    private javax.swing.JMenuItem menuArquivoSair;
    private javax.swing.JMenuItem menuArquivoSalvarPartida;
    private javax.swing.JMenuItem menuItemRemove;
    private javax.swing.JMenuItem menuItemTransfer;
    private javax.swing.JMenuItem menuItensAdd;
    private javax.swing.JMenuItem menuItensGer;
    private javax.swing.JMenuItem menuItensLoja;
    private javax.swing.JMenuItem menuPersonAddJogador;
    private javax.swing.JMenuItem menuPersonAddNPC;
    private javax.swing.JMenuItem menuPersonCuraJog;
    private javax.swing.JMenuItem menuPersonCuraNPC;
    private javax.swing.JMenuItem menuPersonRemoveJogador;
    private javax.swing.JMenuItem menuPersonRemoveNPC;
    // End of variables declaration//GEN-END:variables

}
