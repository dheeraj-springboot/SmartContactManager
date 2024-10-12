package com.Smartmanager26.SCM2.o.constrollers;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;
class HelloWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Try programiz.pro");
        int next= scanner.nextInt();
        int[] arrayis = new int[next];
        for(int i=0;i<next;i++){
            int a =scanner.nextInt();
            arrayis[i]=a;
        }
        int sum=next;
        int a= arrayis[0]+(arrayis[1]-arrayis[0])*next-1;
        int sumer=(next*(2*arrayis[0]+(next-1)*(arrayis[1]-arrayis[0])))/2 ;
        int adding=0;
        for(int i=0;i<next;i++){
            adding+=arrayis[i];
        }
        if(a==arrayis[next-1] && sumer==adding){
            for(int i=0;i<next;i++){
                sum=0;
                sum+=i;
            }
            
        }
        else{
        for(int i=0;i<next-1;i++){
            
           // int is=0;
            if(arrayis[i]>arrayis[i+1]){
                
                sum+=1;
            }
            else if( arrayis[i]<arrayis[i+1]){
                sum+=1;
            }
            else if(arrayis[i+1]==arrayis[i]){
                continue;
            }
            
        }
        System.out.println(sum);
    }
}
}