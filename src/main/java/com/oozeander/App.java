/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oozeander;

import com.oozeander.model.Employee;
import com.oozeander.service.EmployeeService;
import java.util.Arrays;
import java.util.List;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Oozeander (aka Billel KETROUCI°
 */
public class App {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-jdbc.xml");
        //new AnnotationConfigApplicationContext(new Class<?>[]{JavaConfig.class});
        ctx.registerShutdownHook();

        List<Employee> employees = Arrays.asList(
                new Employee(1l, "Billel", "KETROUCI"),
                new Employee(2l, "El Bakay", "BOURAJOINI"),
                new Employee(3l, "Meriem", "KECHEROUD")
        );

        EmployeeService service = ctx.getBean(EmployeeService.class);
        employees.stream().forEach(service::save);
        System.out.println(service.get());
        service.update(1l, new Employee(1l, "Oozeander", "Billel KETROUCI"));
        System.out.println(service.get(1l));
        service.delete(3l);
        System.out.println(service.get());

        ctx.close();
    }
}
