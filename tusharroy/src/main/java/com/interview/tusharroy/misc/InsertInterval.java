package com.interview.tusharroy.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 03/21/2016
 *
 * @author Tushar Roy
 * <p>
 * Insert internal into sorted intervals and merge them.
 * <p>
 * Time complexity O(n)
 * <p>
 * https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {

    public static void main(String args[]) {
        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(6, 7);
        Interval i3 = new Interval(9, 10);
        Interval i4 = new Interval(11, 12);
        List<Interval> input = new ArrayList<>();
        input.add(i1);
        input.add(i2);
        input.add(i3);
        input.add(i4);
        InsertInterval ii = new InsertInterval();
        System.out.println(ii.insert(input, new Interval(13, 15)));
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        boolean alreadyAdded = false;
        for (int i = 0; i < intervals.size(); i++) {
            if ((intervals.get(i).end < newInterval.start)) {
                result.add(intervals.get(i));
            } else if (intervals.get(i).start > newInterval.end) {
                if (!alreadyAdded) {
                    result.add(newInterval);
                    alreadyAdded = true;
                }
                result.add(intervals.get(i));
            } else {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
                if (!alreadyAdded) {
                    result.add(newInterval);
                    alreadyAdded = true;
                }
            }
        }
        if (!alreadyAdded) {
            result.add(newInterval);
        }
        return result;
    }

    public static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
