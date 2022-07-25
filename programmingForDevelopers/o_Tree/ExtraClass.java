package programmingForDevelopers.o_Tree;

class downloadimage{
     synchronized  void download(String imagename){
        for(int i=0;i<10;i++){
            System.out.println("downloading image #image"+imagename+i+".jpg");
        }
    }
}

class thread1 extends Thread{
    downloadimage downloadimage;
    thread1(downloadimage downloadimage){
        this.downloadimage=downloadimage;
    }

    @Override
    public void run(){

        downloadimage.download("dog");
    }

}


class thread2 extends Thread{
    downloadimage downloadimage;
    thread2(downloadimage downloadimage){
        this.downloadimage=downloadimage;
    }

    @Override
    public void run(){

        downloadimage.download("cat");
    }

}
class myTask implements Runnable{


    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("downloading image #image"+i+".jpg");
        }
    }
}
public class ExtraClass {
    public static void main(String [] args){

        System.out.println("downloading image");
//       myTask t=new myTask();
//       t.start();
        downloadimage d=new downloadimage();
        thread1 t1=new thread1(d);

        thread2 t2=new thread2(d);
        t1.start();
//        try{
//            t1.join();
//        }
//        catch (Exception ee){ee.printStackTrace();}
        t2.start();


        System.out.println("finished downloading image");
    }

}
