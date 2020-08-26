package test;

import java.util.Scanner;

public class _01 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr =new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(arr[j] < arr[i]){
                    count++;
                    min = arr[i] < min?arr[i]:min;
                    break;
                }
            }
        }
        if(count == 0){
            System.out.println(count);
        }
        else{
            int k = n-1;
            while(k>0){
                if(arr[k] > min && arr[k] > arr[k-1]){
                    count++;
                    k--;
                }
               else
                    break;
            }
            System.out.println(count);
        }
    }
}
