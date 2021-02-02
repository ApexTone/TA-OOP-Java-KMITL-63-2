package Lab04;

import Lab03.PalindromicPrime;

/*
* Testcase
* Correctness
* */

public class StopWatch {
    private double startTime, endTime;
    public StopWatch(){
        this.startTime = System.currentTimeMillis();
        this.endTime = System.currentTimeMillis();
    }

    public double getStartTime() {
        return startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void start(){
        this.startTime = System.currentTimeMillis();
        this.endTime = System.currentTimeMillis();
    }
    public void stop(){
        this.endTime = System.currentTimeMillis();
    }
    public double getElapsedTime(){
        return this.endTime - this.startTime;
    }

    public static void main(String[] args) {
        StopWatch sw = new StopWatch();

        //random sort
        System.out.println("Random Sorting");

        final int COUNT = 1000;
        double[] lst = new double[COUNT];
        System.out.printf("Creating %d-element lists...\n",COUNT);
        for(int i=0;i<COUNT;i++){
            lst[i] = Math.random()*1000;
            System.out.printf("%.2f ",lst[i]);
            if(i%10 == 9){
                System.out.println();
            }
        }
        System.out.println("List created");
        System.out.println("Sorting stopwatch starts...");
        sw.start();
        for(int i=0;i<COUNT-1;i++){
            int minIndex = i;
            for(int j=i+1;j<COUNT;j++){
                if(lst[minIndex] > lst[j]){
                    minIndex = j;
                }
            }
            double temp = lst[i];
            lst[i] = lst[minIndex];
            lst[minIndex] = temp;
        }
        sw.stop();
        System.out.println("Sorting stopwatch stops...");
        for(int i=0;i<COUNT;i++){
            System.out.printf("%.2f ",lst[i]);
            if(i%10 == 9){
                System.out.println();
            }
        }
        System.out.printf("The sort time is %.1f ms\n", sw.getElapsedTime());

        //PalindromicPrime Gen
        System.out.println("PalindromicPrime Generating");
        sw.start();
        PalindromicPrime.getNPalindromicPrime(100);
        sw.stop();
        System.out.printf("Elapsed Time %.1f ms\n", sw.getElapsedTime());
    }
}