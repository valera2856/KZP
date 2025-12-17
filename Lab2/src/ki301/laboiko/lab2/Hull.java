package ki301.laboiko.lab2;

/**
 * Клас Hull представляє корпус корабля та його стан.
 * Дозволяє перевіряти стан корпусу, погіршувати чи покращувати його,
 * а також отримувати інформацію про поточний стан.
 */
public class Hull {
    private int condition;

    /**
     * Створює корпус корабля з початковим станом 100%.
     */
    public Hull() {
        condition = 100;
    }

    /**
     * Створює корпус корабля з заданим початковим станом.
     * @param condition Початковий стан корпусу (у відсотках)
     */
    public Hull(int condition) {
        this.condition = condition;
    }

    /**
     * Перевіряє поточний стан корпусу та повертає описовий статус.
     * @return Статус корпусу у вигляді рядка
     */
    public String checkStatus() {
        if (condition > 90) return "Відмінний";
        if (condition > 70) return "Добрий";
        if (condition > 50) return "Задовільний";
        if (condition > 30) return "Поганий";
        return "Критичний";
    }

    /**
     * Погіршує стан корпусу на вказану кількість одиниць, але не менше 0.
     * @param amount Кількість одиниць для погіршення стану
     */
    public void deteriorateCondition(int amount) {
        this.condition = Math.max(0, this.condition - amount);
    }

    /**
     * Покращує стан корпусу на вказану кількість одиниць, але не більше 100.
     * @param amount Кількість одиниць для покращення стану
     */
    public void improveCondition(int amount) {
        this.condition = Math.min(100, this.condition + amount);
    }

    /**
     * Повертає інформацію про поточний стан корпусу у відсотках.
     * @return Інформація про стан корпусу у вигляді рядка
     */
    public String getInfo() {
        return "Стан корпусу: " + condition + "%";
    }
}
