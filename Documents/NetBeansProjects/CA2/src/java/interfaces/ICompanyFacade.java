/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Company;
import java.util.List;

/**
 *
 * @author Kristian Nielsen
 */
public interface ICompanyFacade {
    Company getCompanyByName(String name);
    List<Company> getCompanies();
    List<Company> getCompaniesOverXEmp(int count);
    Company addCompany(Company company);
    Company editCompany(Company company);
    boolean deleteCompany(Company company);
   
}
