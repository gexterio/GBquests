package ru.gb.gexterio;

public class Main {
    public static void main(String[] args) {
        ArrCalc arrCalc = new ArrCalc();
        arrCalc.monoCore();

        Thread t1 = new Thread(() -> {
            long a = System.currentTimeMillis();
          arrCalc.firstHalfCore();
            System.out.println("multiCore: " + (System.currentTimeMillis() - a)+ " ms");
        });
        Thread t2 = new Thread(() -> {
            long a = System.currentTimeMillis();
          arrCalc.secondHalfCore();
            System.out.println("multiCore: " + (System.currentTimeMillis() - a)+ " ms");
        });
        t1.start();
        t2.start();
        if (!t1.isAlive() && !t2.isAlive()) {
            arrCalc.compareArr(arrCalc.f1, arrCalc.f2);
        }
    }

}
 class ArrCalc {
      final int SIZE = 10_000_000;
      final int HALF = SIZE / 2;
      float[] arr =generateArr();
      float[] f1;
      float[] f2;

     float[] generateArr () {
         float[] arr = new float[SIZE];
         for (int i = 0; i < arr.length; i++) {
             arr[i] = 1.0f;
         }
         return arr;
     }


      void monoCore() {
         long a = System.currentTimeMillis();
         for (int i = 0; i < arr.length; i++) {
             arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                     Math.cos(0.4f + i / 2));
         }
         System.out.println("monoCore: " + (System.currentTimeMillis() - a)+ " ms");
     }

     void firstHalfCore () {
        float [] f1 = new float[HALF];
         for (int i = 0; i < f1.length; i++) {
             f1[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                     Math.cos(0.4f + i / 2));
         }
     }
     void secondHalfCore () {
        float [] f2 = new float[HALF];
         for (int i = 0; i < f2.length; i++) {
             f2[i] = (float)(arr[i+HALF] * Math.sin(0.2f + (i+HALF) / 5) * Math.cos(0.2f + (i+HALF) / 5) *
                     Math.cos(0.4f + (i+HALF)/ 2));
         }
     }

     void compareArr(float[] f1, float [] f2) {
         float [] finalArr = new float[f1.length+f2.length];
         for (int i = 0; i < finalArr.length; i++) {
             if (i<HALF) {
                 finalArr[i] = f1[i];
             } else if (i>=HALF) {
                 finalArr[i] = f2[i-HALF];

             }
         }
     }

 }