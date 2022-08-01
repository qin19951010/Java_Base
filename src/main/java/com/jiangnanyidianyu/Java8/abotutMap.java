package com.jiangnanyidianyu.Java8;

import com.jiangnanyidianyu.Java8.Pojo.Employee;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author QinZhongliang
 * @date 2022年07月29日 10:00 AM
 */
public class abotutMap {

    List<Employee> getAllEmployees(){
        ArrayList<Employee> arrayList = new ArrayList<>();

        arrayList.add(new Employee("大壮","上海公司","研发一部",28,3000));
        arrayList.add(new Employee("二牛","上海公司","研发一部",24,2000));
        arrayList.add(new Employee("铁柱","上海公司","研发二部",34,5000));
        arrayList.add(new Employee("翠花","南京公司","测试一部",27,3000));
        arrayList.add(new Employee("玲玲","南京公司","测试二部",31,4000));

        return arrayList;
    }

    @Test
    public void testComputeIfAbsent(){
        //先筛选
        List<Employee> employees = getAllEmployees().stream()
                .filter(employee -> "上海公司".equals(employee.getSubCompany()))
                .collect(Collectors.toList());

        //再分组
        Map<String, List<Employee>> resultMap = new HashMap<>();
        for (Employee employee : employees) {
            List<Employee> groupList = resultMap
                    .computeIfAbsent(employee.getDepartment(), k -> new ArrayList<>());
            groupList.add(employee);
        }
        System.out.println(resultMap);
    }

    @Test
    public void filterEmployeesThenGroupByStream() {
        Map<String, List<Employee>> resultMap = getAllEmployees().stream()
                .filter(employee -> "上海公司".equals(employee.getSubCompany()))
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(resultMap);
    }

    @Test
    public void toSet() {
        Set<Employee> employeeSet = getAllEmployees().stream()
                .filter(employee -> "上海公司".equals(employee.getSubCompany()))
                .collect(Collectors.toSet());
        System.out.println(employeeSet);
    }

    @Test
    public void toSummingInt() {
        //计算上海公司每个月的总工资
        Integer salarySum = getAllEmployees().stream()
                .filter(employee -> "上海公司".equals(employee.getSubCompany()))
                .collect(Collectors.summingInt(Employee::getSalary));
        System.out.println("上海公司员工每月总薪水===>" + salarySum);
    }

    @Test
    public void toMax() {
        //计算上海公司每个月的总工资
        Optional<Employee> optional = getAllEmployees().stream()
                .filter(employee -> "上海公司".equals(employee.getSubCompany()))
                .max(Comparator.comparingInt(Employee::getSalary));
        System.out.println("上海公司员工最高薪水===>" + optional.get());
    }

    @Test
    public void toGroupingBy() {
        //按公司对员工分组
        Map<String, List<Employee>> map = getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getSubCompany));
        System.out.println(map);
    }

    @Test
    public void toGroupingByCount() {
        //按照子公司分组，并统计每个子公司的员工数
        Map<String, Long> collect = getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getSubCompany, Collectors.counting()));
        System.out.println(collect);
    }

    @Test
    public void nested() {
        //现有整个集团全体员工的列表，需要统计各子公司内各部门下的员工人数。
        Map<String, Map<String, Long>> collect = getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getSubCompany,
                        Collectors.groupingBy(Employee::getDepartment, Collectors.counting())));
        System.out.println(collect);
    }

    @Test
    public void collectAndThen() {
        //给定集团所有员工列表，找出上海公司中工资最高的员工。
        Optional<Employee> employee = getAllEmployees().stream()
                .filter(e -> "上海公司".equals(e.getSubCompany()))
                .collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)));
        System.out.println(employee.get());
    }

    @Test
    public void collectAndThenPro() {
        Employee employeeResult = getAllEmployees().stream()
                .filter(employee -> "上海公司".equals(employee.getSubCompany()))
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)),
                                Optional::get)
                );
        System.out.println(employeeResult);
    }
}
