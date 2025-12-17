package ki301.laboiko.lab6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Параметризований клас, що реалізує вагон для перевезення
 * @param <T> тип об'єктів, що перевозяться у вагоні
 */
public class RailCar<T> {
    private List<T> contents;
    private final int capacity;
    private final String type;
    private final int carNumber;

    /**
     * Конструктор класу RailCar
     * @param capacity максимальна місткість вагона
     * @param type тип вагона
     * @param carNumber номер вагону
     */
    public RailCar(int capacity, String type, int carNumber) {
        this.contents = new ArrayList<>();
        this.capacity = capacity;
        this.type = type;
        this.carNumber = carNumber;
    }

    /**
     * Додає об'єкт до вагону
     * @param item об'єкт для додавання
     * @return true якщо об'єкт додано успішно, false якщо вагон заповнений
     */
    public boolean loadItem(T item) {
        if (contents.size() < capacity) {
            return contents.add(item);
        }
        return false;
    }

    /**
     * Видаляє об'єкт з вагону
     * @param item об'єкт для видалення
     * @return true якщо об'єкт видалено успішно
     */
    public boolean unloadItem(T item) {
        return contents.remove(item);
    }

    /**
     * Знаходить максимальний елемент у вагоні за заданим компаратором
     * @param comparator компаратор для порівняння елементів
     * @return максимальний елемент або null якщо вагон порожній
     */
    public T findMaxElement(Comparator<T> comparator) {
        if (contents.isEmpty()) {
            return null;
        }
        return Collections.max(contents, comparator);
    }

    /**
     * Перевіряє наявність вільного місця у вагоні
     * @return true якщо є вільне місце
     */
    public boolean hasSpace() {
        return contents.size() < capacity;
    }

    /**
     * Повертає поточну кількість об'єктів у вагоні
     * @return кількість об'єктів
     */
    public int getCurrentLoad() {
        return contents.size();
    }

    /**
     * Повертає номер вагона
     * @return номер вагону
     */
    public int getCarNumber() {
        return carNumber;
    }

    /**
     * Очищає вагон
     */
    public void clear() {
        contents.clear();
    }

    /**
     * Повертає список всіх об'єктів у вагоні
     * @return список об'єктів
     */
    public List<T> getAllContents() {
        return new ArrayList<>(contents);
    }
}

