import java.util.*;
import java.util.stream.Collectors;

public class MergingRanges {

    public static List<Meeting> mergeRanges(List<Meeting> meetings) {
        List<Meeting> sortedMeetings = meetings.stream()
                .sorted((m1, m2) -> Integer.compare(m1.startTime, m2.startTime))
                .collect(Collectors.toList());

        List<Meeting> mergedMeetings = new ArrayList<>();

        mergedMeetings.add(sortedMeetings.get(0));

        for (int i = 1; i < sortedMeetings.size(); i++) {
            Meeting nextMeeting = sortedMeetings.get(i);
            Meeting lastMergedMeeting = sortedMeetings.get(i - 1);

            if (lastMergedMeeting.endTime > nextMeeting.startTime &&
                    lastMergedMeeting.endTime < nextMeeting.endTime) {
                lastMergedMeeting.endTime = nextMeeting.endTime;
            } else {
                mergedMeetings.add(nextMeeting);
            }
        }
        return mergedMeetings;
    }


    public static void printMeetings(List<Meeting> meetings) {
        for (Meeting meeting: meetings) {
            System.out.println(meeting.print());
        }
    }

    public static void main(String[] args) {
        Meeting[] meetings = new Meeting[] {new Meeting(0, 1), new Meeting(3, 5), new Meeting(4, 8), new Meeting(10, 12), new Meeting(9, 10)};
//        List<Meeting> stuff = new ArrayList<Meeting>(Arrays.asList(meetings));
        List<Meeting> mergedMeetings = mergeRanges(Arrays.asList(meetings));
        printMeetings(mergedMeetings);
    }
}
