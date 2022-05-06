package system;

public class Main {
    public static void main(String[] args){
        Elevator elevator = new DefaultElevator();
        ElevatorRepeater elevatorRepeater = new DefaultElevatorRepeater(elevator);

        for(int i=0; i<10; i++){
            Person person = new DefaultPerson();
            person.callElevator(elevatorRepeater);
        }

        boolean result = true;

        while(result){
            result = elevatorRepeater.orderElevator();
        }
    }
}
