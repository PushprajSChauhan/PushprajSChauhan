/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmngmnt.pojo;

/**
 *
 * @author PUSHPRAJ
 */
public class Employee {
    private int empNo;
    private String empName;
    private double empSal;

    public int getEmpNo() {
        return empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public double getEmpSal() {
        return empSal;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }

    public Employee(int empNo, String empName, double empSal) {
        this.empNo = empNo;
        this.empName = empName;
        this.empSal = empSal;
    }

    public Employee() {
    }
//    YAHA SETTERS AND CONSTRUCTORS DONO ISLIYE DIYE GAYE HAIN TAAKI HAME FLEXIBILITY MILE DATA KO POJO MEI INSERT KRNE KELIYE
}
