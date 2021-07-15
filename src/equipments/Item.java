package equipments;

import characters.PrimaryAttributes;

public abstract class Item {


    private String name;
    private int levelRequirement;
    private Slot slot;
    private PrimaryAttributes primaryAttributes;

    public PrimaryAttributes getAttributes() {
        return primaryAttributes;
    }

    public void setAttributes(PrimaryAttributes primaryAttributes) {
        this.primaryAttributes = primaryAttributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public void setLevelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
