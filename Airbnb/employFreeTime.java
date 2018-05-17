public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
    List<Interval> result = new ArrayList<>();
    List<Interval> timeLine = new ArrayList<>();
    avails.forEach(e -> timeLine.addAll(e));
    Collections.sort(timeLine, ((a, b) -> a.start - b.start));

    Interval temp = timeLine.get(0);
    for(Interval each : timeLine) {
        if(temp.end < each.start) {
            result.add(new Interval(temp.end, each.start));
            temp = each;
        }else{
            temp = temp.end < each.end ? each : temp;
        }
    }
    return result;
}

class Solution {
  static class Point {
    int flag;
    int time;
    public Point(int time, int flag) {
      this.flag = flag;
      this.time = time;
    }
  }

  static class Interval {
    int start;
    int end;
    public Interval(int s, int e) {
      this.start = s;
      this.end = e;
    }
  }
  public List<Interval> getAvailableIntervals(List<List<Interval>> intervals, int k) {
    int m = intervals.size();
    List<Point> l = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (Interval iv : intervals.get(i)) {
        l.add(new Point(iv.start, 1));
        l.add(new Point(iv.end, -1));
      }
    }

    Collections.sort(l, (Point p1, Point p2) -> {
      if (p1.time == p2.time) return p1.flag - p2.flag;
      // have to sort flag too, when and do end time first and start time, (1, 3) (3, 4), it would consider end time first
      else return p1.time - p2.time;
    });
    int count = 0;
    int start = Integer.MAX_VALUE;
    int end = -1;
    List<Interval> res = new ArrayList<Interval>();
    for (int i = 0; i < l.size(); i++) {
      if (l.get(i).flag == 1) {
        count++;
      } else {
        count--;
      }
      if (count <= m - k) {
        start = Math.min(start, l.get(i).time);
      } else if (start != Integer.MAX_VALUE) {
        end = l.get(i).time;
      }
      if (start != Integer.MAX_VALUE && end != -1) {
        res.add(new Interval(start, end));
        start = Integer.MAX_VALUE;
        end = -1;
      }
    }
    if (start != Integer.MAX_VALUE && start != l.get(l.size() - 1).time) {
      res.add(new Interval(start, l.get(l.size() - 1).time));
    }
    return res;
  }

  public static void main(String[] args) {
    List<List<Interval>> intervals = new ArrayList<>();
    Interval i1 = new Interval(3, 4);
    Interval i2 = new Interval(6, 7);
    List<Interval> tmp = new ArrayList<>();
    tmp.add(i1);
    tmp.add(i2);
    intervals.add(tmp);

    Interval i3 = new Interval(2, 4);
    List<Interval> tmp1 = new ArrayList<>();
    tmp.add(i3);
    intervals.add(tmp1);

    Interval i4 = new Interval(1, 3);
    Interval i5 = new Interval(9, 12);
    List<Interval> tmp2 = new ArrayList<>();
    tmp.add(i4);
    tmp.add(i5);
    intervals.add(tmp2);

    Solution s = new Solution();
    for (Interval i : s.getAvailableIntervals(intervals, 1)) {
      System.out.print(i.start);
      System.out.print(",");
      System.out.println(i.end);
    }

  }

}
