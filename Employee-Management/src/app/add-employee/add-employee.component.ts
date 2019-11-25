import { Component, OnInit } from '@angular/core';
import { EmployeeService } from './../services/employee.service';
import { Employee } from '../model/Employee';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  public employee: Employee = new Employee("","","","");
  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit() {
  }

  createEmployee() {
    this.employeeService.addEmploye(this.employee).subscribe((data: any) => {
      alert("Employee created successfully.");
      this.router.navigate(['/employees']);
    });
  }

}
