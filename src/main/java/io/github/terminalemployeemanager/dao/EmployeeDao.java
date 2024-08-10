package io.github.terminalemployeemanager.dao;
import io.github.terminalemployeemanager.Model.Employee;
import lombok.Getter;
import lombok.Setter;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    public Employee findById(int id){
        try{
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM employees WHERE id = ?",
                    new Object[]{id},
                    new EmployeeRowMapper());
        }catch (EmptyResultDataAccessException e){
            return null;
        }

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
