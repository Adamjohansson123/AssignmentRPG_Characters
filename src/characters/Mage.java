package characters;

import equipments.Slot;
import equipments.Weapon;

public class Mage extends HeroCharacter {

    public Mage(){
        this.setHeroType(HeroType.Mage);
        this.setName(randomName());
        this.setLevel(1);
        this.basePrimaryAttributes = new PrimaryAttributes(1,1,8,5);
        this.secondaryAttributes = new SecondaryAttributes(0,0,0);
        setPrimaryTotalAttributes();
    } //Creates a default mage

    public Mage(HeroType heroType, String name, int level){
        this.setHeroType(heroType);
        this.setName(name);
        this.setLevel(level);
        this.basePrimaryAttributes = new PrimaryAttributes(1,1,8,5);
        this.secondaryAttributes = new SecondaryAttributes(0,0,0);
        setPrimaryTotalAttributes();
    } //Creates a mage by sending heroType, name and level

    public void setDefaultAttributes(){

    }

    public void setSecondaryAttributes() {

    }

    public void levelUpAttributes(){
        this.basePrimaryAttributes.setStrength(this.basePrimaryAttributes.getStrength() + 1);
        this.basePrimaryAttributes.setDexterity(this.basePrimaryAttributes.getDexterity() + 1);
        this.basePrimaryAttributes.setIntelligence(this.basePrimaryAttributes.getIntelligence() + 5);
        this.basePrimaryAttributes.setVitality(this.basePrimaryAttributes.getVitality() + 3);
    } //Levels up attributes for mage

    public double getDPS(){
        double weaponDPS = 1.0;
        if(this.equippedEquipments.get(Slot.Weapon) != null){
            weaponDPS = ((Weapon)this.equippedEquipments.get(Slot.Weapon)).getDPS();
        }

        double characterDPS = weaponDPS * (1 + ((double)this.totalPrimaryAttributes.getIntelligence() / 100));
        return Math.round(characterDPS * 100) / 100;
    } //Method for getting the Character DPS
}
