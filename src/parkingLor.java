import java.util.List;

public class parkingLor {
    public List<Level> levels;
    public parkingLor(List<Level> levels){
        this.levels=levels;
    }
    public boolean park(Car car){
        for(Level level:levels){
            if(level.park(car)){
                return true;
            }else{continue;
        }
    }
        return false;
}}