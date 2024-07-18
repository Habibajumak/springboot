package com.non.profit.controller;

import com.non.profit.model.Admin;
import com.non.profit.service.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminServices adminServices;

    @PostMapping("/add")
    public  String SaveAdmin(@RequestBody Admin admin){
        adminServices.saveAdmin(admin);
        return  "Admin added";
    }
}
