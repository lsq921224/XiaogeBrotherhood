public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i=0;
        while(i<intervals.size() && intervals.get(i).end<newInterval.start) i++;// both are inclusive
        while(i<intervals.size() && intervals.get(i).start<=newInterval.end){//both are inclusive
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start),
                                       Math.max(intervals.get(i).end, newInterval.end));
            intervals.remove(i);
        }
        intervals.add(i,newInterval);
        return intervals;
}
