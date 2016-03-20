/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Company;
import entity.Person;
import interfaces.ICompanyFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Kristian Nielsen
 */
public class CompanyFacade implements ICompanyFacade {

    
    EntityManager em = EntManGetter.getEntMan();
    
    

    @Override
    public List<Company> getCompanies() {
        String query = "SELECT c FROM Company c";
        return em.createQuery(query).getResultList();
    }

    @Override
    public Company getCompanyByName(String name) {
        return (Company) em.createNamedQuery("Company.FindByName").setParameter("name", name).getSingleResult();
    }

    @Override
    public Company addCompany(Company company) {
        em.getTransaction().begin();
        em.persist(company);
        em.getTransaction().commit();
        return company;
    }

    @Override
    public Company editCompany(Company company) {
        em.getTransaction().begin();
        em.merge(company);
        em.getTransaction().commit();
        return company;
    }

    @Override
    public boolean deleteCompany(Company company) {
        em.remove(company);
        Company c2 = em.find(Company.class, company);
        if(c2 == null) return true;
        return false;
    }

    @Override
    public List<Company> getCompaniesOverXEmp(int count) {
        String query = "SELECT c FROM Company c WHERE c.numEmployees > " + count;
        return em.createQuery(query).getResultList();
    }

    
    
    
    
}
