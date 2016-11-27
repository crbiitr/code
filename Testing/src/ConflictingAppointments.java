import java.util.ArrayList;
import java.util.Collections;

public class ConflictingAppointments {
    public static class Interval implements Comparable<Interval>{
        int start;
        int end;
        private Interval(int s, int e){
            this.start = s;
            this.end = e;
        }
        public String toString(){
            return "" + this.start+ " "+ this.end;
        }
        public int compareTo(Interval i){
            int getend = ((Interval) i).end;
            return this.end - getend;
        }
    }

    public int findConflictingAppointments(ArrayList<Interval>inter){
        Collections.sort(inter);
        int count = 0;
        for (int i =1;i<inter.size();i++){
            if(inter.get(i).start <= inter.get(i - 1).end){
                System.out.println(inter.get(i));
                count++;
            }
        }
        return count;
    }
    public static void main(String[]  args){
        ArrayList<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(1,5));
        list.add(new Interval(12,15));
        list.add(new Interval(42,44));
        list.add(new Interval(70,72));
        list.add(new Interval(36,36));
        list.add(new Interval(-4,2));
        list.add(new Interval(43,69));
        list.add(new Interval(15,24));
        System.out.println(list);
        ConflictingAppointments ca = new  ConflictingAppointments();
//        ca.findConflictingAppointments(list);

        System.out.println(list.size() - 2*ca.findConflictingAppointments(list));

    }
}
