package game.model;

import lombok.AllArgsConstructor;
import lombok.Data;


//the lombok @Data gives us automatic getters and setters
@Data
//the lombok @AllArgsConstructor gives us an All-Args-Constructor :)
@AllArgsConstructor
public class CollisionOp {
    //this could also be a boolean, but we want to be explicit about what we're doing
    public enum Operation {
        ADD, REMOVE
    }
    //members
    private Movable movable;
    private Operation operation;

}
