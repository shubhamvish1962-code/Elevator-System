public class Controller {
    private Building building;
    private Elevator[] elevators;
    private Request[] requests;
    private int requestCount;

    public Controller(){
        this.building = new Building(6);
        this.elevators = new Elevator[3];
        this.elevators[0] = new PassengerElevator("E1", 4);
        this.elevators[1] = new PassengerElevator("E2", 3);
        this.elevators[2] = new GoodsElevator("E3", 2);
        this.requests = new Request[50];
    }

    public Building getBuilding(){
        return building;
    }

    public Elevator[] getElevators(){
        return elevators.clone();
    }

    public Request[] getRequests(){
        return requests.clone();
    }

    public int getRequestCount(){
        return requestCount;
    }

    public Elevator findBestElevator(Request r){
        Elevator best = null;
        int minDistance = Integer.MAX_VALUE;

        for(int i = 0; i < elevators.length; i++){
            int floorDiff = Math.abs(r.getFromFloor() - elevators[i].getcurrent_Floor());
            boolean correctType =
                ("PERSON".equalsIgnoreCase(r.getRequestType()) && "PASSENGER".equals(elevators[i].getElevatorType())) ||
                ("GOODS".equalsIgnoreCase(r.getRequestType()) && "GOODS".equals(elevators[i].getElevatorType()));

            if(correctType && floorDiff < minDistance){
                minDistance = floorDiff;
                best = elevators[i];
            }
        }
        return best;
    }

    public void processRequest(Request r) throws InvalidFloorException, OverloadException {
        if(!r.isValid()){
            System.out.println("Invalid request. Use different floors, a positive weight, and PERSON or GOODS.");
            return;
        }
        if(!building.isValidFloor(r.getFromFloor()) || !building.isValidFloor(r.getToFloor())){
            throw new InvalidFloorException();
        }
        if(requestCount == requests.length){
            System.out.println("Request history is full. No more requests can be accepted.");
            return;
        }
        requests[requestCount] = r;
        requestCount++;

        Elevator elevator = findBestElevator(r);
        if(elevator == null){
            System.out.println("No elevator is available for this request type.");
            return;
        }

        Floor fromFloor = building.getFloor(r.getFromFloor());
        fromFloor.addWaiting();
        try {
            System.out.println("Selected elevator " + elevator.getelevatorId());
            elevator.moveToFloor(r.getFromFloor(), building.getTopFloor());
            System.out.println("Loading...");
            elevator.load(r.getWeight());
            elevator.moveToFloor(r.getToFloor(), building.getTopFloor());
            System.out.println("Unloading...");
            elevator.unload();
            r.markServed();
        } finally {
            fromFloor.removeWaiting();
        }
    }

    public void showElevatorStatus(){
        for(int i = 0; i < elevators.length; i++){
            System.out.println(elevators[i]);
        }
    }

    public void showAllRequests(){
        if(requestCount == 0){
            System.out.println("No requests yet.");
        }
        for(int i = 0; i < requestCount; i++){
            System.out.println(requests[i]);
        }
    }
}
