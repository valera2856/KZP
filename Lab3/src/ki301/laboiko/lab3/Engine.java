package ki301.laboiko.lab3;

/**
 * Клас Engine представляє двигун корабля.
 * Дозволяє керувати станом двигуна, швидкістю та рівнем палива.
 */
public class Engine {
    private boolean isRunning;
    private int speed;
    private int fuelLevel;

    /**
     * Конструктор за замовчуванням, який створює двигун із вимкненим станом,
     * початковою швидкістю 0 та рівнем палива 100.
     */
    public Engine() {
        isRunning = false;
        speed = 0;
        fuelLevel = 100;
    }

    /**
     * Конструктор для створення двигуна з вказаним початковим станом.
     * @param isRunning Чи працює двигун
     * @param speed Початкова швидкість
     * @param fuelLevel Початковий рівень палива
     */
    public Engine(boolean isRunning, int speed, int fuelLevel) {
        this.isRunning = isRunning;
        this.speed = speed;
        this.fuelLevel = fuelLevel;
    }

    /**
     * Запускає двигун.
     */
    public void start() {
        isRunning = true;
    }

    /**
     * Зупиняє двигун і скидає швидкість до 0.
     */
    public void stop() {
        isRunning = false;
        speed = 0;
    }

    /**
     * Повертає поточну швидкість двигуна.
     * @return Швидкість
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Встановлює нову швидкість для двигуна.
     * @param speed Нова швидкість
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Дозаправляє двигун на вказану кількість одиниць палива.
     * @param amount Кількість палива
     */
    public void refuel(int amount) {
        fuelLevel += amount;
    }

    /**
     * Повертає інформацію про поточний стан двигуна, швидкість та рівень палива.
     * @return Інформація про двигун у вигляді рядка
     */
    public String getInfo() {
        return "Стан: " + (isRunning ? "працює" : "зупинено") +
                ", Швидкість: " + speed +
                ", Рівень палива: " + fuelLevel;
    }
}
