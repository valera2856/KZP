package ki301.laboiko.lab3;

import java.io.IOException;


/**
 * Клас ShipDriver використовується для демонстрації роботи класу Ship.
 * У цьому класі створюється об'єкт корабля і викликаються різні методи для керування ним.
 */
public class FrigateDriver {
    /**
     * Точка входу в програму. Демонструє роботу з телевізором шляхом виклику різних методів.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        try {
            Frigate frigate = new Frigate("Грізний");

            frigate.startEngine();
            frigate.changeCourse(45);
            frigate.changeSpeed(30);
            frigate.checkHullStatus();
            frigate.updateNavigationSystem();
            frigate.refuel(200);
            frigate.performMaintenance();

            frigate.activateWeaponSystems();
            frigate.fireWeapon();
            frigate.activateDefenseSystems();

            frigate.performSpecificAction();

            frigate.calculateArrivalTime(100);
            frigate.simulateWeatherConditions("шторм");
            frigate.stopEngine();

            frigate.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}

