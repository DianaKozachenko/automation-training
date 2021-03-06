package entity.airport;

import entity.plane.MilitaryPlane;
import entity.plane.PassengerPlane;
import entity.plane.Plane;
import enums.MilitaryPlaneType;

import java.util.*;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public <T extends Plane> List<T> getPlanesOfCertainType(Class<T> planeCertain){
        List<T> planesOfCertainType = new ArrayList<>();
        for (Plane plane : planes) {
            if (planeCertain.isInstance(plane)){
                planesOfCertainType.add((T) plane);
            }
        }
        return planesOfCertainType;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPlanesOfCertainType(PassengerPlane.class);
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlane;
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getMilitaryPlanesOfCertainType(MilitaryPlaneType militaryPlaneType) {
        List<MilitaryPlane> militaryPlanesOfCertainType = new ArrayList<>();
        for (MilitaryPlane militaryPlane : getPlanesOfCertainType(MilitaryPlane.class)) {
            if (militaryPlane.getMilitaryPlaneType() == militaryPlaneType) {
                militaryPlanesOfCertainType.add(militaryPlane);
            }
        }
        return militaryPlanesOfCertainType;
    }

    @Override
    public String toString() {
        return "entity.airport.Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

}
