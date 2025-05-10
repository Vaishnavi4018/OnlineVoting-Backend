//package com.voting.Service;
//
//import com.voting.Model.AdminAuth;
//import com.voting.Repository.AdminAuthRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class AdminAuthService {
//    @Autowired
//    private AdminAuthRepository adminAuthRepository;
//
//    // Method to authenticate admin (POST operation for login)
//    public AdminAuth adminLogin(String password) {
//        Optional<AdminAuth> admin = adminAuthRepository.findByPassword(password);
//        if (admin.isPresent()) {
//            return admin.get();
//        }
//        throw new RuntimeException("Invalid admin password");
//    }
//
//    // Method to create an admin (for initial setup)
//    public AdminAuth createAdmin(AdminAuth admin) {
//        return adminAuthRepository.save(admin);
//    }
//}
package com.voting.Service;

import com.voting.Model.AdminAuth;
import com.voting.Repository.AdminAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminAuthService {
    @Autowired
    private AdminAuthRepository adminAuthRepository;

    // Authenticate admin
    public AdminAuth adminLogin(String password) {
        Optional<AdminAuth> admin = adminAuthRepository.findByPassword(password);
        if (admin.isPresent()) {
            return admin.get();
        }
        throw new RuntimeException("Invalid admin password");
    }

    // Create admin
    public AdminAuth createAdmin(AdminAuth admin) {
        return adminAuthRepository.save(admin);
    }

    // Update admin
    public AdminAuth updateAdmin(Long id, AdminAuth admin) {
        Optional<AdminAuth> existingAdmin = adminAuthRepository.findById(id);
        if (existingAdmin.isPresent()) {
            AdminAuth updatedAdmin = existingAdmin.get();
            updatedAdmin.setPassword(admin.getPassword());
            // Add other fields to update as needed
            return adminAuthRepository.save(updatedAdmin);
        }
        throw new RuntimeException("Admin not found with id: " + id);
    }

    // Delete admin
    public void deleteAdmin(Long id) {
        Optional<AdminAuth> admin = adminAuthRepository.findById(id);
        if (admin.isPresent()) {
            adminAuthRepository.deleteById(id);
        } else {
            throw new RuntimeException("Admin not found with id: " + id);
        }
    }
}