//package com.voting.Controller;
//
//import com.voting.Model.AdminAuth;
//import com.voting.Service.AdminAuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/admin-auth")
//public class AdminAuthController {
//    @Autowired
//    private AdminAuthService adminAuthService;
//
//    // Endpoint for admin login (POST operation)
//    @PostMapping("/login")
//    public AdminAuth adminLogin(@RequestBody AdminAuth admin) {
//        return adminAuthService.adminLogin(admin.getPassword());
//    }
//
//    // Endpoint to create an admin (for initial setup)
//    @PostMapping("/create")
//    public AdminAuth createAdmin(@RequestBody AdminAuth admin) {
//        return adminAuthService.createAdmin(admin);
//    }
//}
//
//
//
//package com.voting.Controller;
//
//import com.voting.Model.AdminAuth;
//import com.voting.Service.AdminAuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/admin-auth")
//public class AdminAuthController {
//    @Autowired
//    private AdminAuthService adminAuthService;
//
//    @PostMapping("/login")
//    public AdminAuth adminLogin(@RequestBody AdminAuth admin) {
//        return adminAuthService.adminLogin(admin.getPassword());
//    }
//
//    @PostMapping("/create")
//    public AdminAuth createAdmin(@RequestBody AdminAuth admin) {
//        return adminAuthService.createAdmin(admin);
//    }
//    
//    @GetMapping("")
//    public String testAdminAuth() {
//        return "Admin Auth Endpoint is working!";
//    }
//}
package com.voting.Controller;

import com.voting.Model.AdminAuth;
import com.voting.Service.AdminAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin-auth")
public class AdminAuthController {
    @Autowired
    private AdminAuthService adminAuthService;

    
    @GetMapping("")
    public String testAdminAuth() {
        return "Admin Auth Endpoint is working!";
    }

    // Login endpoint
    @PostMapping("/login")
    public AdminAuth adminLogin(@RequestBody AdminAuth admin) {
        return adminAuthService.adminLogin(admin.getPassword());
    }

    // Create admin endpoint
    @PostMapping("/create")
    public AdminAuth createAdmin(@RequestBody AdminAuth admin) {
        return adminAuthService.createAdmin(admin);
    }

    // Update admin endpoint
    @PutMapping("/{id}")
    public AdminAuth updateAdmin(@PathVariable Long id, @RequestBody AdminAuth admin) {
        return adminAuthService.updateAdmin(id, admin);
    }

    // Delete admin endpoint
    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminAuthService.deleteAdmin(id);
    }
}
