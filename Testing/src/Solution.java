import java.util.*;

/**
 * Created by chetan on 7/3/17.
 * https://www.geeksforgeeks.org/number-possible-triangles-cartesian-coordinate-system/
 *https://www.geeksforgeeks.org/check-whether-a-given-point-lies-inside-a-triangle-or-not/
 */
public class Solution {
   /* static int pointsBelongToTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int xP, int yP, int xQ, int yQ) {
        boolean isPExist = false, isQExist=false;
        //Check if triangle can form
        if(isTriangleExist(x1,y1,x2,y2,x3,y3)!=0) {
            if (pointBelongsToTriangle(x1,y1,x2,y2,x3,y3,xP,yP))
                isPExist = true;
            else
                isPExist = false;

            if (pointBelongsToTriangle(x1,y1,x2,y2,x3,y3,xQ,yQ))
                isQExist = true;
            else
                isQExist = false;

            if(isPExist && isQExist)
                return 3;
            else if(isPExist && !isQExist)
                return 1;
            else if(!isPExist && isQExist)
                return 2;
            else
                return 4;

        } else {
            return 0;
        }
    }

    static int isTriangleExist(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        return x1*(y2 - y3) - y1*(x2 - x3) + 1*(x2*y3 - y2*x3);
    }

    static double area(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0);
    }

    static boolean pointBelongsToTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y)
    {
        double A = area (x1, y1, x2, y2, x3, y3);

        double A1 = area (x, y, x2, y2, x3, y3);

        double A2 = area (x1, y1, x, y, x3, y3);

        double A3 = area (x1, y1, x2, y2, x, y);

        return (A == A1 + A2 + A3);
    }*/

    /*public static void main(String[] args) {
        *//*Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        String s = in.next();*//*
//        int result = twoCharaters(s);?
        int arr[] = {3,3,4,2};
        System.out.println(maxPoints(arr));

//        in.close();
    }*/
/*

    public static final String YES = "YES";
    public static final String NO = "NO";
    static String isPossible(int a, int b, int c, int d) {
        if(a>c || b>d) return NO;
        if(a==c && b==d) return YES;

        String left = isPossible(a+b,b,c,d);
        String right = isPossible(a,a+b,c,d);

        if(left.equals(YES) || right.equals(YES))
            return YES;

        return NO;
    }
*/

    /*public static long maxPoints(int[] elements) {
        int[] count = new int[100001];
        for (int num: elements) count[num]++;
        long remove = 0;
        long use = 0;
        int prev = -1;

        for (int i = 0; i <= 100000; ++i) if (count[i] > 0) {
            long max = Math.max(remove, use);
            if (i - 1 != prev) {
                use = i * count[i] + max;
                remove = max;
            } else {
                use = i * count[i] + remove;
                remove = max;
            }
            prev = i;
        }
        return Math.max(remove, use);
    }*/

    /*static long maxPoints(int[] elements) {

    }*/
/*
    public static final Integer N = 1;
    public static final Integer E = 2;
    public static final Integer S = 3;
    public static final Integer W = 4;
    Integer x = 0;
    Integer y = 0;
    Integer facing = N;
    public Solution() {
    }
    public void setPosition(Integer x, Integer y, Integer facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }
    public void printPosition() {
        char dir = 'N';
        if (facing == 1) {
            dir = 'N';
        } else if (facing == 2) {
            dir = 'E';
        } else if (facing == 3) {
            dir = 'S';
        } else if (facing == 4) {
            dir = 'W';
        }
        System.out.println(x +  " "  + y  + " "+   dir);
    }
    public void process(String commands) {
        for (int idx = 0; idx < commands.length(); idx++  ) {
            process(commands.charAt(idx));
        }
    }
    private void process(Character command) {
        if (command.equals('L')) {
            turnLeft();
        } else if (command.equals('R')) {
            turnRight();
        } else if (command.equals('M')) {
            move();
        } else {
            throw new IllegalArgumentException(
                    "Speak in Mars language, please!");
        }
    }
    private void move() {
        if (facing == N) {
            this.y  ;
        } else if (facing == E) {
            this.x  ;
        } else if (facing == S) {
            this.y--;
        } else if (facing == W) {
            this.x--;
        }
    }
    private void turnLeft() {
        facing = (facing - 1) < N ? W : facing - 1;
    }
    private void turnRight() {
        facing = (facing   1) > W ? N : facing   1;
    }
    public static void main(String args[]) {
        Solution rover = new Solution();
        rover.setPosition(1, 2, N);
        rover.process("LMLMLMLMM");
        rover.printPosition(); // prints 1 3 N
        rover.setPosition(3, 3, E);
        rover.process("MMRMMRMRRM");
        rover.printPosition(); // prints 5 1 E
    }*/

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        int min = arr[0], max = arr[0];
        long sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(min>arr[i]) {
                min = arr[i];
            }
            if(max<arr[i]) {
                max = arr[i];
            }
            sum+=arr[i];
        }
        System.out.print((sum-max) + " " + (sum - min));

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}


class Customer {
    private String natlId;
    private String customerType;
    private String dateOfBirthOrRegistration;
    private String activationDateTime;
    private String firstName;
    private String lastName;
    private String custId;
    private String aadhaarId;
    private String nomineeName;
    private String nomineedateOfBirth;
    private String nomineeRelationship;
    private String guardianName;
    private String guardianDateOfBirth;
    private String guardianRelationship;
}