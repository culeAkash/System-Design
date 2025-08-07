package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import domain.Floor;

public class FloorRepository {
    private Map<UUID, Floor> floors = new ConcurrentHashMap<>();
    private Map<Integer,UUID> floorNumberToId = new ConcurrentHashMap<>();

    public Floor saveFloor(Floor floor){
        floors.put(floor.getId(),floor);
        floorNumberToId.put(floor.getFloorNumber(),floor.getId());
        return floor;
    }

    public Optional<Floor> findByUUID(UUID id){
        return Optional.ofNullable(floors.get(id));
    }

    public Optional<Floor> floorByFloorNumber(Integer floorNumber){
        UUID floorId = floorNumberToId.get(floorNumber);
        return floorId != null ? Optional.ofNullable(floors.get(floorId)) : Optional.empty();
    }

    public List<Floor> findAllFloors(){
        return new ArrayList<>(floors.values());
    }

    public boolean floorExists(Integer floorNumber){
        return floorNumberToId.containsKey(floorNumber);
    }

    public void deleteFloor(UUID id){
        // check if exists
        Floor floor = floors.remove(id);
        if(floor != null){
            floorNumberToId.remove(floor.getFloorNumber());
        }
    }


}
