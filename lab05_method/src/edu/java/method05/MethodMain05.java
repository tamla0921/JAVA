package edu.java.method05;

public class MethodMain05 {

    public static void main(String[] args) {
        // 메서드 작성 연습
        
        int[] scores = {70, 60, 100, 50, 81};
        
        int sum = sum(scores);
        System.out.println("총점 = "+ sum); // 360
        
        double avg = mean(scores);
        System.out.println("평균 = " + avg); // 72.0
        
        int max = max(scores);
        System.out.println("최댓값 = " + max); // 100
        
        int min = min(scores);
        System.out.println("최솟값 = " + min); // 50
        
        double var = variance(scores);
        System.out.println("분산 = " + var);
        
        double std = standardDeviation(scores);
        System.out.println("표준편차 = " + std);
        
        System.out.println("표준편차 = " + standardDeviation(scores));

    }
    
    public static int sum(int[] x) {
        int n = 0;
        for (int i = 0 ; i < x.length ; i++) {
            n += x[i];
        }
        return n;
        
//         int sum = 0;
//          for (int i : x) {
//          sum += i;
//          }
//          return sum;      
    }
    
    public static double mean(int[] x) {
        double sum = sum(x); 
        return sum / x.length;
    }
    
    public static int max(int[] x) {
        int n = x[0];
        for (int i : x) {
            n = (i > n) ? i : n;
        }
        return n;
        
        
    }
    public static int min(int[] x) {
        int n = x[0];
        for (int i : x) {
            n = (i < n) ? i : n;
        }
        return n;
        
    }
    
    public static double variance(int[] array) {
        // 데이터: {x1, x2, ..., xn)
        // 평균: mu = (x1 + x2 + ... + xn) / n
        // 분산: var = ((x1 - mu)^2 + (x2 - mu)^2 + ... + (xn - mu)^2) / n
        // 표준편차: std = sqrt(var) // 분산의 단위는 원래의 단위의 제곱이 되기 때문에(예: cm -> cm^2) 단위가 달라짐. 따라서 표준편차를 해서 다시 단위를 맞출 수 있다.
        
        double mu = mean(array);
        double total = 0;
        for (int x : array) {
            total += (x - mu) * (x - mu);
        }
        double var = total / array.length;
        
        return var;
        
    }
    
    public static double standardDeviation(int[] array) {
        return Math.sqrt(variance(array));
    }
    

}
