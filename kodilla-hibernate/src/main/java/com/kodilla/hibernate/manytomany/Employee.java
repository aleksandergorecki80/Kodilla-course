package com.kodilla.hibernate.manytomany;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@NamedQueries({
    @NamedQuery(
        name = "Employee.getEmployerByLastName",
        query = "FROM Employee WHERE lastName = :LAST_NAME"
    ),
})
@Entity
@Table(name = "EMPLOYEES")
public class Employee {
  private int id;
  private String firstName;
  private String lastName;
  private List<Company> companies = new ArrayList<>();

  public Employee() {
  }

  public Employee(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Id
  @GeneratedValue
  @NotNull
  @Column(name = "EMPLOYEE_ID")
  public int getId() {
    return id;
  }

  @NotNull
  @Column(name = "FIRST_NAME")
  public String getFirstName() {
    return firstName;
  }

  @NotNull
  @Column(name = "LAST_NAME")
  public String getLastName() {
    return lastName;
  }

  private void setId(final int id) {
    this.id = id;
  }

  private void setFirstName(final String firstName) {
    this.firstName = firstName;
  }


  private void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "JOIN_COMPANY_EMPLOYEE",
      joinColumns = {@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")},
      inverseJoinColumns = {@JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID")}
  )
  public List<Company> getCompanies() {
    return companies;
  }

  public void setCompanies(List<Company> companies) {
    this.companies = companies;
  }
}
