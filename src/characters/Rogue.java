package characters;

import equipments.Slot;
import equipments.Weapon;

public class Rogue extends HeroCharacter {

    public Rogue(){
        this.setHeroType(HeroType.Rogue);
        this.setName(randomName());
        this.setLevel(1);
        this.basePrimaryAttributes = new PrimaryAttributes(2,6,1,8);
        this.secondaryAttributes = new SecondaryAttributes(0,0,0);
        setPrimaryTotalAttributes();
    } //Creates a default rogue

    public Rogue(HeroType heroType, String name, int level){
        this.setHeroType(heroType);
        this.setName(name);
        this.setLevel(level);
        this.basePrimaryAttributes = new PrimaryAttributes(1,1,8,5);
        this.secondaryAttributes = new SecondaryAttributes(0,0,0);
        setPrimaryTotalAttributes();
    } //Creates a rogue by sending heroType, name and level

    @Override
    public void setDefaultAttributes(){

    }

    @Override
    void levelUpAttributes(){
        this.basePrimaryAttributes.setStrength(this.basePrimaryAttributes.getStrength() + 1);
        this.basePrimaryAttributes.setDexterity(this.basePrimaryAttributes.getDexterity() + 4);
        this.basePrimaryAttributes.setIntelligence(this.basePrimaryAttributes.getIntelligence() + 1);
        this.basePrimaryAttributes.setVitality(this.basePrimaryAttributes.getVitality() + 3);
    } //Levels up attributes for rogue

    @Override
    public double getDPS() {
        double weaponDPS = 1.0;
        if(this.equippedEquipments.get(Slot.Weapon) != null){
            weaponDPS = ((Weapon)this.equippedEquipments.get(Slot.Weapon)).getDPS();
        }

        double characterDPS = weaponDPS * (1 + ((double)this.totalPrimaryAttributes.getDexterity() / 100));
        return Math.round(characterDPS * 100) / 100;
    } //Method for getting the Character DPS
}
