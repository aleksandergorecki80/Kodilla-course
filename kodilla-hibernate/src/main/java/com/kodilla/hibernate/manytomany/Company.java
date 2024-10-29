package com.kodilla.hibernate.manytomany;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@NamedNativeQuery(
    name = "Company.getCompaniesByKeyword",
    query = "SELECT * FROM COMPANIES WHERE SUBSTRING(company_name, 1, 3) = :KEYWORD",
    resultClass = Company.class
)
@Entity
@Table(name = "COMPANIES")
public class Company {
  private int id;
  private String name;
  private List<Employee> employees = new ArrayList<>();

  public Company() {
  }

  public Company(String name) {
    this.name = name;
  }

  @Id
  @GeneratedValue
  @NotNull
  @Column(name = "COMPANY_ID", unique = true)
  public int getId() {
    return id;
  }

  @NotNull
  @Column(name = "COMPANY_NAME")
  public String getName() {
    return name;
  }

  public void setId(final int id) {
    this.id = id;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(final List<Employee> employees) {
    this.employees = employees;
  }
}
