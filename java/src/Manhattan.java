import java.util.*;

public class Manhattan {
    public static int totalArea(int[] s, int[] e, int[] h) {
        class EventComparator implements Comparator<Integer> {
            public int compare(Integer event1, Integer event2) {
                int decodedEvent1 = 0;
                int decodedEvent2 = 0;
                
                if (event1 > 0) {
                    decodedEvent1 = e[event1 - 1];
                }
                if (event1 <= 0) {
                    decodedEvent1 = s[-1 - event1];
                }
                if (event2 > 0) {
                    decodedEvent2 = e[event2 - 1];
                }
                if (event2 <= 0) {
                    decodedEvent2 = s[-1 - event2];
                }
                return Integer.compare(decodedEvent1, decodedEvent2);
            }
        }

        List<Integer> events = new ArrayList<>();
        for (int b = 0; b < s.length; b++) {
            events.add(-1 - b);
            events.add(b + 1);
        }

        events.sort(new EventComparator());

        Set<Integer> active = new HashSet<>();
        int previousEvent = 0;
        int totalArea = 0;
        for (int event : events) {
            int currentEvent;
            if (event > 0) {
                currentEvent = e[event - 1];
            } else {
                currentEvent = s[-1 - event];
            }

            int tallest = 0;
            for (int building : active) {
                tallest = Math.max(h[building], tallest);
            }
            totalArea += (currentEvent - previousEvent) * tallest;
            previousEvent = currentEvent;

            if (event > 0) {
                active.remove(event - 1);
                continue;
            }
            active.add(-1 - event);
        }

        return totalArea;
    }
}
