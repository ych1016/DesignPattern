package com.wangzai.study.sixprinciple.demeter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 杨灿杭
 * @Description
 * @create 2025-03-24 11:03
 */
public class DemeterErrorDemo {
    public static void main(String[] args) {
        SubCompanyManager subCompanyManager = new SubCompanyManager(100);
        CompanyManager companyManager = new CompanyManager(100);
        companyManager.printAllEmployee(subCompanyManager);
    }
}

// 总公司员工
@Data
class Employee {
    private String id;
}

// 分公司员工
@Data
class SubEmployee {
    private String id;
}

@Data
class SubCompanyManager {
    private List<SubEmployee> subEmployees;
    private Integer cnt;

    public SubCompanyManager(Integer cnt) {
        subEmployees = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            SubEmployee subEmployee = new SubEmployee();
            subEmployee.setId("分公司员工" + i);
            subEmployees.add(subEmployee);
        }
    }

    // 提供打印所有员工的方法
    public void printEmployeeList() {
        for (SubEmployee subEmployee : this.subEmployees) {
            System.out.println(subEmployee);
        }
    }
}

@Data
class CompanyManager {
    private List<Employee> employees;
    private Integer cnt;

    public CompanyManager(int cnt) {
        employees = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            Employee employee = new Employee();
            employee.setId("总公司员工" + i);
            this.employees.add(employee);
        }
    }

    private void printEmployee() {
        for (Employee employee : this.employees) {
            System.out.println(employee);
        }
    }

    public void printAllEmployee(SubCompanyManager subCompanyManager) {
        /**
         * 1. 先打印分公司员工
         * 2. 再打印总公司员工
         */
        // 这里就存在问题了，因为SubEmployee是 SubCompanyManager中的私有变量，通过这种方式引入到CompanyManager中，耦合度变高了
        List<SubEmployee> subEmployeeList = subCompanyManager.getSubEmployees();
        for (SubEmployee subEmployee : subEmployeeList) {
            System.out.println(subEmployee);
        }
        printEmployee();
    }

    public void printAllEmployeeCorrect(SubCompanyManager subCompanyManager) {
        /**
         * 1. 先打印分公司员工
         * 2. 再打印总公司员工
         */
        subCompanyManager.printEmployeeList();
        printEmployee();
    }
}