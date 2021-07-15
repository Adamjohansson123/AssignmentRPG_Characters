package characters;

import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import equipments.*;
import equipments.Item;
import equipments.Slot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public abstract class HeroCharacter {

    private String name;
    private int level;

    private HeroType heroType;
    PrimaryAttributes basePrimaryAttributes;
    PrimaryAttributes totalPrimaryAttributes;
    SecondaryAttributes secondaryAttributes;
    HashMap<Slot, Item> equippedEquipments = new HashMap<Slot, Item>();

    public String randomName() { //Gives the new hero a randomized name
        Random rand = new Random();
        List<String> nameList = new ArrayList<String>();
        nameList.add("Shrek");
        nameList.add("Ralph");
        nameList.add("Igor");

        String randomName = "";

        for (int i = 0; i < nameList.size(); i++) {
            int randomIndex = rand.nextInt(nameList.size());
            randomName = nameList.get(randomIndex);
        }

        return randomName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setHeroType(HeroType heroType) {
        this.heroType = heroType;
    }

    public void setPrimaryTotalAttributes() {
        PrimaryAttributes primaryAttributes = basePrimaryAttributes;
        if(equippedEquipments.containsKey(Slot.Weapon)){
            primaryAttributes.addDexterity(equippedEquipments.get(Slot.Weapon).getAttributes().getDexterity());
            primaryAttributes.addStrength(equippedEquipments.get(Slot.Weapon).getAttributes().getStrength());
            primaryAttributes.addIntelligence(equippedEquipments.get(Slot.Weapon).getAttributes().getIntelligence());
            primaryAttributes.addVitality(equippedEquipments.get(Slot.Weapon).getAttributes().getVitality());
        }
        if(equippedEquipments.containsKey(Slot.Head)){
            primaryAttributes.addDexterity(equippedEquipments.get(Slot.Head).getAttributes().getDexterity());
            primaryAttributes.addStrength(equippedEquipments.get(Slot.Head).getAttributes().getStrength());
            primaryAttributes.addIntelligence(equippedEquipments.get(Slot.Head).getAttributes().getIntelligence());
            primaryAttributes.addVitality(equippedEquipments.get(Slot.Head).getAttributes().getVitality());
        }
        if(equippedEquipments.containsKey(Slot.Body)){
            primaryAttributes.addDexterity(equippedEquipments.get(Slot.Body).getAttributes().getDexterity());
            primaryAttributes.addStrength(equippedEquipments.get(Slot.Body).getAttributes().getStrength());
            primaryAttributes.addIntelligence(equippedEquipments.get(Slot.Body).getAttributes().getIntelligence());
            primaryAttributes.addVitality(equippedEquipments.get(Slot.Body).getAttributes().getVitality());
        }
        if(equippedEquipments.containsKey(Slot.Legs)){
            primaryAttributes.addDexterity(equippedEquipments.get(Slot.Legs).getAttributes().getDexterity());
            primaryAttributes.addStrength(equippedEquipments.get(Slot.Legs).getAttributes().getStrength());
            primaryAttributes.addIntelligence(equippedEquipments.get(Slot.Legs).getAttributes().getIntelligence());
            primaryAttributes.addVitality(equippedEquipments.get(Slot.Legs).getAttributes().getVitality());
        }
        this.totalPrimaryAttributes = primaryAttributes;
        setSecondaryAttributes();
    } //Method for setting the total primary attributes. Gets all the equipments from each slot.

    public PrimaryAttributes getBasePrimaryAttributes() {
        return this.basePrimaryAttributes;
    }

    public void setSecondaryAttributes() {
        int armorRating = 0;
        if(equippedEquipments.containsKey(Slot.Body)){
            armorRating += ((Armor) equippedEquipments.get(Slot.Body)).getArmorRating();
        }
        if(equippedEquipments.containsKey(Slot.Head)){
            armorRating += ((Armor) equippedEquipments.get(Slot.Body)).getArmorRating();
        }
        if(equippedEquipments.containsKey(Slot.Legs)){
            armorRating += ((Armor) equippedEquipments.get(Slot.Body)).getArmorRating();
        }

        this.secondaryAttributes.setArmorRating(armorRating + this.totalPrimaryAttributes.getDexterity() + this.totalPrimaryAttributes.getStrength());
        this.secondaryAttributes.setHealth(this.totalPrimaryAttributes.getVitality() * 10);
        this.secondaryAttributes.setElementalResistance(this.totalPrimaryAttributes.getIntelligence());
    } //Method for setting the secondary attributes.

    public SecondaryAttributes getSecondaryAttributes() {
        return secondaryAttributes;
    }

    public void levelUpCharacter(int levelGain) throws IllegalArgumentException {

        if (levelGain >= 1) {
            this.level += levelGain;
            levelUpAttributes();
            setPrimaryTotalAttributes();
        }
        else {
            throw new IllegalArgumentException(
                    "You can´t level up less than one level"
            );
        }

    } //Method to make hero level up and increase hero attributes.

    abstract void levelUpAttributes(); //Abstract method that subclasses can inherit to level upp hero attributes.

    public abstract double getDPS(); //Abstract getDPS method that classes that inherit HeroCharacter can use.

    public boolean equipItemToHero (Item item) throws InvalidArmorException, InvalidWeaponException {

        if(!item.getSlot().equals(Slot.Weapon)) {
            if(this.getLevel() < item.getLevelRequirement()){
                throw new  InvalidArmorException("You can´t equip this armor");
            }
            if (this.heroType == HeroType.Ranger || this.heroType == HeroType.Rogue && (((Armor) item).getArmorType() != ArmorType.Leather && ((Armor) item).getArmorType() != ArmorType.Mail)) {
                throw new  InvalidArmorException("You can´t equip this armor");
            }
            if (this.heroType == HeroType.Warrior && (((Armor) item).getArmorType() != ArmorType.Plate && ((Armor) item).getArmorType() != ArmorType.Mail)) {
                throw new  InvalidArmorException("You can´t equip this armor");
            }
            if (this.heroType == HeroType.Mage && ((Armor) item).getArmorType() != ArmorType.Cloth) {
                throw new  InvalidArmorException("You can´t equip this armor");
            }
        }
        else if (item.getSlot().equals(Slot.Weapon)){
            if(this.getLevel() < item.getLevelRequirement()){
                throw new  InvalidWeaponException("You can´t equip this weapon");
            }
            if (this.heroType == HeroType.Ranger && (((Weapon) item).getWeaponType() != WeaponType.Bow)) {
                throw new InvalidWeaponException("You can´t equip this weapon");
            }
            if (this.heroType == HeroType.Rogue && (((Weapon) item).getWeaponType() != WeaponType.Dagger && ((Weapon) item).getWeaponType() != WeaponType.Sword)) {
                throw new InvalidWeaponException("You can´t equip this weapon");
            }
            if (this.heroType == HeroType.Warrior && (((Weapon) item).getWeaponType() != WeaponType.Hammer && ((Weapon) item).getWeaponType() != WeaponType.Sword) && ((Weapon) item).getWeaponType() != WeaponType.Axe) {
                throw new InvalidWeaponException("You can´t equip this weapon");
            }
            if (this.heroType == HeroType.Mage && (((Weapon) item).getWeaponType() != WeaponType.Sword && ((Weapon) item).getWeaponType() != WeaponType.Wand)) {
                throw new InvalidWeaponException("You can´t equip this weapon");
            }

        }

        this.equippedEquipments.put(item.getSlot(), item);
        setPrimaryTotalAttributes();
        return true;
    } //Method that equips item to character.
    //Checks if item is a weapon or a armor. If it´s not a weapon then it´s a armor

    public int getTotalPrimaryAttributes(){
        return this.totalPrimaryAttributes.getVitality() + this.totalPrimaryAttributes.getStrength() + this.totalPrimaryAttributes.getDexterity() + this.totalPrimaryAttributes.getIntelligence();
    }

    public void printHeroStats(){
        System.out.println("Name: " + this.name);
        System.out.println("Level: " + this.level);
        System.out.println("Strength: " + this.totalPrimaryAttributes.getStrength());
        System.out.println("Dexterity: " + this.totalPrimaryAttributes.getDexterity());
        System.out.println("Intelligence: " + this.totalPrimaryAttributes.getIntelligence());
        System.out.println("Health: " + this.secondaryAttributes.getHealth());
        System.out.println("Armor Rating: " + this.secondaryAttributes.getArmorRating());
        System.out.println("Elemental Resistance: " + this.secondaryAttributes.getElementalResistance());
        System.out.println("DPS: " + this.getDPS());

    } //Prints out the stats for the hero

}
