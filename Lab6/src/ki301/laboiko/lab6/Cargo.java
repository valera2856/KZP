package ki301.laboiko.lab6;

/**
 * Клас, що представляє вантаж
 */
class Cargo implements Comparable<Cargo> {
    private String description;
    private double weight;
    private int priority;

    /**
     * Конструктор класу Cargo
     * @param description опис вантажу
     * @param weight вага вантажу
     * @param priority пріоритет вантажу
     */
    public Cargo(String description, double weight, int priority) {
        this.description = description;
        this.weight = weight;
        this.priority = priority;
    }

    public double getWeight() {
        return weight;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Cargo{description='" + description + "', weight=" + weight +
                ", priority=" + priority + "}";
    }

    @Override
    public int compareTo(Cargo other) {
        return Integer.compare(this.priority, other.priority);
    }
}
