package ki301.laboiko.lab2;

/**
 * Клас NavigationSystem представляє навігаційну систему корабля.
 * Він дозволяє встановлювати курс, підвищувати або знижувати точність навігації,
 * оновлювати програмне забезпечення та отримувати інформацію про стан системи.
 */
public class NavigationSystem {
    private int course;
    private int accuracy;
    private String softwareVersion;

    /**
     * Створює нову навігаційну систему з початковими значеннями.
     * Курс встановлено на 0, точність на 0, версія ПЗ — "1.0".
     */
    public NavigationSystem() {
        this.course = 0;
        this.accuracy = 0;
        this.softwareVersion = "1.0";
    }

    /**
     * Створює нову навігаційну систему з заданими параметрами.
     * @param course Курс корабля
     * @param accuracy Точність навігації
     * @param softwareVersion Версія програмного забезпечення
     */
    public NavigationSystem(int course, int accuracy, String softwareVersion) {
        this.course = course;
        this.accuracy = accuracy;
        this.softwareVersion = softwareVersion;
    }

    /**
     * Підвищує точність навігації на задану кількість одиниць, не перевищуючи 100.
     * @param amount Кількість одиниць для підвищення точності
     */
    public void improveAccuracy(int amount) {
        this.accuracy = Math.min(100, this.accuracy + amount);
    }

    /**
     * Знижує точність навігації на задану кількість одиниць, але не менше 0.
     * @param amount Кількість одиниць для зниження точності
     */
    public void reduceAccuracy(int amount) {
        this.accuracy = Math.max(0, this.accuracy - amount);
    }

    /**
     * Встановлює новий курс корабля.
     * @param course Новий курс
     */
    public void setCourse(int course) {
        this.course = course;
    }

    /**
     * Оновлює програмне забезпечення навігаційної системи до версії "1.1".
     */
    public void update() {
        softwareVersion = "1.1";
    }

    /**
     * Повертає інформацію про поточний курс і версію програмного забезпечення.
     * @return Інформація у вигляді рядка
     */
    public String getInfo() {
        return "Курс: " + course + ", Версія ПЗ: " + softwareVersion;
    }
}
