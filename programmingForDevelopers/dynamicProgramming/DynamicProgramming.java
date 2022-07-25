package programmingForDevelopers.dynamicProgramming;

import java.util.HashMap;

public class DynamicProgramming {

    int fib(int n ){
        if(n<=2){
            return 1;
        }
        return  fib(n-1)+fib(n-2);
    }

    int fibo(int n, HashMap<Integer,Integer> map){
        if(n<=2){
            return 1;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        int value=  fibo(n-1,map)+fibo(n-2,map);
        map.put(n,value);
        return value;
    }

    public static void main(String [] args){
        DynamicProgramming d=new DynamicProgramming();

        HashMap<Integer,Integer> map=new HashMap<>();
        System.out.println(d.fibo(5,map));
        System.out.println(d.fibo(13,map));
        System.out.println(d.fibo(100,map));

    }

}
