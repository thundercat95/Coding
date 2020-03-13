/*

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)

 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class K_Closest_Origin {

    public static void main(String args[]){
        int[][] points = {{3,3}, {5,-1}, {-2,4}};
        int K=2;

        int[][] result = kClosest(points, K);

        System.out.println(Arrays.deepToString(result));

    }

    public static int[][] kClosest(int[][] points, int K) {

        int[][] result = new int[K][2];

        PriorityQueue<int[]> pq = new PriorityQueue<int []>(
                (a,b) -> ((b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]))
        );

        for(int[] point: points){
            pq.add(point);
            if(pq.size()>K)
                pq.remove();
        }

        int i = 0;

        while (i<K) {
            result[i] = pq.remove();
            i++;
        }

        return result;
    }

}
