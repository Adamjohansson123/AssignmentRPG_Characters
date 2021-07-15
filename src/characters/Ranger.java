package characters;

import equipments.Slot;
import equipments.Weapon;

public class Ranger extends HeroCharacter {

    public Ranger(){
        this.setHeroType(HeroType.Ranger);
        this.setName(randomName());
        this.setLevel(1);
        this.basePrimaryAttributes = new PrimaryAttributes(1,7,1,8);
        this.secondaryAttributes = new SecondaryAttributes(0,0,0);
        setPrimaryTotalAttributes();
    } //Creates a default ranger

    public Ranger(HeroType heroType, String name, int level){
        this.setHeroType(heroType);
        this.setName(name);
        this.setLevel(level);
        this.basePrimaryAttributes = new PrimaryAttributes(1,1,8,5);
        this.secondaryAttributes = new SecondaryAttributes(0,0,0);
        setPrimaryTotalAttributes();
    } //Creates a ranger by sending heroType, name and level

    @Override
    void levelUpAttributes(){
        this.basePrimaryAttributes.setStrength(this.basePrimaryAttributes.getStrength() + 1);
        this.basePrimaryAttributes.setDexterity(this.basePrimaryAttributes.getDexterity() + 5);
        this.basePrimaryAttributes.setIntelligence(this.basePrimaryAttributes.getIntelligence() + 1);
        this.basePrimaryAttributes.setVitality(this.basePrimaryAttributes.getVitality() + 2);
    } //Levels up attributes for ranger

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
