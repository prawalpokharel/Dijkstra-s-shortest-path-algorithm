package HashMap;

public class DsAlgorithm {
    /*Compute the shortest path for all of the given vertices:
    1) Find the min distance vertex from the set of vertices we have not visited yet
    Note: If the vertex is marked as true, we have visited it.
    2) Update the distance values of all neighboring vertices of the selected vertex
    3) Update distance[loc] if and only if it is not in the
        PathArray, there is a shorter path from the source to the vertex
    * */
    public static int[] Dijkstra(int graph[][], int s, int distanceArr[], int VNum){
        //PathArray[j] will be true if the given vertex j
        //is included in the shortest path tree from origin to j
        Boolean PathArray[] = new Boolean[VNum];

        //Initializing distances = INFINITE PathArray[] = false
        for(int j=0; j<VNum; j++){
            distanceArr[j] = Integer.MAX_VALUE;
            PathArray[j] = false;
        }
        distanceArr[s] = 0;

        for(int i =0; i< VNum-1; i++){
            int minIndex = minimumDistance(distanceArr, PathArray, VNum);
            PathArray[minIndex] = true;

            for(int j=0; j<VNum;j++){
                if(!PathArray[j] && graph[minIndex][j]!= -1
                        && distanceArr[minIndex] != Integer.MAX_VALUE
                        && (distanceArr[minIndex] + graph[minIndex][j])<distanceArr[j])
                {
                    distanceArr[j] = distanceArr[minIndex] + graph[minIndex][j];
                }
            }
        }
        return distanceArr;
    }

    //Compute the main distance value between a vertex and other vertices
    public static int minimumDistance(int distance[], Boolean PathArray[], int VNum){
        //Let the min be an integer max value and index begins with -1
        int minimum = Integer.MAX_VALUE;
        int MinimumIndex = -1;

        for(int i=0; i<VNum; i++){
            //compare values and keep the minimum
            if(PathArray[i] == false && distance[i] <= minimum){
                minimum = distance[i];
                MinimumIndex = i;
            }
        }
        return MinimumIndex;
    }
}
