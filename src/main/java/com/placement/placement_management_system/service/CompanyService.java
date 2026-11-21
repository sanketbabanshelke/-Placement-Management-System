
package com.placement.placement_management_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.placement.placement_management_system.entity.Company;
import com.placement.placement_management_system.repository.CompanyRepository;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // Save Company
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    // Get All Companies
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // Get Company By ID
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElse(null);
    }

    // Update Company
    public Company updateCompany(Long id, Company updatedCompany) {

        Company existingCompany = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        existingCompany.setCompanyName(updatedCompany.getCompanyName());
        existingCompany.setEmail(updatedCompany.getEmail());
        existingCompany.setPhone(updatedCompany.getPhone());
        existingCompany.setLocation(updatedCompany.getLocation());
        existingCompany.setWebsite(updatedCompany.getWebsite());

        return companyRepository.save(existingCompany);
    }

    // Delete Company
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
