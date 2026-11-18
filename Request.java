public class Request {
    private String requestId;
    private int fromFloor;
    private int toFloor;
    private int weight;
    private String requestType;
    private boolean served;
    private static int counter = 1;

    public Request(int fromFloor, int toFloor,int weight, String requestType){
        this.requestId = "R" + counter;
        counter++;
        this.fromFloor = fromFloor;
        this.toFloor = toFloor;
        this.weight = weight;
        this.requestType = requestType;
    }

    public String getRequestId(){
        return requestId;
    }

    public int getFromFloor(){
        return fromFloor;
    }

    public int getToFloor(){
        return toFloor;
    }

    public int getWeight(){
        return weight;
    }

    public String getRequestType(){
        return requestType;
    }

    public boolean getServed(){
        return served;
    }

    public String getStatus(){
        return served ? "Served" : "Pending";
    }

    public String getDirection(){
        if(toFloor > fromFloor){
            return "UP";
        } else if (toFloor < fromFloor){
            return "DOWN";
        } else {
            return "NONE";
        }
    }

    public Boolean isValid(){
        return  fromFloor != toFloor && weight > 0 && ("Person".equalsIgnoreCase(requestType) || "Goods".equalsIgnoreCase(requestType));
    }

    public void markServed(){
        served = true;
    }

    @Override 
    public String toString(){
        return requestId + " " + requestType + " from " + fromFloor + " to " + toFloor + " (" + getDirection() + ") " + weight + " kg "+ getStatus();
    }
}
