package edu.java.lambda04;

public class Employee {
    private Integer empId; // 사번
    private String name; // 이름
    private String job; // 직무
    private String dept; // 부서
    private Integer salary; // 급여
    
    public Employee() {}
    
    // 모든 필드를 초기화하는 생성자
    public Employee(Integer empId, String name, String job, String dept, Integer salary) {
        this.empId = empId;
        this.name = name;
        this.job = job;
        this.dept = dept;
        this.salary = salary;
    }

    // getter/setters
    
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    
    // toStirng 재정의
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("사원 정보 : (사번 = %d, 이름 = %s, 직무 = %s, 부서 = %s, 급여 = %d)", this.empId, this.name, this.job, this.dept, this.salary);
    }

}
