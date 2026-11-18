public class GoodsElevator extends Elevator{

    GoodsElevator(String elevatorId, int Starting_floor){
        super(elevatorId, Starting_floor);
    }

    @Override 
    public int getMaxLoad() {
        return 1500;
    }

    @Override  
    public String getElevatorType() {
        return "GOODS";
    }
}