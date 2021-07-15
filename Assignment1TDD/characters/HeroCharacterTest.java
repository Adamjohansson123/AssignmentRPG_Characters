package characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroCharacterTest {

    @Test
    void setLevel_isHeroStartingLevel_EqualToOne() {
        var newMage = new Mage();

        assertEquals(1, newMage.getLevel());
    }

    @Test
    void levelUpCharacter_isLevelUpOneLevel_EqualToTwo() {
        var newMage = new Mage();

        newMage.levelUpCharacter(1);

        assertEquals(2, newMage.getLevel());
    }

    @Test
    void levelUpCharacter_levelIsLessThanZero_IllegalArgumentException() {
        Mage newMage = new Mage();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            newMage.levelUpCharacter(0);
        } );
    }

    @Test
    void getBasePrimaryAttributes_isMageCreatedWithProperAttributes_GetBasePrimaryAttributesEqualsGetBasePrimaryAttributes() {
        Mage newMage = new Mage();

        var baseAttributes = newMage.getBasePrimaryAttributes();

        assertEquals(1, baseAttributes.getStrength());
        assertEquals(1, baseAttributes.getDexterity());
        assertEquals(8, baseAttributes.getIntelligence());
        assertEquals(5, baseAttributes.getVitality());
    }

    @Test
    void getBasePrimaryAttributes_isRangerCreatedWithProperAttributes_GetBasePrimaryAttributesEqualsGetBasePrimaryAttributes() {
        var newRanger = new Ranger();

        var baseAttributes = newRanger.getBasePrimaryAttributes();

        assertEquals(1, baseAttributes.getStrength());
        assertEquals(7, baseAttributes.getDexterity());
        assertEquals(1, baseAttributes.getIntelligence());
        assertEquals(8, baseAttributes.getVitality());
    }

    @Test
    void getBasePrimaryAttributes_isRogueCreatedWithProperAttributes_GetBasePrimaryAttributesEqualsGetBasePrimaryAttributes() {
        var newRogue = new Rogue();

        var baseAttributes = newRogue.getBasePrimaryAttributes();

        assertEquals(2, baseAttributes.getStrength());
        assertEquals(6, baseAttributes.getDexterity());
        assertEquals(1, baseAttributes.getIntelligence());
        assertEquals(8, baseAttributes.getVitality());
    }

    @Test
    void getBasePrimaryAttributes_isWarriorCreatedWithProperAttributes_GetBasePrimaryAttributesEqualGetBasePrimaryAttributes() {
        var newWarrior = new Warrior();

        var baseAttributes = newWarrior.getBasePrimaryAttributes();

        assertEquals(5, baseAttributes.getStrength());
        assertEquals(2, baseAttributes.getDexterity());
        assertEquals(1, baseAttributes.getIntelligence());
        assertEquals(10, baseAttributes.getVitality());
    }

    @Test
    void getBasePrimaryAttributes_doMageBaseAttributesIncreaseWhenLevelUp_NewPrimaryAttributesEqualsPrimaryAttributes() {
        Mage newMage = new Mage();

        newMage.levelUpCharacter(1);

        var baseAttributes = newMage.getBasePrimaryAttributes();

        assertEquals(2, baseAttributes.getStrength());
        assertEquals(2, baseAttributes.getDexterity());
        assertEquals(13, baseAttributes.getIntelligence());
        assertEquals(8, baseAttributes.getVitality());
    }

    @Test
    void getBasePrimaryAttributes_doRangerBaseAttributesIncreaseWhenLevelUp_NewPrimaryAttributesEqualsPrimaryAttributes() {
        Ranger newRanger = new Ranger();

        newRanger.levelUpCharacter(1);

        var baseAttributes = newRanger.getBasePrimaryAttributes();

        assertEquals(2, baseAttributes.getStrength());
        assertEquals(12, baseAttributes.getDexterity());
        assertEquals(2, baseAttributes.getIntelligence());
        assertEquals(10, baseAttributes.getVitality());
    }

    @Test
    void getBasePrimaryAttributes_doRogueBaseAttributesIncreaseWhenLevelUp_NewPrimaryAttributesEqualsPrimaryAttributes() {
        Rogue newRogue = new Rogue();

        newRogue.levelUpCharacter(1);

        var baseAttributes = newRogue.getBasePrimaryAttributes();

        assertEquals(3, baseAttributes.getStrength());
        assertEquals(10, baseAttributes.getDexterity());
        assertEquals(2, baseAttributes.getIntelligence());
        assertEquals(11, baseAttributes.getVitality());
    }

    @Test
    void getBasePrimaryAttributes_doWarriorBaseAttributesIncreaseWhenLevelUp_NewPrimaryAttributesEqualsPrimaryAttributes() {
        Warrior newWarrior = new Warrior();

        newWarrior.levelUpCharacter(1);

        var baseAttributes = newWarrior.getBasePrimaryAttributes();

        assertEquals(8, baseAttributes.getStrength());
        assertEquals(4, baseAttributes.getDexterity());
        assertEquals(2, baseAttributes.getIntelligence());
        assertEquals(15, baseAttributes.getVitality());
    }

    @Test
    void getBasePrimaryAttributes_doWarriorSecondaryAttributesIncreaseWhenLevelUp_NewSecondaryAttributesEqualsSecondaryAttributes() {
        Warrior newWarrior = new Warrior();

        newWarrior.levelUpCharacter(1);

        var secondaryAttributes = newWarrior.getSecondaryAttributes();

        assertEquals(150, secondaryAttributes.getHealth());
        assertEquals(12, secondaryAttributes.getArmorRating());
        assertEquals(2, secondaryAttributes.getElementalResistance());
    }
}