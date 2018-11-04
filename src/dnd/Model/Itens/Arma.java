/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnd.Model.Itens;

import dnd.Model.Itens.Item;

/**
 *
 * @author Murilo
 */
public class Arma extends Item{
    public EquipTipo tipo;
    public int hitDices, hitDicesSize;
    
    public Arma(String INnome, String INdescricao, double INpeso, int INqtd,
                int INvalor, boolean INequipavel, EquipTipo INtipo,
                int INhitDices, int INhitDicesSize){
        super (INnome, INdescricao, INpeso, INqtd, INvalor, INequipavel);   //Chama construtor da superclasse
        this.tipo = INtipo;
        this.hitDices = INhitDices;
        this.hitDicesSize = INhitDicesSize;
    }
}
