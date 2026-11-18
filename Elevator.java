public abstract class Elevator {
    private String elevatorId;
    private int current_Floor;
    private int current_Load=0;

    Elevator(String elevatorId,int Starting_floor){
        this.elevatorId=elevatorId;
        this.current_Floor=Starting_floor;
    }

    public String getelevatorId(){
        return  elevatorId;
    }

    public int getcurrent_Floor(){
        return  current_Floor;
    }

    public int getcurrent_load(){
        return  current_Load;
    }

    public abstract int getMaxLoad();
    public abstract String getElevatorType();

    public void moveToFloor(int target, int topFloor) throws InvalidFloorException {
        if (target < 0 || target > topFloor) {
            throw new InvalidFloorException();
        } else if (target > current_Floor) {
            for (int i = current_Floor + 1; i <= target; i++) {
                current_Floor = i;
                System.out.println("Elevator " + elevatorId + " is at floor " + current_Floor);
            }
        } else if (target < current_Floor) {
            for (int i = current_Floor - 1; i >= target; i--) {
                current_Floor = i;
                System.out.println("Elevator " + elevatorId + " is at floor " + current_Floor);
            }
        }
    }

    public void load(int weight) throws OverloadException {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be more than 0");
        }
        if (weight > getMaxLoad() - current_Load) {
            throw new OverloadException();
        }
        current_Load += weight;
    }

    public void unload() {
        current_Load = 0;
    }

    @Override
    public String toString() {
        return "Elevator ID: " + elevatorId + " | Type: " + getElevatorType() + " | Current Floor: " + current_Floor + " | Current Load: " + current_Load;
    }
}
