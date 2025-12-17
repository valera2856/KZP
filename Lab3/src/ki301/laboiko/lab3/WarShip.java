package ki301.laboiko.lab3;

import java.io.IOException;

/**
 * Інтерфейс WarShip визначає базову функціональність військових кораблів,
 * включаючи стрілянину з озброєння та активацію систем захисту.
 */
public interface WarShip {

    /**
     * Виконує постріл з озброєння корабля.
     *
     * @throws IOException якщо виникає помилка під час стрілянини
     */
    void fireWeapon() throws IOException;

    /**
     * Активує системи захисту корабля.
     *
     * @throws IOException якщо виникає помилка під час активації систем захисту
     */
    void activateDefenseSystems() throws IOException;
}

