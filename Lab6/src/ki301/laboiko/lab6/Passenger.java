package ki301.laboiko.lab6;

/**
 * Клас, що представляє пасажира
 */
class Passenger implements Comparable<Passenger> {
    private String name;
    private int ticketNumber;
    private int seatNumber;

    /**
     * Конструктор класу Passenger
     * @param name ім'я пасажира
     * @param ticketNumber номер квитка
     * @param seatNumber номер місця
     */
    public Passenger(String name, int ticketNumber, int seatNumber) {
        this.name = name;
        this.ticketNumber = ticketNumber;
        this.seatNumber = seatNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    @Override
    public String toString() {
        return "Passenger{name='" + name + "', ticketNumber=" + ticketNumber +
                ", seatNumber=" + seatNumber + "}";
    }

    @Override
    public int compareTo(Passenger other) {
        return Integer.compare(this.seatNumber, other.seatNumber);
    }
}

