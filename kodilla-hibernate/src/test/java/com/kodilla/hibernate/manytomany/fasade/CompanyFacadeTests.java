package com.kodilla.hibernate.manytomany.fasade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CompanyFacadeTests {

    @Autowired
    private CompanyFacade companyFacade;

    @Autowired
    private CompanyDao companyDao;

    @Test
    void testFindCompaniesByPrefix() {
        // Given
        Company company1 = new Company("Green Solutions");
        Company company2 = new Company("Greenwave Innovations");
        Company company3 = new Company("InnerGreenSpace");
        Company company4 = new Company("Grow Matter");

        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);
        companyDao.save(company4);

        // When
        List<Company> companies = companyFacade.findCompaniesByPrefix("Gre");

        // Then
        assertEquals(2, companies.size());
        companyDao.deleteAll();
    }

    @Test
    void testFindCompaniesByFragment() {
        // Given
        Company company1 = new Company("Green Solutions");
        Company company2 = new Company("Greenwave Innovations");
        Company company3 = new Company("InnerGreenSpace");
        Company company4 = new Company("Grow Matter");

        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);
        companyDao.save(company4);

        // When
        List<Company> companies = companyFacade.findCompaniesByFragment("green");

        // Then
        assertEquals(3, companies.size());
        companyDao.deleteAll();
    }
}
