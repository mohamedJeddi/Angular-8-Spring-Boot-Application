package com.example.springbootemployeemock.Controller;

import com.example.springbootemployeemock.domain.Employe;
import com.example.springbootemployeemock.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employees")
public class EmployeController {

    private List<Employe> employeList = createList();

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Employe> getEmployeList() {
        return employeList;
    }

    @GetMapping(produces = "application/json")
    @RequestMapping({ "/validateLogin" })
    public User validateLogin() {
        return new User("User successfully authenticated");
    }

    @DeleteMapping("/{id}")
    public Employe delete(@PathVariable int id) {
        Employe deletedEmp = null;
        for (Employe emp : employeList) {
            if (emp.getEmpId().equals(id)) {
                employeList.remove(emp);
                deletedEmp = emp;
                break;
            }
        }
        return deletedEmp;
    }

    @PostMapping()
    public Employe create(@RequestBody Employe employe) {
        employeList.add(employe);
        System.out.println(employeList);
        return employe;
    }

    private static List<Employe> createList() {
        List<Employe> tempEmployees = new ArrayList<>();
        Employe emp1 = new Employe();
        emp1.setName("emp1");
        emp1.setDesignation("manager");
        emp1.setEmpId("1");
        emp1.setSalary(3000);

        Employe emp2 = new Employe();
        emp2.setName("emp2");
        emp2.setDesignation("developer");
        emp2.setEmpId("2");
        emp2.setSalary(3000);
        tempEmployees.add(emp1);
        tempEmployees.add(emp2);
        return tempEmployees;
    }

}
