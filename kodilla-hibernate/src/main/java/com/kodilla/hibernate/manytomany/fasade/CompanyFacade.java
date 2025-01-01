package com.kodilla.hibernate.manytomany.fasade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyFacade {


    private final CompanyDao companyDao;

    @Autowired
    public CompanyFacade(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public List<Company> findCompaniesByPrefix(String prefix) {
        return companyDao.getCompaniesByKeywordSubstring(prefix);
    }

    public List<Company> findCompaniesByFragment(String nameFragment) {
        String keyword = "%" + nameFragment + "%";
        return companyDao.getCompaniesByKeywordLike(keyword);
    }
}

