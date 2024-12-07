package vozila;

import lombok.Getter;

@Getter

public class Autobus extends Vozilo{

    final private int seats;

    Autobus(int capacity, int usage, String type, int seats) {
        super(capacity, usage, "Autobus");
        this.seats = seats;
    }

    @Override
    public String information() {
        return "Kapacitet: " + getCapacity() + "l Potrosnja: " + getUsage() + "l/100km " +
                "ID: " + getId() + " Tip: " + getType() + " Broj sedista: " + seats;
    }
}
