package dnd.Model;

import java.util.Random;
import javax.swing.DefaultListModel;

public class Npc extends Personagem{
    public DefaultListModel pericias;
    int ac, hpMax, hitDices, hitDicesSize;
    Random random;
    boolean morto;
    
    public Npc(String INnome, EnumRaca INraca, DefaultListModel INpericias, 
            int INhp, int INac, int INhitDices, int INhitDicesSize, int INstr, 
            int INcon, int INdex, int INitl, int INwis, int INcha){
        super(INnome, INraca, INstr, INcon, INdex, INitl, INwis, INcha);
        this.pericias = INpericias;
        this.hp = this.hpMax = INhp + Personagem.getMod(INcon);
        this.ac = INac;
        this.random = new Random();
        this.morto = false;
        this.hitDices = INhitDices;
        this.hitDicesSize = INhitDicesSize;
    }
    
    @Override
    public int getAC(){
        return this.ac;
    }
    
    @Override
    public int getHpMax(){
        return this.hpMax;
    }
    
    @Override
    public int dieRollBonus(){
        return Personagem.getMod(this.str);
    }
    
    @Override
    public int getHitDices(){
        return this.hitDices;
    }
    
    @Override
    public int getHitDicesSize(){
        return this.hitDicesSize;
    }
    
    @Override
    public void tookDamage(int damage){
        hp -= damage;
        if(hp <= 0){
            hp = 0;
            morto = true;
        }
    }
    
    @Override
    public int getDamageBonus(){
        return Personagem.getMod(this.str);
    }
    
    @Override
    public void cura(int valor){
        this.hp += valor;
        if(this.hp > this.getHpMax())
            this.hp = this.getHpMax();
        if(this.morto)
            this.morto = false;
    }
    
    @Override
    public String toString(){
        if(morto)
            return this.nome + " (morto)";
        else
            return this.nome + " (" + this.hp + "/" + this.getHpMax() + " HP)";
    }
    
}
