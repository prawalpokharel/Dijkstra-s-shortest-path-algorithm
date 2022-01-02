//Name:Prawal Pokharel
//CSCI 308 Adv Data Structures and algorithms
//Date: 11/12/2021
package HashMap;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int VertexNumber = 9;

    public static void main(String[] args) {
	int n = 6;
	int distanceArr[] = new int[VertexNumber];
	//Here matrix is an ArrayList of Arraylists
        ArrayList<ArrayList<Character>> matrix = new ArrayList<>(n);
        ArrayList<ArrayList<Character>> graph = new ArrayList<>(n);
        char vArray[] = {'A','B','C','D','E','F'};
        char eArray[] = {'a','b','c','d','e','f','g','h','i'};
        int a[] = new int [50];
        int i = 0;
        int AdjMatrix[][] = new int[][] {
                { -1, 3, -1, -1, -1, -1, -1, 7, -1 },
                { 3, -1, 7, -1, -1, -1, -1, 10, 4 },
                { -1, 7, -1, 6, -1, 2, -1, -1, 1 },
                { -1, -1, 6, -1, 8, 13, -1, -1, 3 },
                { -1, -1, -1, 8, -1, 9, -1, -1, -1 },
                { -1, -1, 2, 13, 9, -1, 4, -1, 5 },
                { -1, -1, -1, -1, -1, 4, -1, 2, 5 },
                { 7, 10, -1, -1, -1, -1, 2, -1, 6 },
                { -1, 4, 1, 3, -1, 5, 5, 6, -1 }
        };


        graph = PopulateGraph(graph,vArray,eArray);
        matrix = PopulateMatrix(matrix,vArray,eArray,graph);

        PrintArray(matrix, vArray);
        distanceArr = DsAlgorithm.Dijkstra(AdjMatrix, 0, distanceArr, VertexNumber);
        printDistances(distanceArr);

    }
    //Displaying the distance array
    public static void printDistances(int distance[]){
        System.out.println("The shortest distance from origin/root node at location 0 to your specific node can be calculated below: ");
        System.out.println("What node do you want to calculate shortest distance to from the root node? You can select 0 to 8");
        Scanner scan = new Scanner(System.in);
        int c = scan.nextInt();
        System.out.println("To "+ c + " the shortest distance is: " + distance[c]);


    }
    public static ArrayList<ArrayList<Character>>
    PopulateGraph(ArrayList<ArrayList<Character>> graph, char[] vArray, char[] eArray){
        for(int i=0; i< eArray.length; i++){
            ArrayList<Character>a2 = new ArrayList<>();
            for(int j=0; j< eArray.length; j++){
                a2.add(eArray[j]);
            }
            graph.add(a2);
        }
        return graph;
    }
    public static ArrayList<ArrayList<Character>>
    PopulateMatrix(ArrayList<ArrayList<Character>> matrix, char[] vArray, char[] eArray, ArrayList<ArrayList<Character>> graph){
        Scanner scan = new Scanner(System.in);
        char data;
        for(int i=0; i< vArray.length; i++){
            ArrayList<Character>a3 = new ArrayList<>();
            for(int j=0; j< vArray.length; j++){
                System.out.println("Provide data: ");
                data = scan.next().charAt(0);
                a3.add(data);
            }
            matrix.add(a3);

        }


        return matrix;
    }
    public static ArrayList<ArrayList<Character>>
    InitializeMatrix(int n, ArrayList<ArrayList<Character>> matrix){
        for(int i=0; i<n; i++){
            ArrayList<Character>a1 = new ArrayList<>();
            for(int j=0; j<n; j++){
                a1.add('0');
            }
            matrix.add(a1);
        }
        return matrix;
    }
    public static void PrintArray(ArrayList<ArrayList<Character>> aList, char vArray[]){
        System.out.print(" ");
        for(int i=0; i<vArray.length;i++){
            System.out.print(vArray[i] + " ");
        }
        System.out.println("\n-------------------");
        for(int i = 0; i < aList.size(); i++){
            System.out.print(vArray[i]);
            System.out.print(" | ");
            for(int j =0; j< aList.get(i).size(); j++){
                System.out.print(aList.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println("\n----------------------");
    }
}
