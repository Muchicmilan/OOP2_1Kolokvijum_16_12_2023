package vozila;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
public class KolekcijaVozila {
    List<Vozilo> listaVozila = new ArrayList<Vozilo>();

    public void add(Vozilo vozilo) {
        listaVozila.add(vozilo);
    }

    public void remove(int id){
        for(Vozilo vozilo : listaVozila){
            if(vozilo.getId() == id){
                listaVozila.remove(vozilo);
                break;
            }
        }
    }

    public boolean possibleToSeatPassengers(int numberOfPassengers) {
        int maxSeats = 0;
        for(Vozilo vozilo : listaVozila){
            if(vozilo.getType().equals("Autobus")){
                Autobus autobus = (Autobus) vozilo;
                maxSeats += autobus.getSeats();
            }
        }
        return maxSeats >= numberOfPassengers;
    }

    public int possibleToCarryOut(int t, int s){
        List<Kamion> candidates = new ArrayList<>();
        for(Vozilo vozilo : listaVozila){
            if(vozilo.getType().equals("Kamion")){
                Kamion kamion = (Kamion) vozilo;
                if(kamion.getCapacity() >= (int)(kamion.getUsage()*(s/100.0)))
                    candidates.add(kamion);
            }
        }
        int neededWeight = 0;

        while(neededWeight < t){
            if(candidates.isEmpty())
                return -1;
            int currIndex = -1;
            int currMinWeight = candidates.get(0).getShipment();
            for(int i=0; i<candidates.size(); i++){
                int shipment = candidates.get(i).getShipment();
                if(shipment < currMinWeight && shipment > 0){
                    currMinWeight = shipment;
                    currIndex = i;
                }
            }

            if(currIndex == -1)
                return -1;
            neededWeight += currMinWeight;
            candidates.remove(currIndex);

        }
        return neededWeight;
    }

}
