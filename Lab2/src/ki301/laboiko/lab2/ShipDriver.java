package ki301.laboiko.lab2;

import java.io.IOException;


/**
 * Клас ShipDriver використовується для демонстрації роботи класу Ship.
 * У цьому класі створюється об'єкт корабля і викликаються різні методи для керування ним.
 */
public class ShipDriver {
    /**
     * Точка входу в програму. Демонструє роботу з телевізором шляхом виклику різних методів.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        try {
            Ship ship = new Ship(
                    new Engine(false, 0, 1000),
                    new Hull(70),
                    new NavigationSystem(20, 0, "2.0"),
                    "Темний Клик"
            );

            ship.startEngine();
            ship.changeCourse(10);
            ship.changeSpeed(50);
            ship.checkHullStatus();
            ship.updateNavigationSystem();
            ship.refuel(100);
            ship.performMaintenance();
            ship.calculateArrivalTime(10);
            ship.simulateWeatherConditions("шторм");
            ship.stopEngine();

            ship.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}
