import characters.Warrior;
import equipments.Weapon;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;

public class Program {
    public static void main(String[] args) throws InvalidArmorException, InvalidWeaponException {
        Warrior newWarrior = new Warrior();

        Weapon newWeapon = new Weapon();

        newWarrior.equipItemToHero(newWeapon);

        newWarrior.printHeroStats();
    }
}
