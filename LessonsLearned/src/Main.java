import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Meeting[] meetings = new Meeting[] {new Meeting(0, 1), new Meeting(3, 5), new Meeting(4, 8), new Meeting(10, 12), new Meeting(9, 10)};
        // Meeting[] meetings = {new Meeting(0, 1), new Meeting(3, 5), new Meeting(4, 8), new Meeting(10, 12), new Meeting(9, 10)};
        Meeting[] meetings = {new Meeting(0, 1), new Meeting(3, 5), new Meeting(4, 8), new Meeting(10, 12), new Meeting(9, 10)};

        List<Meeting> sortedMeetings = new ArrayList<Meeting>(Arrays.asList(meetings));

        Collections.sort(sortedMeetings, new Comparator<Meeting>() {
            public int compare(Meeting m1, Meeting m2) {
                return m1.getStartTime() - m2.getStartTime();
            }
        });
    }
}
