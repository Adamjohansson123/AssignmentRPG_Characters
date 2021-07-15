package characters;

import equipments.Slot;
import equipments.Weapon;

public class Warrior extends HeroCharacter {

    public Warrior(){
        this.setHeroType(HeroType.Warrior);
        this.setName(randomName());
        this.setLevel(1);
        this.basePrimaryAttributes = new PrimaryAttributes(5,2,1,10);
        this.secondaryAttributes = new SecondaryAttributes(0,0,0);
        setPrimaryTotalAttributes();
    } //Creates a default warrior

    @Override
    public void setDefaultAttributes(){

    }

    @Override
    void levelUpAttributes(){
        this.basePrimaryAttributes.setStrength(this.basePrimaryAttributes.getStrength() + 3);
        this.basePrimaryAttributes.setDexterity(this.basePrimaryAttributes.getDexterity() + 2);
        this.basePrimaryAttributes.setIntelligence(this.basePrimaryAttributes.getIntelligence() + 1);
        this.basePrimaryAttributes.setVitality(this.basePrimaryAttributes.getVitality() + 5);
    } //Levels up attributes for warrior

    @Override
    public double getDPS() {
        double weaponDPS = 1.0;
        if(this.equippedEquipments.get(Slot.Weapon) != null){
            weaponDPS = ((Weapon)this.equippedEquipments.get(Slot.Weapon)).getDPS();
        }

        double characterDPS = weaponDPS * (1 + ((double)this.totalPrimaryAttributes.getStrength() / 100));
        return Math.round(characterDPS * 100) / 100;
    } //Method for getting character DPS

}
