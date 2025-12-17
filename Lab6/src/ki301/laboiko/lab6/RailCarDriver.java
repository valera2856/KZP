package ki301.laboiko.lab6;

/**
 * Клас-драйвер для демонстрації роботи класу RailCar
 */
public class RailCarDriver {
    public static void main(String[] args) {
        // Створюємо пасажирський вагон
        RailCar<Passenger> passengerCar = new RailCar<>(50, "Passenger", 1234);

        // Додаємо пасажирів
        passengerCar.loadItem(new Passenger("John Doe", 101, 15));
        passengerCar.loadItem(new Passenger("Jane Smith", 102, 23));
        passengerCar.loadItem(new Passenger("Bob Johnson", 103, 7));

        // Знаходимо пасажира з найбільшим номером місця
        Passenger maxSeatPassenger = passengerCar.findMaxElement(Passenger::compareTo);
        System.out.println("Пасажир з найбільшим номером місця: " + maxSeatPassenger);

        // Створюємо вантажний вагон
        RailCar<Cargo> cargoCar = new RailCar<>(100, "Cargo", 5678);

        // Додаємо вантажі
        cargoCar.loadItem(new Cargo("Electronics", 500.0, 1));
        cargoCar.loadItem(new Cargo("Food supplies", 1000.0, 3));
        cargoCar.loadItem(new Cargo("Medical supplies", 750.0, 2));

        // Знаходимо вантаж з найвищим пріоритетом
        Cargo maxPriorityCargo = cargoCar.findMaxElement(Cargo::compareTo);
        System.out.println("Вантаж з найвищим пріоритетом: " + maxPriorityCargo);

        // Демонструємо інші методи
        System.out.println("Кількість пасажирів у вагоні: " + passengerCar.getCurrentLoad());
        System.out.println("Наявність вільних місць у пасажирському вагоні: " +
                passengerCar.hasSpace());

        // Вивантажуємо вантаж
        cargoCar.unloadItem(maxPriorityCargo);
        System.out.println("Кількість вантажів після вивантаження: " +
                cargoCar.getCurrentLoad());
    }
}

