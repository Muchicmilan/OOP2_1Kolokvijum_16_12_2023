package vozila;

import lombok.Getter;

@Getter

public abstract class Vozilo {
    private static int countOfId;
    final private int id;
    final private int capacity;
    final private int usage;
    final private String type;

    Vozilo(int capacity, int usage, String type) {
        this.capacity = capacity;
        this.usage = usage;
        this.type = type;
        id = countOfId++;
    }

    public abstract String information();
}
