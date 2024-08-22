package io.github.terminalemployeemanager.dao;
import io.github.terminalemployeemanager.model.Employee;
import lombok.Getter;
import lombok.Setter;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@Setter
@Getter
public class EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> findAll(){
        return jdbcTemplate.query("SELECT * FROM employees",
                new EmployeeRowMapper());
    }

    public Optional<Employee> findById(int id){
        try{
            Employee employee = jdbcTemplate.queryForObject(
                    "SELECT * FROM employees WHERE id = ?",
                    new Object[]{id},
                    new EmployeeRowMapper());
            return Optional.of(employee);
        }catch (EmptyResultDataAccessException e){
            return Optional.empty();
        } catch (Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public int addEmployee(String name, String role){
        String query = "INSERT INTO employees(name, role) VALUES(?, ?)";
        Employee employee = new Employee(name, role);
        return jdbcTemplate.update(query, employee.getName(),employee.getRole());
    }

    public int deleteEmployee(int id){
        String query = "DELETE FROM employees WHERE id = ?";
        return jdbcTemplate.update(query, id);
    }

    public class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setRole(rs.getString("role"));
            return employee;
        }
    }


}
