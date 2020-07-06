import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;



    /*
        Time with RecursiveTask parallel: 6152
        Time with stream: 67
        Time with No Parallel: 6
        Time with parallel stream: 28
     */

public class FindMaxElementApp {
    static class MyDemoRecursiveTask extends RecursiveTask<Integer>{
        private int[] myArray;

        public MyDemoRecursiveTask(int[] myArray) {
            this.myArray = myArray;
        }

        @Override
        protected Integer compute() {
            if (myArray.length > 2) {
                List<MyDemoRecursiveTask> subtasks = createSubtasks();
                for (MyDemoRecursiveTask subtask : subtasks) {
                    subtask.fork();
                }
                int max_num =Integer.MIN_VALUE ;
                int current=0;
                for (MyDemoRecursiveTask subtask : subtasks) {
                    current=subtask.join();
                    if(current>max_num){
                        max_num=current;
                    }
                }
                return max_num;
            } else if(myArray.length==2) {
                //System.out.println("Calculation for: " + Arrays.toString(myArray) + " in thread " + Thread.currentThread().getName());
                return myArray[0]>myArray[1] ? myArray[0] :myArray[1];
            }else{
                return myArray[0];
            }

        }
        private List<MyDemoRecursiveTask> createSubtasks() {
            return new ArrayList<>(Arrays.asList(
                    new MyDemoRecursiveTask(Arrays.copyOfRange(myArray, 0, myArray.length / 2)),
                    new MyDemoRecursiveTask(Arrays.copyOfRange(myArray, myArray.length / 2, myArray.length))
            ));
        }

    }

    public static int maxNumberWithStream(int[] myArray){
        return Arrays.stream(myArray).max().getAsInt();
    }

    public static int maxNumberWithParallelStream(int[] myArray){
        return Arrays.stream(myArray).parallel().max().getAsInt();
    }

    public static int maxNumberWithNoStreamsNoParallel(int[] myArray){
        int maxWithNoParallel=Integer.MIN_VALUE;
        for(int i=0;i<1_000_000;i++){
            if(maxWithNoParallel<myArray[i]){
                maxWithNoParallel=myArray[i];
            }
        }
        return maxWithNoParallel;
    }



    public static void main(String[] args) {

        Random random=new Random();
        int[] array=new int[100_000_000];
        for(int i=0;i<100_000_000;i++){
            array[i]=random.nextInt(100_000);
        }

        //DemoRecursive test
        MyDemoRecursiveTask myDemoRecursiveTask=new MyDemoRecursiveTask(array);
        long time = System.currentTimeMillis();
        long maxNumWithParallel= ForkJoinPool.commonPool().invoke(myDemoRecursiveTask);
        System.out.println("Time with RecursiveTask parallel: " + (System.currentTimeMillis() - time));


        //Stream test
        time=System.currentTimeMillis();
        long maxWithStream=maxNumberWithStream(array);
        System.out.println("Time with stream: " + (System.currentTimeMillis() - time));


        //No Parallel No Stream test
        time=System.currentTimeMillis();
        int maxWithNoParallel=maxNumberWithNoStreamsNoParallel(array);
        System.out.println("Time with No Parallel: " + (System.currentTimeMillis() - time));


        //Parallel stream test
        time=System.currentTimeMillis();
        long maxWithParallelStream=maxNumberWithParallelStream(array);
        System.out.println("Time with parallel stream: " + (System.currentTimeMillis() - time));


    }

}


