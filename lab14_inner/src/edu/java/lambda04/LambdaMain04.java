package edu.java.lambda04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaMain04 {
    
    public static void main(String[] args) {
        // Employee를 원소로 갖는 리스트를 선언
        int result = 0;
        
        List<Employee> employees = Arrays.asList(
                new Employee(100, "이존규", "개발자", "개발1팀", 300),
                new Employee(101, "김지훈", "개발자", "개발2팀", 301),
                new Employee(201, "김용훈", "개발자", "개발2팀", 302),
                new Employee(202, "김가영", "디자이너", "개발1팀", 303),
                new Employee(301, "최은정", "디자이너", "개발2팀", 400),
                new Employee(500, "추지훈", "부사장", "인사팀", 1000)
                );
        
        // Ex 1. 모든 직원들의 정보를 한 줄에 한 명씩 출력.
        
        //-----for-each 문장-----//
        for (Employee x : employees) {
            System.out.println(x);
        }
        
        System.out.println();
        
        
        //-----stream 이용-----//
        employees.stream().forEach(x -> {System.out.println(x);});
        
        System.out.println();
        employees.stream().forEach(System.out::println); // 변수가 단 하나라면...
        
        System.out.println();
        System.out.println();

        
        // Ex 2. job이 "개발자"인 직원들의 급여 합계를 출력
        
        List<Integer> list1 = employees.stream()
                .filter(x -> x.getJob().equals("개발자"))
                .map(x -> x.getSalary())
                .collect(Collectors.toList());
        
        for (int x : list1) {
            result += x;
        }
        System.out.println(result);
        System.out.println();
        
        result = employees.stream()
                .filter(e -> e.getJob().equals("개발자"))
                .mapToInt(Employee::getSalary) //.mapToInt(e -> e.getSalary())
                .sum();
  
        
        System.out.println("sum = " + result);
        
        result = 0;
        
        
        
        
        System.out.println();
        
        result = 0 ;
        
        for (Employee e: employees) {
            if (e.getJob().equals("개발자")) {
                result += e.getSalary();
            }
        }
    
        System.out.println(result);
        
        
        // Ex 3. dept가 "개발2팀"인 직원들의 급여 평균을 출력.
        result = 0;
        int count = 0 ;
        
        for (Employee e : employees) {
            if (e.getDept().equals("개발2팀")) {
                result += e.getSalary();
                count++;
            }
        }
        double mean = (double) result / count;
        System.out.println("mean = " + mean);
        
        result = 0 ;
        count = 0 ;
        
        double mean2 = 0.0;
        
        List<Integer> list2 = employees.stream()
                .filter(x -> x.getDept().equals("개발2팀"))
                .map(x -> x.getSalary())
                .collect(Collectors.toList());
        
        for (int x : list2) {
            result += x;
        }
        result /= (double) list2.size();
        System.out.println(result);
        
        
        System.out.println();
        System.out.println();
        
        mean2 = employees.stream()
                .filter(e -> e.getDept().equals("개발2팀"))
                .mapToInt(Employee::getSalary)
                .average()
//                .getAsDouble(); // Optional -> Double
                .orElse(0); // Optional --> Double, 평균을 계산할 수 없을 경우 0.
//                .orElseThrow(); // Optional -> 정상적인 값 또sms Exception
        System.out.println("문제= = = " + mean2);
        
        
        
        
        
        
        
        
        // Ex 4. 급여가 400 이상인 직원들의 정보를 한 줄씩 출력.
        
        employees.stream()
                .filter(x -> x.getSalary() >= 400)
                .forEach(System.out::println); // 변수가 없어도.. 가능..
//        
//        for (Employee x : list3) {
//            System.out.println(x);
//        }
    }// 메인 닫음
    

} // 클래스 닫음
