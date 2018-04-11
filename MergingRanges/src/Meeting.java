public class Meeting {
    public int startTime;
    public int endTime;

    public Meeting(int start, int end) {
        this.startTime = start;
        this.endTime = end;
    }

    public String print() {
        return "{ " + "startTime: " + this.startTime + ", endTime: " + this.endTime + " }";
    }
}
