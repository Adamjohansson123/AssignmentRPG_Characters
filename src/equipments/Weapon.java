package equipments;

import characters.PrimaryAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Weapon extends Item {

    private WeaponType weaponType;
    private double damage;
    private double attackSpeed;

    public Weapon(){
        this.setName(randomName());
        this.setSlot(Slot.Weapon);
        this.setLevelRequirement(1);
        this.damage = 7;
        this.attackSpeed = 1.1;
        this.weaponType = WeaponType.Axe;
        this.setAttributes(new PrimaryAttributes(0,0,0,0));
    } //Creates a default weapon

    public Weapon(int level){
        this.setName(randomName());
        this.setSlot(Slot.Weapon);
        this.setLevelRequirement(level);
        this.damage = 7;
        this.attackSpeed = 1.1;
        this.weaponType = WeaponType.Axe;
        this.setAttributes(new PrimaryAttributes(0,0,0,0));
    } //Creates a new weapon by taking level as a argument

    public Weapon(WeaponType weaponType){
        this.setName(randomName());
        this.setSlot(Slot.Weapon);
        this.setLevelRequirement(1);
        this.damage = 7;
        this.attackSpeed = 1.1;
        this.weaponType = weaponType;
        this.setAttributes(new PrimaryAttributes(0,0,0,0));
    } //Creates a new weapon by taking weaponType as a argument

    public String randomName() {
        Random rand = new Random();
        List<String> nameList = new ArrayList<String>();
        nameList.add("Common axe");
        nameList.add("Dragon axe");
        nameList.add("Godly axe");

        String randomName = "";

        for (int i = 0; i < nameList.size(); i++) {
            int randomIndex = rand.nextInt(nameList.size());
            randomName = nameList.get(randomIndex);
        }

        return randomName;
    } //Gives the new weapon a randomized name

    public WeaponType getWeaponType() {
        return this.weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public double getDPS(){
        return this.attackSpeed * this.damage;
    }
}
