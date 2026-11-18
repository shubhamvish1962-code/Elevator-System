public class Floor {
    private int FloorNumber;
    private String FloorName;
    private int waitingCount;

    public Floor(int FloorNumber,String FloorName){
        this.FloorNumber = FloorNumber;
        this.FloorName = FloorName;
    }

    public int getFloorNumber(){
        return FloorNumber;
    }

    public String getFloorName(){
        return FloorName;
    }

    public int getWaitingCount(){
        return waitingCount;
    }

    public void addWaiting(){
        waitingCount += 1;
    }

    public void removeWaiting(){
        if(waitingCount > 0){
            waitingCount -= 1;
        }
    }

    public String toString(){
        return "FloorNumber:" + FloorNumber + " | FloorName:" + FloorName + " | WaitingCount:" + waitingCount;
    }
}
