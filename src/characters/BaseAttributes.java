package characters;

public class BaseAttributes {
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int vitality;

    public BaseAttributes() {

    }

    public BaseAttributes(int strength, int dexterity, int intelligence, int vitality) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.vitality = vitality;
    }

    @Override
    public String toString() {
        return "Strength: " + strength +
                "\nDexterity: " + dexterity +
                "\nIntelligence: " + intelligence +
                "\nVitality: " + vitality;
    }
}
