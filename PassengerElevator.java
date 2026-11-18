public class PassengerElevator extends Elevator {

    PassengerElevator(String elevatorId, int Starting_floor){
        super(elevatorId,Starting_floor);
    }

    @Override
    public int getMaxLoad() {
        return 600;
    }

    @Override
    public String getElevatorType() {
        return "PASSENGER";
    }
}