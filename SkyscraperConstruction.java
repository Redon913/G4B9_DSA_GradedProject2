//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.Stack;
//
//public class SkyscraperConstruction {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the total number of floors in the building");
//        int N = scanner.nextInt();
//        ArrayList<Integer> sizes = new ArrayList<>();
//
//        for (int i = 0; i < N; i++) {
//            System.out.println("Enter the floor size given on day " + (i + 1));
//            sizes.add(scanner.nextInt());
//        }
//
//        ArrayList<ArrayList<Integer>> constructionOrder = constructSkyscraper(N, sizes);
//
//        System.out.println("The order of construction is as follows");
//        for (int i = 0; i < N; i++) {
//            System.out.println("Day: " + (i + 1));
//            ArrayList<Integer> floorSizes = constructionOrder.get(i);
//            for (int j = 0; j < floorSizes.size(); j++) {
//                System.out.print(floorSizes.get(j));
//                if (j < floorSizes.size() - 1) {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println();
//        }
//    }
//
//    public static ArrayList<ArrayList<Integer>> constructSkyscraper(int N, ArrayList<Integer> sizes) {
//        ArrayList<ArrayList<Integer>> constructionOrder = new ArrayList<>();
//        Stack<Integer> largerFloors = new Stack<>();
//
//        for (int i = 0; i < N; i++) {
//            int size = sizes.get(i);
//            ArrayList<Integer> floorSizes = new ArrayList<>();
//
//            while (!largerFloors.isEmpty() && largerFloors.peek() > size) {
//                floorSizes.add(largerFloors.pop());
//            }
//
//            largerFloors.push(size);
//            constructionOrder.add(floorSizes);
//        }
//
//        return constructionOrder;
//    }
//}

import java.util.*;

class MyComparator implements Comparator<Integer> {
    public int compare(Integer i1, Integer i2) {
        return i2.compareTo(i1);
    }
}

public class SkyscraperConstruction {
    public static void main(String[] args) {
    	boolean flag = true;
    	
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of floors in the building");
        int n = sc.nextInt();
        int constructionOrder[] = new int[n];
        int max = n;
        Queue<Integer> queue = new PriorityQueue<>(new MyComparator());
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the floor size given on day " + (i + 1));
            constructionOrder[i] = sc.nextInt();
        }
        System.out.println("The order of construction is as follows\r\n"
        		+ "");
        for(int i = 0; i < n;i++) {
        	System.out.println("Day: " + (i + 1));
        	queue.add(constructionOrder[i]);
        	while (!queue.isEmpty() && queue.peek() == max) {
            	System.out.print(queue.poll() + " ");
                max--;
            }
        	System.out.println(" ");
        }
    }
}
