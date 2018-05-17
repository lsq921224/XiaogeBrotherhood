//Some specail cases
// for 23333, pour at last, it should go to index 0;
// for 33333, pour at last, it should go to last;
// for 12345, pour at alst, it should go to first;
public int[] pourWater(int[] heights, int V, int K) {
        if (heights == null || heights.length == 0 || V == 0) {
            return heights;
        }
        int index;
        while (V > 0) {
            index = K;
            // don't use while loop for this,
            for (int i = K - 1; i >= 0; i--) {
                if (heights[i] > heights[index]) {
                    break;
                } else if (heights[i] < heights[index]) {
                    index = i;
                }
            }
            if (index != K) {
                heights[index]++;
                V--;
                continue;
            }
            for (int i = K + 1; i < heights.length; i++) {
                if (heights[i] > heights[index]) {
                    break;
                } else if (heights[i] < heights[index]) {
                    index = i;
                }
            }
            heights[index]++;
            V--;
        }
        return heights;
    }



    // Follow up, what if the boundary is small
class Solution {
  public void pourWater(int[] heights, int water, int location) {
    int n = heights.length;
    int[] h = new int[n + 2];
    for (int i = 0; i < n; i++) {
      h[i + 1] = heights[i];
    }
    int[] waters = new int[n + 2];
    waters[0] = -1;
    waters[n + 1] = -1;
    while(water > 0) {
      boolean goLeft = false;
      int idx = location + 1;
      // For Loop 比较好
      for (int i = location; i >= 0; i--) {
        //记住 是和中间比
        if (waters[i] + h[i] > waters[idx] + h[idx]) {
          break;
        } else if (waters[i] + h[i] < waters[idx] + h[idx]) {
          idx = i;
        }
      }
      if (idx != location + 1) {
        waters[idx]++;
        water--;
        continue;
      }

      for (int i = location + 2; i < n + 1; i++) {
        if (waters[i] + h[i] > waters[idx] + h[idx]) {
          break;
        } else if (waters[i] + h[i] < waters[idx] + h[idx]) {
          idx = i;
        }
      }
      waters[idx]++;
      water--;
      waters[0] = -1;
      waters[n + 1] = -1;
    }

    print(h, waters);
  }

  private void print(int[] heights, int[] water) {
    int max = 0;
    for (int i = 0; i < heights.length; i++) {
      max = Math.max(heights[i] + water[i], max);
    }
    for (int h = max; h > 0; h--) {
      for (int i = 0; i < heights.length; i++) {
        if (heights[i] >= h) {
          System.out.print("+");
        } else if (heights[i] < h && h <= heights[i] + water[i]) {
          System.out.print("W");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  public static void main(String args[]) {
    int[] heights = new int[]{4,1,3,5};
    Solution s = new Solution();
    int[] waters = new int[heights.length];
    s.pourWater(heights, 5, 2);
  }

}
