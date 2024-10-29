package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyDaoTests {

  @Autowired
  private CompanyDao companyDao;

  @Autowired
  private EmployeeDao employeeDao;

  @Test
  void testSaveManyToMany() {
    //Given
    Employee johnSmith = new Employee("John", "Smith");
    Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
    Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

    Company softwareMachine = new Company("Software Machine");
    Company dataMasters = new Company("Data Masters");
    Company greyMatter = new Company("Grey Matter");

    softwareMachine.getEmployees().add(johnSmith);
    dataMasters.getEmployees().add(stephanieClarckson);
    dataMasters.getEmployees().add(lindaKovalsky);
    greyMatter.getEmployees().add(johnSmith);
    greyMatter.getEmployees().add(lindaKovalsky);

    johnSmith.getCompanies().add(softwareMachine);
    johnSmith.getCompanies().add(greyMatter);
    stephanieClarckson.getCompanies().add(dataMasters);
    lindaKovalsky.getCompanies().add(dataMasters);
    lindaKovalsky.getCompanies().add(greyMatter);

    //When
    companyDao.save(softwareMachine);
    int softwareMachineId = softwareMachine.getId();
    companyDao.save(dataMasters);
    int dataMastersId = dataMasters.getId();
    companyDao.save(greyMatter);
    int greyMatterId = greyMatter.getId();

    //Then
    assertNotEquals(0, softwareMachineId);
    assertNotEquals(0, dataMastersId);
    assertNotEquals(0, greyMatterId);

    //CleanUp
    //try {
    //    companyDao.deleteById(softwareMachineId);
    //    companyDao.deleteById(dataMastersId);
    //    companyDao.deleteById(greyMatterId);
    //} catch (Exception e) {
    //    //do nothing
    //}
  }

  @Test
  void testGetEmployeeByLastName() {
    // Given
    Employee johnSmith = new Employee("John", "Smith");
    Employee patricSmith = new Employee("Patric", "Smith");
    employeeDao.save(johnSmith);
    employeeDao.save(patricSmith);

    // When
    List<Employee> employees = employeeDao.getEmployerByLastName("Smith");

    // Then
    try {
      assertFalse(employees.isEmpty());
    } finally {
      // CleanUp
      employeeDao.delete(johnSmith);
      employeeDao.delete(patricSmith);
    }
  }

  @Test
  void testGetCompaniesByKeyword() {
    // Given

    Company company1 = new Company("Green Solutions");
    Company company2 = new Company("Greenwave Innovations");
    Company company3 = new Company("Greenspark Enterprises");
    Company company4 = new Company("Grey Matter");

    // When
    companyDao.save(company1);
    companyDao.save(company2);
    companyDao.save(company3);
    companyDao.save(company4);

    List<Company> companies = companyDao.getCompaniesByKeyword("Gre");

    // Then
    try {
      assertFalse(companies.size() == 3);
    } finally {
      // CleanUp
      companyDao.delete(company1);
      companyDao.delete(company2);
      companyDao.delete(company3);
      companyDao.delete(company4);
    }
  }
}
