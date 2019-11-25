import { Component, OnInit } from '@angular/core';
import { EmployeeService } from './../services/employee.service';
import { Employee } from './../model/Employee';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  public employees:Employee[];

  constructor(private employeeService: EmployeeService) { }

  ngOnInit() {
    this.employeeService.getEmployees().subscribe((data: any) => {
      this.employees = data
    });
  }

  deleteEmploye(employee: Employee): void {
    this.employeeService.deleteEmployee(employee).subscribe((data:any) => {
      this.employees = this.employees.filter(emp => emp !== employee);
    })
  }

}
