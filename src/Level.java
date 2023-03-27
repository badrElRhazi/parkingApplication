import java.util.List;

public class Level  {
    public int levelNumber;
    public int rows;
    public List<parkingSlot> takenSlots;
    public int SLOTS_PER_ROW=2;

    public parkingSlot findAvailableSpot(){
        int totalNumberSlot= rows = SLOTS_PER_ROW;
        if(takenSlots.size() >= totalNumberSlot){
            //Parking full
            return null;
        } else if(takenSlots.isEmpty()){
            return  new parkingSlot(0,0,levelNumber);
        }else {
            parkingSlot lastSpaceOccupied = takenSlots.get(takenSlots.size()-1);
            if(lastSpaceOccupied.col<SLOTS_PER_ROW){
                return  new parkingSlot(lastSpaceOccupied.row,lastSpaceOccupied.col+1,levelNumber);
            }else {
                return new parkingSlot(lastSpaceOccupied.row+1,0,levelNumber);
            }
        }

    }
    public boolean park(Car car){
        parkingSlot freespace=findAvailableSpot();
        if(freespace != null ){
            freespace.park(car); // park in free space
            takenSlots.add(freespace);
            return true;
        }
        else  return false;
    }
}