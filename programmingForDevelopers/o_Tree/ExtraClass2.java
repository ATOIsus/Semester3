package programmingForDevelopers.o_Tree;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class task implements Callable<String> {

    @Override
    public String call(){
        System.out.println("executing task");
        System.out.println(Thread.currentThread().getName());
        return "hello";
    }

}


public class ExtraClass2 {


    void executeTask(){
        ExecutorService service= Executors.newFixedThreadPool(10);

        for(int i=0;i<100;i++){
//

            service.execute((Runnable) new task());
        }
    }

    public static void main(String [] args){
        new ExtraClass2().executeTask();

        CompletableFuture<String> future=CompletableFuture.supplyAsync(
                ()-> {
                    try{
                      Thread.sleep(1000000);
                    }
                    catch (Exception ee){ee.printStackTrace();}

                    return "hello";
                }
        ).thenApply(name->{
          name=name+" world";
            System.out.println(name);
            return name;
        });



    }

}
