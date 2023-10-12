/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmngmnt.dao;

import empmngmnt.dbutil.DBConnection;
import empmngmnt.pojo.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PUSHPRAJ
 */
public class EmpDAO {
    public static boolean addEmployee(Employee e) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into employees values(?,?,?)");
        
        ps.setInt(1, e.getEmpNo());
        ps.setString(2, e.getEmpName());
        ps.setDouble(3, e.getEmpSal());
        
        int result=ps.executeUpdate();
        return result==1;
//        AGAR RESULT MEI SAHI MEI 1 RHA TOH CONDITION TRUE RETURN KREGI, AGAR 0 RHA TOH CONDITION FALSE RETURN KREGI
//        if(result==1)
//            return true;
//        else
//            return false;
    }
    
    public static Employee findEmployeeByID(int empNo) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from employees where empno=?");
        
        ps.setInt(1, empNo);
        ResultSet rs=ps.executeQuery();
        
        Employee e=null;
        if(rs.next()){
            e=new Employee();
            e.setEmpNo(rs.getInt(1));
            e.setEmpName(rs.getString(2));
            e.setEmpSal(rs.getDouble(3));
        }
        return e;
    }
    
    public static ArrayList<Employee> getAllEmployees() throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from employees order by empno");
         
        ArrayList<Employee> empList=new ArrayList<>();
//        YAHA TIGHT COUPLING KARI H ISLIYE ARRAYLIST KE REFERENCE KO HI RETURN KRENGE ISS METHOD SE
        while(rs.next()){
            Employee e=new Employee();
            e.setEmpNo(rs.getInt(1));
            e.setEmpName(rs.getString(2));
            e.setEmpSal(rs.getDouble(3));             
            empList.add(e);
         }
        return empList;
    }
    
    public static boolean updateEmployee(Employee e) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update employees set ename=?,sal=? where empno=?");
        
        ps.setString(1,e.getEmpName());
        ps.setDouble(2,e.getEmpSal());
        ps.setInt(3,e.getEmpNo());
        int result=ps.executeUpdate();
        
        return result==1;
    }
    
    public static boolean deleteEmployee(int empNo) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("delete from employees where empno=?");
        
        ps.setInt(1, empNo);
        int result=ps.executeUpdate();
        
        return result==1;
    }
}
