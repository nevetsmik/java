import java.util.HashMap;

public class Main {

    public static boolean inflightEntertainment(int flightLength, int[] movieLengths) {
        HashMap<Integer, Integer> movieTimes = new HashMap<>();
        for (int movieTime : movieLengths) {
            if (movieTime < flightLength) {
                if (movieTimes.containsKey(movieTime)) {
                    movieTimes.put(movieTime, movieTimes.get(movieTime) + 1);
                } else {
                    movieTimes.put(movieTime, 1);
                }
            }
        }

        for (int movieTime : movieLengths) {
            if (movieTimes.containsKey(flightLength - movieTime)) {
                if (flightLength - movieTime == movieTime) {
                    if (movieTimes.get(flightLength - movieTime) > 1) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
	    HashMap<String, Integer> test = new HashMap<>();
	    test.put("Steve", 1);
	    test.put("Steve", test.get("Steve") + 1);
        System.out.println("\"Steve\" key has a value of: " + test.get("Steve"));
    }
}
