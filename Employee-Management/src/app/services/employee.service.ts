import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from './../model/Employee';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private endpoint = 'http://localhost:8080/employees';

  constructor(private http : HttpClient) { }

  getEmployees() : Observable<any> {
    let username='javainuse'
    let password='password'
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.http.get(this.endpoint,{headers});
  }

  addEmploye(employee: Employee) : Observable<any> {
    return this.http.post<Employee>(this.endpoint, employee);
  }

  deleteEmployee(employee: Employee): Observable<any> {
    return this.http.delete(this.endpoint + '/' + employee.empId);
  }
}
