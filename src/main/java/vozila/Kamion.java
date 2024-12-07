package vozila;

import lombok.Getter;

@Getter
public class Kamion extends Vozilo{

    private final int shipment;

    Kamion(int capacity, int usage, String type, int shipment) {
        super(capacity, usage, "Kamion");
        this.shipment = shipment;
    }

    @Override
    public String information() {
        return "Kapacitet: " + getCapacity() + "l Potrosnja: " + getUsage() + "l/100km " +
                "ID: " + getId() + " Tip: " + getType() + " Nosivost: " + shipment;
    }
}
