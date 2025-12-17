package ki301.laboiko.lab3;

import java.io.IOException;

/**
 * Клас Frigate представляє фрегат - тип військового корабля,
 * що може відкривати вогонь та активувати оборонні системи.
 */
public class Frigate extends Ship implements WarShip {
    private boolean weaponSystemActive;
    private boolean defensiveSystemActive;

    /**
     * Конструктор для створення фрегата.
     * @param name Ім'я фрегата
     * @throws IOException якщо виникає помилка під час створення логера
     */
    public Frigate(String name) throws IOException {
        super(name);
        this.weaponSystemActive = false;
        this.defensiveSystemActive = false;
    }

    /**
     * Виконує постріл, якщо збройні системи активовані.
     *
     * @throws IOException якщо виникає помилка під час стрілянини
     */
    @Override
    public void fireWeapon() throws IOException {
        if (weaponSystemActive) {
            logger.log(String.format("Фрегат %s відкрив вогонь.", name));
            System.out.printf("Фрегат %s відкрив вогонь.\n", name);
        } else {
            logger.log(String.format("Не вдалося відкрити вогонь. Зброя фрегата %s не активована.", name));
            System.out.printf("Не вдалося відкрити вогонь. Зброя фрегата %s не активована.\n", name);
        }
    }

    /**
     * Активує оборонні системи фрегата.
     *
     * @throws IOException якщо виникає помилка під час активації систем
     */
    @Override
    public void activateDefenseSystems() throws IOException {
        defensiveSystemActive = true;
        logger.log(String.format("Активовано оборонні системи фрегата %s.", name));
        System.out.printf("Активовано оборонні системи фрегата %s.\n", name);
    }

    /**
     * Виконує специфічну дію для фрегата - патрулювання.
     *
     * @throws IOException якщо виникає помилка під час виконання дії
     */
    @Override
    public void performSpecificAction() throws IOException {
        logger.log(String.format("Фрегат %s виконує патрулювання.", name));
        System.out.printf("Фрегат %s виконує патрулювання.\n", name);
    }

    /**
     * Метод для активації збройних систем фрегата.
     *
     * @throws IOException якщо виникає помилка під час активації систем
     */
    public void activateWeaponSystems() throws IOException {
        weaponSystemActive = true;
        logger.log(String.format("Активовано збройні системи фрегата %s.", name));
        System.out.printf("Активовано збройні системи фрегата %s.\n", name);
    }
}
