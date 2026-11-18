public class Building {
    private Floor[] floors;
    private int totalFloors;

    public Building(int totalFloors){
        this.totalFloors = totalFloors;
        this.floors = new Floor[totalFloors];
        for(int i = 0; i < totalFloors; i++){
            if(i == 0){
                floors[i] = new Floor(i, "Ground");
            }else{
                floors[i] = new Floor(i, "Floor "+i);
            }
        }
    }

    public Floor[] getFloors(){
        return floors.clone();
    }

    public int getTotalFloors(){
        return totalFloors;
    }

    public int getTopFloor(){
        return totalFloors - 1;
    }

    public boolean isValidFloor(int n){
        return n < totalFloors && n >= 0;
    }

    public Floor getFloor(int n){
        if (isValidFloor(n)){
            return floors[n];
        }
        return null;
    }
    
    public void showFloors() {
        for (int i = 0; i < totalFloors; i++) {
            System.out.println(floors[i]);
        }
    }
}
