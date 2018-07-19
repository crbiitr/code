/**
 * Created by chetan on 10/2/18.
 */
import java.util.Scanner;

public class Mars_Rover {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x, y;
        int endx = scan.nextInt();
        int endy = scan.nextInt();

        x = scan.nextInt();
        y = scan.nextInt();
        char facing = scan.next().charAt(0);
        char control[] = scan.next().toCharArray();
        Rover r = new Rover(endx, endy);
        Position pos = r.findPosition(x, y, facing, control);
        System.out.println(pos.x + " "+ pos.y+" "+ facing);
        scan.close();
    }
}

class Rover{
    int endx, endy;
    Rover(int endx, int endy){
        this.endx = endx;
        this.endy = endy;
    }
    Position findPosition(int x, int y, char facing, char control[]){
        Position pos;
        pos = new Position(x, y, facing);
        for (int i = 0; i < control.length; i++) {

            if(pos.facing == 'N' && control[i] == 'L'){
                pos.facing = 'W';
            }

            else if(pos.facing == 'W' && control[i] == 'L'){
                pos.facing = 'S';
            }

            else if(pos.facing == 'S' && control[i] == 'L'){
                pos.facing = 'E';
            }

            else if(pos.facing == 'E' && control[i] == 'L'){
                pos.facing = 'N';
            }

            else if(pos.facing == 'N' && control[i] == 'R'){
                pos.facing = 'E';
            }

            else if(pos.facing == 'E' && control[i] == 'R'){
                pos.facing = 'S';
            }

            else if(pos.facing == 'S' && control[i] == 'R'){
                pos.facing = 'W';
            }

            else if(pos.facing == 'W' && control[i] == 'R'){
                pos.facing = 'N';
            }
            if(control[i] == 'M'){
                pos = moveRover(pos.x, pos.y, pos.facing);
//	System.out.println(pos.x + " "+pos.y+" "+facing);
            }
        }
        return pos;
    }

    Position moveRover(int x, int y, char facing){
       /* if (facing == 'N' && y<endy) {="" y++;="" }else="" if(facing="=" 's'="" &&="" y="">0 ){
            y--;
        } else if(facing == 'E' && x<endx){ x++;="" }="" else="" if(facing="=" 'w'="" &&="" x="">0){
            x--;
        }*/
        return new Position(x, y, facing);
    }

}

class Position{
    int x, y;
    char facing;
    Position(int x, int y, char facing){
        this.x = x;
        this.y = y;
        this.facing = facing;
    }
}