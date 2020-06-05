package com.tss.sample.snippet;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.tss.operations.MinMaxComparator;
import com.tss.sample.model.Employee;

public class StreamOperations {

    public static void main(String[] args) {

        System.out.println(new Date());

        List<Integer> asortedIntList = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);
        Map<String, Employee> stringMap = new HashMap<String, Employee>();
        stringMap.put("A", new Employee(1, "Tom", "Java", OffsetDateTime.now()));
        stringMap.put("B", new Employee(2, "Bom", "API", OffsetDateTime.now()));
        stringMap.put("C", new Employee(3, "Dodge", "Angular", OffsetDateTime.now()));
        stringMap.put("D", new Employee(4, "Ram", "Java", OffsetDateTime.now()));
        stringMap.put("E", new Employee(5, "Deana", "SQL", OffsetDateTime.now()));
        stringMap.put("F", new Employee(6, "Sam", "Angular", OffsetDateTime.now()));

        // Getting Hash Map Keys in List
        List<String> keyList = stringMap.keySet().stream().collect(Collectors.toList());

        // Getting Hash Map Values in List
        List<Employee> valueList = stringMap.values().stream().collect(Collectors.toList());

        // Filter Employees having department 'Java' and store it to new filtered list
        List<Employee> javaEmployees = valueList.stream().filter(e -> e.getDepartment().equalsIgnoreCase("java"))
                .collect(Collectors.toList());

        // Collect all EmployeeId's in list
        List<Integer> employeeIds = valueList.stream().map(e -> e.getId()).collect(Collectors.toList());

        // Collect all/(or with filter) EmployeeId's in list casting each to String
        List<String> employeeIdsInString = valueList.stream().filter(e -> e.getId() > 3)
                .map(e -> String.valueOf(e.getId())).collect(Collectors.toList());

        // Collect All Employee Objects into map key=id and value=object
        Map<Integer, Employee> employeeMap = valueList.stream().collect(HashMap::new,
                (map, emp) -> map.put(emp.getId(), emp), HashMap::putAll);
        // OR
        Map<Integer, Employee> employeeMap1 = valueList.stream()
                .collect(Collectors.toMap(Employee::getId, Function.identity()));

        // Collect all even number Employee Id objects in to list
        List<Employee> empEventList = valueList.stream().filter(emp -> emp.getId() % 2 == 0)
                .collect(Collectors.toList());

        // iterate list and map elements to lower case
        Set<String> listKeyLowerCase = keyList.stream().map(e -> e.toLowerCase()).collect(Collectors.toSet());

        // OR
        Set<String> listKeyLowerCase1 = keyList.stream().map(String::toLowerCase).collect(Collectors.toSet());

        // anyMatch/allMatch/noneMatch from List Element
        boolean elementMatched = keyList.stream().anyMatch(e -> e.equalsIgnoreCase("z"));

        // match count
        long endsWith_om_count = valueList.stream().filter(emp -> emp.getName().endsWith("om")).count();

        // find first Object
        Employee firstMatchedObject = valueList.stream().filter(emp -> emp.getName().endsWith("om")).findFirst().get();

        // Limit & Skip
        List<Employee> listWithLimitSkip = valueList.stream().skip(3).limit(2).collect(Collectors.toList());

        // find min from list
        Optional<Integer> min = asortedIntList.stream().min((i, j) -> i.compareTo(j));
        // OR
        Optional<Integer> min1 = asortedIntList.stream().min(new MinMaxComparator());

        // find min from list
        Optional<Integer> max = asortedIntList.stream().max((i, j) -> i.compareTo(j));
        // OR
        Optional<Integer> max1 = asortedIntList.stream().max(new MinMaxComparator());

        System.out.println(min.get() + "," + min1.get() + "," + max.get() + "," + max1.get());

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        /*
         * list1.add(1); list1.add(3); list1.add(4); list1.add(5); list1.add(2); list1.add(1);
         * 
         * list2.add(3); list2.add(2); list2.add(5); list2.add(1); list2.add(4);
         */

        Collections.sort(list1);
        Collections.sort(list2);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list1.equals(list2));

    }
}