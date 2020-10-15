/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oozeander.dao;

import com.oozeander.model.Employee;
import java.util.List;

/**
 *
 * @author Oozeander (aka Billel KETROUCI°
 */
public interface EmployeeDao {

    List<Employee> get();

    Employee get(Long id);

    void save(Employee employee);

    void update(Long id, Employee employee);

    void delete(Long id);
}
