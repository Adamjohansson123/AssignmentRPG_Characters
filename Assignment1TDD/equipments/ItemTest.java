package equipments;

import characters.Warrior;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void equipItemToHero_higherWeaponRequiredLevelThanHeroLevel_InvalidWeaponException() {
        Warrior newWarrior = new Warrior();

        Weapon newWeapon = new Weapon(2);

        assertThrows(InvalidWeaponException.class, () -> {
            newWarrior.equipItemToHero(newWeapon);
        } );
    }

    @Test
    void equipItemToHero_higherArmorRequiredLevelThanHeroLevel_InvalidArmorException() {
        Warrior newWarrior = new Warrior();

        Armor testPlateBody = new Armor(2);

        assertThrows(InvalidArmorException.class, () -> {
            newWarrior.equipItemToHero(testPlateBody);
        } );
    }

    @Test
    void equipItemToHero_heroEquipWrongWeaponType_InvalidWeaponException() {
        Warrior newWarrior = new Warrior();

        Weapon testBow = new Weapon(WeaponType.Bow);

        assertThrows(InvalidWeaponException.class, () -> {
            newWarrior.equipItemToHero(testBow);
        } );
    }

    @Test
    void equipItemToHero_heroEquipWrongArmorType_InvalidArmorException() {
        Warrior newWarrior = new Warrior();

        Armor testClothHead = new Armor(ArmorType.Cloth);

        assertThrows(InvalidArmorException.class, () -> {
            newWarrior.equipItemToHero(testClothHead);
        } );
    }

    @Test
    void equipItemToHero_heroEquipValidWeaponType_True() throws InvalidWeaponException, InvalidArmorException {
        Warrior newWarrior = new Warrior();

        Weapon testWeapon = new Weapon();

        assertTrue(newWarrior.equipItemToHero(testWeapon));
    }

    @Test
    void equipItemToHero_heroEquipValidArmorType_True() throws InvalidArmorException, InvalidWeaponException {
        Warrior newWarrior = new Warrior();

        Armor testClothHead = new Armor();

        assertTrue(newWarrior.equipItemToHero(testClothHead));
    }

    @Test
    void getDPS_noWeaponEquipped_DPSEqualsExpectedDPS() {
        Warrior newWarrior = new Warrior();

        var expectedDPS =  1*(1 + (5 / 100));

        assertEquals(expectedDPS, newWarrior.getDPS());

    }

    @Test
    void getDPS_validWeaponEquipped_DPSEqualsExpectedDPS() throws InvalidArmorException, InvalidWeaponException {
        Warrior newWarrior = new Warrior();

        Weapon testWeaponAxe = new Weapon();

        newWarrior.equipItemToHero(testWeaponAxe);

        var expectedDPS = Math.round(((7 * 1.1) * (1 + ((5) / 100)) * 100) / 100 );

        assertEquals(expectedDPS, newWarrior.getDPS());
    }

    @Test
    void getDPS_validWeaponAndArmorEquipped_DPSEqualsExpectedDPS() throws InvalidArmorException, InvalidWeaponException {
        Warrior newWarrior = new Warrior();

        Weapon testWeapon = new Weapon();

        Armor testBodyPlate = new Armor();

        newWarrior.equipItemToHero(testWeapon);

        newWarrior.equipItemToHero(testBodyPlate);

        var expectedDPS = Math.round(((7 * 1.1) * (1 + ((5+1) / 100)) * 100) / 100 );

        assertEquals(expectedDPS, newWarrior.getDPS());
    }


}