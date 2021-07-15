package equipments;

import characters.PrimaryAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Armor extends Item {

    private ArmorType armorType;
    private int armorRating;

    public Armor() {
        this.setName("Common Plate Body Armor");
        this.setSlot(Slot.Body);
        this.setLevelRequirement(1);
        this.armorType = ArmorType.Plate;
        this.armorRating = 5;
        this.setAttributes(new PrimaryAttributes(1,0,0,2));
    } //Creates a default armor

    public Armor(ArmorType armorType) {
        this.setName("Common Cloth Head Armor");
        this.setSlot(Slot.Head);
        this.setLevelRequirement(1);
        this.armorType = ArmorType.Cloth;
        this.armorRating = 5;
        this.setAttributes(new PrimaryAttributes(1,0,0,2));
    } //Creates a new armor by taking armorType as a argument

    public Armor(int level) {
        this.setName("Common Plate Body Armor");
        this.setSlot(Slot.Body);
        this.setLevelRequirement(level);
        this.armorType = ArmorType.Cloth;
        this.armorRating = 5;
        this.setAttributes(new PrimaryAttributes(1,0,0,2));
    } //Creates a new armor by taking level as a argument

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public int getArmorRating() {
        return armorRating;
    }

    public void setArmorRating(int armorRating) {
        this.armorRating = armorRating;
    }

}
