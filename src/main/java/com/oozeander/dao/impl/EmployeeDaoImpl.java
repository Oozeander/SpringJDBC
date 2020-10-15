/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oozeander.dao.impl;

import com.oozeander.dao.EmployeeDao;
import com.oozeander.model.Employee;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Oozeander (aka Billel KETROUCI°
 */
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
    @SuppressWarnings("unused")
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final static BeanPropertyRowMapper EMPLOYEE_ROW_MAPPER
            = BeanPropertyRowMapper.newInstance(Employee.class);

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Employee> get() {
        String sql = "SELECT * FROM default_schema.users";
        return jdbcTemplate.query(sql, EMPLOYEE_ROW_MAPPER);
    }

    @Override
    public Employee get(Long id) {
        String sql = "SELECT * FROM default_schema.users WHERE id = ?";
        return (Employee) jdbcTemplate.queryForObject(sql, new Object[]{id}, EMPLOYEE_ROW_MAPPER);
    }

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO default_schema.users(id, firstname, lastname) VALUES(:id, :firstname, :lastname)";

        SqlParameterSource dataMap = new MapSqlParameterSource()
                .addValue("id", employee.getId())
                .addValue("firstname", employee.getFirstname())
                .addValue("lastname", employee.getLastname());

        int result = namedParameterJdbcTemplate.update(sql, dataMap);
        if (result > 0) {
            System.out.println(employee.getLastname() + " " + employee.getFirstname() + " has been successfully saved");
        } else
            System.out.println(employee.getLastname() + " " + employee.getFirstname() + " has not been saved, an error occured");
   }

    @Override
    public void update(Long id, Employee employee) {
        String sql = "UPDATE default_schema.users SET firstname = :firstname, lastname = :lastname WHERE id = :id";

        SqlParameterSource dataMap = new MapSqlParameterSource()
                .addValue("id", employee.getId())
                .addValue("firstname", employee.getFirstname())
                .addValue("lastname", employee.getLastname());

        int result = namedParameterJdbcTemplate.update(sql, dataMap);
        if (result > 0) {
            System.out.println(employee.getLastname() + " " + employee.getFirstname() + " has been successfully updated");
        } else {
            System.out.println(employee.getLastname() + " " + employee.getFirstname() + " has not been updated, an error occured");
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM default_schema.users WHERE id = ?";

        int result = jdbcTemplate.update(sql, new Object[]{id});
        if (result > 0) {
            System.out.println("Employee N°" + id + " has been successfully deleted");
        } else {
            System.out.println("Employee N°" + id + " has not been deleted, an error occured");
        }
    }
}
