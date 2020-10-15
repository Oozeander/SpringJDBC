/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oozeander.service.impl;

import com.oozeander.dao.EmployeeDao;
import com.oozeander.model.Employee;
import com.oozeander.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Oozeander (aka Billel KETROUCI°
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> get() {
        return employeeDao.get();
    }

    @Override
    public Employee get(Long id) {
        return employeeDao.get(id);
    }

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void update(Long id, Employee employee) {
        employeeDao.update(id, employee);
    }

    @Override
    public void delete(Long id) {
        employeeDao.delete(id);
    }

}
