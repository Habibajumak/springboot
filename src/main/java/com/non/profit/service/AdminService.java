package com.non.profit.service;


import com.non.profit.model.Admin;
import com.non.profit.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements  AdminServices{
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public Admin saveAdmin(Admin admin){
        return  adminRepository.save(admin);
    }
}
