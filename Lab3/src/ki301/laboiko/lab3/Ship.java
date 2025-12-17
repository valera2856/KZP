package ki301.laboiko.lab3;

import java.io.IOException;
import java.util.Random;
/**
 * Клас, що представляє корабель з двигуном, корпусом та навігаційною системою.
 * Забезпечує управління основними функціями корабля.
 */
public abstract class Ship {
    protected Engine engine;
    protected Hull hull;
    protected NavigationSystem navigationSystem;
    protected Logger logger;
    protected String name;

    /**
     * Створює новий об'єкт корабля з заданим ім'ям.
     * @param name Ім'я корабля
     * @throws IOException якщо виникає помилка під час створення логера
     */
    public Ship(String name) throws IOException {
        this.name = name;
        this.engine = new Engine();
        this.hull = new Hull();
        this.navigationSystem = new NavigationSystem();

        this.logger = new Logger("ship_log.txt");
        logger.log(String.format("Корабель %s створено.", this.toString()));
    }

    /**
     * Створює новий об'єкт корабля з параметрами двигуна, корпусу та навігаційної системи.
     * @param engine Двигун корабля
     * @param hull Корпус корабля
     * @param navigationSystem Навігаційна система
     * @param name Ім'я корабля
     * @throws IOException якщо виникає помилка під час створення логера
     */
    public Ship(Engine engine, Hull hull, NavigationSystem navigationSystem, String name) throws IOException {
        this.engine = engine;
        this.hull = hull;
        this.navigationSystem = navigationSystem;
        this.name = name;

        this.logger = new Logger("ship_log.txt");
        logger.log(String.format("Корабель %s створено.", this.toString()));
    }

    /**
     * Абстрактний метод для виконання специфічних дій корабля.
     * @throws IOException якщо виникає помилка під час запису до логера
     */
    public abstract void performSpecificAction() throws IOException;

    /**
     * Метод для запуску двигуна корабля.
     * @throws IOException якщо виникає помилка під час запису до логера
     */
    public void startEngine() throws IOException {
        engine.start();
        logger.log(String.format("Двигун корабля %s запущено", name));
        System.out.printf("Двигун корабля %s запущено\n", name);
    }

    /**
     * Метод для зупинки двигуна корабля.
     * @throws IOException якщо виникає помилка під час запису до логера
     */
    public void stopEngine() throws IOException {
        engine.stop();
        logger.log(String.format("Двигун корабля %s зупинено", name));
        System.out.printf("Двигун корабля %s зупинено\n", name);
    }

    /**
     * Метод для встановлення курсу корабля.
     * @param course Курс корабля
     * @throws IOException якщо виникає помилка під час запису до логера
     */
    public void changeCourse(int course) throws IOException {
        navigationSystem.setCourse(course);
        logger.log(String.format("Встановлено курс %s для корабля %s", course, name));
        System.out.printf("Встановлено курс %s для корабля %s\n", course, name);
    }

    /**
     * Метод для зміни швидкості корабля.
     * @param speed Нова швидкість
     * @throws IOException якщо виникає помилка під час запису до логера
     */
    public void changeSpeed(int speed) throws IOException {
        engine.setSpeed(speed);
        logger.log(String.format("Змінено швидкість корабля %s на %s", name, speed));
        System.out.printf("Змінено швидкість корабля %s на %s\n", name, speed);
    }

    /**
     * Метод для перевірки стану корпусу.
     * @return Стан корпусу
     * @throws IOException якщо виникає помилка під час запису до логера
     */
    public String checkHullStatus() throws IOException {
        String status = hull.checkStatus();
        logger.log(String.format("Перевірено стан корпусу корабля %s : %s", name, status));
        System.out.printf("Перевірено стан корпусу корабля %s : %s\n", name, status);
        return status;
    }

    /**
     * Метод для оновлення навігаційної системи.
     * @throws IOException якщо виникає помилка під час запису до логера
     */
    public void updateNavigationSystem() throws IOException {
        navigationSystem.update();
        logger.log(String.format("Оновлено навігаційну систему корабля %s", name));
        System.out.printf("Оновлено навігаційну систему корабля %s\n", name);
    }

    /**
     * Метод для дозаправки корабля.
     * @param amount Кількість палива
     * @throws IOException якщо виникає помилка під час запису до логера
     */
    public void refuel(int amount) throws IOException {
        engine.refuel(amount);
        logger.log(String.format("Дозаправлено корабель %s на %s літрів", name, amount));
        System.out.printf("Дозаправлено корабель %s на %s літрів\n", name, amount);
    }

    /**
     * Метод для проведення технічного обслуговування корабля.
     * @return Результат технічного обслуговування
     * @throws IOException якщо виникає помилка під час запису до логера
     */
    public String performMaintenance() throws IOException {
        Random random = new Random();
        int maintenanceQuality = random.nextInt(100) + 1;
        String result;

        if (maintenanceQuality > 80) {
            result = "Відмінне технічне обслуговування";
            hull.improveCondition(10);
        } else if (maintenanceQuality > 60) {
            result = "Добре технічне обслуговування";
            hull.improveCondition(5);
        } else if (maintenanceQuality > 40) {
            result = "Задовільне технічне обслуговування";
            hull.improveCondition(2);
        } else {
            result = "Незадовільне технічне обслуговування";
        }

        logger.log(String.format("Проведено технічне обслуговування корабля %s: %s", name, result));
        System.out.printf("Проведено технічне обслуговування корабля %s: %s\n", name, result);
        return result;
    }

    /**
     * Метод для розрахунку часу прибуття до пункту призначення.
     * @param distance Відстань до пункту призначення в кілометрах
     * @return Час прибуття в годинах
     * @throws IOException якщо виникає помилка під час запису до логера
     */
    public double calculateArrivalTime(double distance) throws IOException {
        int currentSpeed = engine.getSpeed();
        if (currentSpeed == 0) {
            throw new IllegalStateException("Корабель не рухається. Запустіть двигун та встановіть швидкість.");
        }

        double time = distance / currentSpeed;
        logger.log(String.format("Розраховано час прибуття корабля %s: %.2f годин", name, time));
        System.out.printf("Розраховано час прибуття корабля %s: %.2f годин\n", name, time);
        return time;
    }

    /**
     * Метод для симуляції погодних умов та їх впливу на корабель.
     * @param weatherCondition Погодні умови (напр., "шторм", "ясно", "туман")
     * @throws IOException якщо виникає помилка під час запису до логера
     */
    public void simulateWeatherConditions(String weatherCondition) throws IOException {
        switch (weatherCondition.toLowerCase()) {
            case "шторм":
                hull.deteriorateCondition(15);
                engine.setSpeed(engine.getSpeed() / 2);
                logger.log(String.format("Корабель %s потрапив у шторм. Швидкість знижено, стан корпусу погіршився.", name));
                break;
            case "ясно":
                navigationSystem.improveAccuracy(10);
                logger.log(String.format("Ясна погода покращила точність навігації корабля %s.", name));
                break;
            case "туман":
                navigationSystem.reduceAccuracy(20);
                engine.setSpeed(engine.getSpeed() / 3);
                logger.log(String.format("Корабель %s у тумані. Швидкість знижено, точність навігації погіршилась.", name));
                break;
            default:
                logger.log(String.format("Невідомі погодні умови для корабля %s: %s", name, weatherCondition));
        }

        System.out.printf("Симульовано погодні умови для корабля %s: %s\n", name, weatherCondition);
    }

    /**
     * Закриває логер для збереження даних у файл.
     * @throws IOException якщо виникає помилка під час закриття логера
     */
    public void closeLogger() throws IOException {
        logger.close();
    }
}

