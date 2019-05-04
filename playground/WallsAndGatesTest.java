import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class WallsAndGatesTest {

    @org.junit.jupiter.api.Test
    void wallsAndGates() {
        int[][] rooms = {{0, 0, 0, -1, 0, -1, 0, 2147483647, 2147483647, 0, 0, 0, 2147483647, 0, 0, 0, 0, 2147483647, -1, 0, 0, -1, 2147483647, 0, 0, 0, 2147483647, 2147483647, 2147483647, 2147483647}, {0, 2147483647, 2147483647, 0, 0, -1, -1, 2147483647, 2147483647, 0, -1, -1, 0, -1, -1, -1, 2147483647, 2147483647, 0, 2147483647, 2147483647, 0, 0, 0, 2147483647, 0, 2147483647, 2147483647, 0, 0}, {0, 2147483647, 0, 0, 0, 0, 2147483647, 0, 2147483647, -1, 0, -1, -1, 2147483647, 0, 0, 0, 0, 2147483647, 0, -1, 2147483647, 2147483647, 0, 0, 2147483647, 2147483647, 2147483647, 2147483647, 0}, {2147483647, 2147483647, 2147483647, -1, 0, 0, -1, -1, -1, 0, -1, 2147483647, -1, 2147483647, -1, -1, -1, 2147483647, -1, -1, 0, 2147483647, 0, -1, 2147483647, 0, 2147483647, 2147483647, 2147483647, 2147483647}, {-1, 0, 0, 2147483647, 0, 0, 2147483647, 2147483647, 2147483647, -1, 0, -1, -1, 0, 2147483647, 2147483647, -1, 0, 0, 2147483647, 2147483647, -1, 2147483647, -1, -1, -1, 0, -1, -1, -1}, {-1, -1, 0, -1, -1, -1, 0, 0, 2147483647, -1, -1, -1, 2147483647, 0, -1, 2147483647, 2147483647, 2147483647, -1, 0, 0, -1, -1, -1, 0, 2147483647, -1, 2147483647, 2147483647, 2147483647}, {-1, -1, 2147483647, 0, -1, 0, -1, -1, 0, 2147483647, 2147483647, -1, 2147483647, 2147483647, 0, 2147483647, 0, 0, 2147483647, 0, 2147483647, 0, 2147483647, -1, 2147483647, 2147483647, -1, -1, 0, -1}, {-1, -1, 2147483647, 2147483647, 2147483647, -1, 2147483647, -1, 2147483647, 2147483647, 0, -1, -1, 0, 0, 2147483647, -1, 2147483647, -1, -1, 2147483647, 0, 0, 0, 0, 2147483647, 2147483647, 0, -1, -1}, {0, 0, 2147483647, -1, 2147483647, 0, -1, -1, 0, -1, 0, 2147483647, -1, 2147483647, 0, 0, 2147483647, 2147483647, 0, -1, 0, 0, 0, 2147483647, 2147483647, -1, 2147483647, -1, 0, 0}, {-1, -1, 2147483647, 0, 2147483647, -1, 0, 0, 0, -1, 0, 0, -1, -1, -1, -1, 2147483647, 2147483647, -1, 2147483647, 0, 0, 0, -1, -1, 2147483647, 0, 0, 2147483647, 0}, {2147483647, 2147483647, -1, 2147483647, -1, 0, -1, -1, 0, 2147483647, 2147483647, 2147483647, -1, 0, -1, -1, 0, -1, -1, 2147483647, -1, 0, 2147483647, 0, 2147483647, -1, 2147483647, -1, -1, -1}, {0, 2147483647, -1, 0, 2147483647, 0, 2147483647, 0, 2147483647, -1, 0, 0, -1, -1, 0, -1, 2147483647, 2147483647, 0, 2147483647, -1, -1, 2147483647, -1, 2147483647, 0, 0, 2147483647, -1, 2147483647}, {0, -1, 0, -1, -1, 2147483647, -1, -1, -1, -1, 2147483647, 2147483647, 0, 2147483647, 2147483647, 0, -1, -1, -1, -1, -1, 0, -1, -1, 0, 2147483647, 0, 2147483647, -1, 0}, {-1, 2147483647, -1, 0, 0, 2147483647, 2147483647, 2147483647, -1, 2147483647, 2147483647, 0, 0, 0, 2147483647, 2147483647, 0, 2147483647, -1, -1, 0, 2147483647, 0, -1, 2147483647, 0, 2147483647, 2147483647, -1, -1}, {2147483647, 2147483647, 0, -1, 2147483647, -1, -1, 2147483647, -1, 2147483647, -1, -1, 2147483647, -1, 0, 2147483647, -1, 2147483647, 0, 2147483647, 2147483647, 0, 0, 0, 2147483647, 2147483647, 0, -1, 0, 0}, {-1, 2147483647, -1, -1, 0, 0, 2147483647, -1, 2147483647, 2147483647, -1, 2147483647, 0, 2147483647, -1, -1, -1, 2147483647, 0, -1, 2147483647, 0, 0, 2147483647, -1, 0, -1, 0, 0, -1}, {-1, -1, -1, 2147483647, -1, -1, 2147483647, 2147483647, 2147483647, 2147483647, -1, -1, 2147483647, 0, -1, -1, 0, 2147483647, -1, -1, 0, 0, 0, 0, -1, -1, -1, -1, 0, -1}, {0, -1, 2147483647, -1, 0, 2147483647, 2147483647, 0, -1, 2147483647, 0, -1, 2147483647, 2147483647, -1, 0, 0, -1, -1, 2147483647, 0, 2147483647, 2147483647, 0, 2147483647, 2147483647, -1, 0, -1, 0}, {2147483647, 2147483647, -1, 0, -1, 0, 0, 0, -1, -1, 2147483647, -1, 2147483647, 0, -1, 0, -1, 0, -1, 2147483647, 2147483647, 2147483647, -1, -1, 0, -1, -1, 2147483647, 0, -1}, {0, -1, -1, -1, 2147483647, 0, 0, -1, 0, -1, 0, -1, 0, 0, -1, -1, 2147483647, 2147483647, -1, -1, 2147483647, 2147483647, 0, 2147483647, -1, 0, -1, -1, -1, -1}, {0, 2147483647, 2147483647, -1, -1, 2147483647, 2147483647, 2147483647, 0, 0, 2147483647, -1, 0, 2147483647, 0, -1, 0, -1, 2147483647, 2147483647, 2147483647, -1, -1, 0, 0, 2147483647, 2147483647, -1, -1, 2147483647}, {-1, 2147483647, 2147483647, -1, -1, 0, 2147483647, 0, 2147483647, -1, 2147483647, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, -1, -1, -1, 0, 2147483647}, {2147483647, 0, 0, 0, 0, -1, -1, 2147483647, 0, 0, 0, 0, 0, 2147483647, 2147483647, 0, -1, 0, -1, -1, 2147483647, 0, 0, -1, 2147483647, -1, -1, 2147483647, 2147483647, -1}, {2147483647, 0, 2147483647, 2147483647, 2147483647, 0, 2147483647, 0, -1, -1, 0, 2147483647, 0, 0, 0, -1, 2147483647, 0, -1, 2147483647, -1, 0, 2147483647, 0, 2147483647, -1, 2147483647, 0, -1, -1}, {0, -1, -1, 2147483647, -1, -1, 2147483647, 2147483647, 2147483647, -1, 0, -1, 0, 0, 0, 2147483647, 0, 2147483647, 0, -1, -1, 2147483647, 2147483647, 0, 0, 2147483647, 0, 0, 0, 2147483647}, {-1, 2147483647, 0, 0, 2147483647, 2147483647, 2147483647, -1, -1, 2147483647, 2147483647, 2147483647, 2147483647, -1, 2147483647, -1, 0, 2147483647, -1, 0, 2147483647, 0, -1, 0, 2147483647, -1, 0, -1, -1, -1}, {-1, 2147483647, 0, 0, 0, 2147483647, -1, -1, 2147483647, -1, -1, 0, 0, 0, 2147483647, 2147483647, 2147483647, 2147483647, -1, 0, 0, 2147483647, 2147483647, 0, 0, 0, 0, -1, 0, 2147483647}, {0, -1, 2147483647, -1, -1, -1, -1, 2147483647, 2147483647, -1, 0, -1, 2147483647, 0, -1, 0, 2147483647, 0, 0, -1, 0, -1, 0, 0, -1, 2147483647, 2147483647, 2147483647, 2147483647, -1}, {2147483647, 2147483647, 2147483647, -1, 2147483647, -1, -1, 2147483647, 0, -1, 0, 2147483647, -1, 0, 2147483647, 2147483647, 2147483647, -1, -1, 0, 2147483647, 0, -1, -1, -1, 0, 0, 2147483647, -1, 2147483647}, {-1, -1, -1, 0, -1, 0, 2147483647, -1, -1, 0, 2147483647, 2147483647, 2147483647, 0, 2147483647, 2147483647, 2147483647, -1, 0, -1, -1, 2147483647, 0, -1, 0, 0, -1, 2147483647, 2147483647, -1}, {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, -1, 2147483647, 2147483647, 0, -1, 0, -1, -1, 0, 0, 0, -1, 2147483647, 0, 0, 2147483647, 2147483647, 2147483647, -1, 0, 0, 0, 2147483647, 0, 0}};
        new WallsAndGates().wallsAndGates(rooms);
        int[][] res = {{0, 0, 0, -1, 0, -1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, -1, 0, 0, -1, 1, 0, 0, 0, 1, 2, 1, 1}, {0, 1, 1, 0, 0, -1, -1, 1, 1, 0, -1, -1, 0, -1, -1, -1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0}, {0, 1, 0, 0, 0, 0, 1, 0, 1, -1, 0, -1, -1, 1, 0, 0, 0, 0, 1, 0, -1, 1, 1, 0, 0, 1, 2, 2, 1, 0}, {1, 1, 1, -1, 0, 0, -1, -1, -1, 0, -1, 2147483647, -1, 1, -1, -1, -1, 1, -1, -1, 0, 1, 0, -1, 1, 0, 1, 2, 2, 1}, {-1, 0, 0, 1, 0, 0, 1, 1, 2, -1, 0, -1, -1, 0, 1, 3, -1, 0, 0, 1, 1, -1, 1, -1, -1, -1, 0, -1, -1, -1}, {-1, -1, 0, -1, -1, -1, 0, 0, 1, -1, -1, -1, 1, 0, -1, 2, 1, 1, -1, 0, 0, -1, -1, -1, 0, 1, -1, 2, 1, 2}, {-1, -1, 1, 0, -1, 0, -1, -1, 0, 1, 1, -1, 2, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, -1, 1, 2, -1, -1, 0, -1}, {-1, -1, 2, 1, 2, -1, 2147483647, -1, 1, 1, 0, -1, -1, 0, 0, 1, -1, 1, -1, -1, 1, 0, 0, 0, 0, 1, 1, 0, -1, -1}, {0, 0, 1, -1, 1, 0, -1, -1, 0, -1, 0, 1, -1, 1, 0, 0, 1, 1, 0, -1, 0, 0, 0, 1, 1, -1, 1, -1, 0, 0}, {-1, -1, 1, 0, 1, -1, 0, 0, 0, -1, 0, 0, -1, -1, -1, -1, 1, 2, -1, 1, 0, 0, 0, -1, -1, 1, 0, 0, 1, 0}, {1, 2, -1, 1, -1, 0, -1, -1, 0, 1, 1, 1, -1, 0, -1, -1, 0, -1, -1, 2, -1, 0, 1, 0, 1, -1, 1, -1, -1, -1}, {0, 1, -1, 0, 1, 0, 1, 0, 1, -1, 0, 0, -1, -1, 0, -1, 1, 1, 0, 1, -1, -1, 2, -1, 1, 0, 0, 1, -1, 1}, {0, -1, 0, -1, -1, 1, -1, -1, -1, -1, 1, 1, 0, 1, 1, 0, -1, -1, -1, -1, -1, 0, -1, -1, 0, 1, 0, 1, -1, 0}, {-1, 2, -1, 0, 0, 1, 2, 3, -1, 5, 1, 0, 0, 0, 1, 1, 0, 1, -1, -1, 0, 1, 0, -1, 1, 0, 1, 2, -1, -1}, {2, 1, 0, -1, 1, -1, -1, 4, -1, 4, -1, -1, 1, -1, 0, 1, -1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, -1, 0, 0}, {-1, 2, -1, -1, 0, 0, 1, -1, 3, 3, -1, 1, 0, 1, -1, -1, -1, 1, 0, -1, 1, 0, 0, 1, -1, 0, -1, 0, 0, -1}, {-1, -1, -1, 2147483647, -1, -1, 2, 1, 2, 2, -1, -1, 1, 0, -1, -1, 0, 1, -1, -1, 0, 0, 0, 0, -1, -1, -1, -1, 0, -1}, {0, -1, 2147483647, -1, 0, 1, 1, 0, -1, 1, 0, -1, 2, 1, -1, 0, 0, -1, -1, 1, 0, 1, 1, 0, 1, 2, -1, 0, -1, 0}, {1, 2, -1, 0, -1, 0, 0, 0, -1, -1, 1, -1, 1, 0, -1, 0, -1, 0, -1, 2, 1, 2, -1, -1, 0, -1, -1, 1, 0, -1}, {0, -1, -1, -1, 1, 0, 0, -1, 0, -1, 0, -1, 0, 0, -1, -1, 1, 1, -1, -1, 2, 1, 0, 1, -1, 0, -1, -1, -1, -1}, {0, 1, 2, -1, -1, 1, 1, 1, 0, 0, 1, -1, 0, 1, 0, -1, 0, -1, 1, 1, 2, -1, -1, 0, 0, 1, 2, -1, -1, 2}, {-1, 1, 1, -1, -1, 0, 1, 0, 1, -1, 1, 0, 0, 0, -1, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, -1, -1, -1, 0, 1}, {1, 0, 0, 0, 0, -1, -1, 1, 0, 0, 0, 0, 0, 1, 1, 0, -1, 0, -1, -1, 1, 0, 0, -1, 1, -1, -1, 1, 1, -1}, {1, 0, 1, 1, 1, 0, 1, 0, -1, -1, 0, 1, 0, 0, 0, -1, 1, 0, -1, 2147483647, -1, 0, 1, 0, 1, -1, 1, 0, -1, -1}, {0, -1, -1, 1, -1, -1, 2, 1, 2, -1, 0, -1, 0, 0, 0, 1, 0, 1, 0, -1, -1, 1, 1, 0, 0, 1, 0, 0, 0, 1}, {-1, 1, 0, 0, 1, 2, 3, -1, -1, 2, 1, 1, 1, -1, 1, -1, 0, 1, -1, 0, 1, 0, -1, 0, 1, -1, 0, -1, -1, -1}, {-1, 1, 0, 0, 0, 1, -1, -1, 2, -1, -1, 0, 0, 0, 1, 1, 1, 1, -1, 0, 0, 1, 1, 0, 0, 0, 0, -1, 0, 1}, {0, -1, 1, -1, -1, -1, -1, 2, 1, -1, 0, -1, 1, 0, -1, 0, 1, 0, 0, -1, 0, -1, 0, 0, -1, 1, 1, 2, 1, -1}, {1, 2, 2, -1, 2147483647, -1, -1, 1, 0, -1, 0, 1, -1, 0, 1, 1, 2, -1, -1, 0, 1, 0, -1, -1, -1, 0, 0, 1, -1, 2147483647}, {-1, -1, -1, 0, -1, 0, 1, -1, -1, 0, 1, 2, 1, 0, 1, 1, 2, -1, 0, -1, -1, 1, 0, -1, 0, 0, -1, 2, 1, -1}, {4, 3, 2, 1, 2, -1, 2, 1, 0, -1, 0, -1, -1, 0, 0, 0, -1, 1, 0, 0, 1, 2, 1, -1, 0, 0, 0, 1, 0, 0}};

        for(int i = 0 ; i < rooms.length; i ++){
            for(int j = 0; j < rooms[0].length; j ++){
                if(rooms[i][j] != res[i][j]){
                    System.out.print(rooms[i][j]);
                }else{
                    System.out.print("\t");
                }
            }
        }

        Assertions.assertEquals(rooms, res);


    }
}