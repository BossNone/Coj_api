package com.example.coj_api_test.controllers;

import com.example.coj_api_test.models.AccountInfo;
import com.example.coj_api_test.models.UserProfile;
import com.example.coj_api_test.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping(path = "api/userprofile")
public class UserProfileController {

    private final UserProfileService userProfileService;

    @Autowired
    public UserProfileController(UserProfileService userProfileService){
        this.userProfileService = userProfileService;
    }

    @GetMapping
    public List<UserProfile> getUserProfile(){
        return userProfileService.getAllUserProfile();
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/account-info-daily")
    @ResponseBody
    public List<AccountInfo> getAccountInfoDaily(@RequestParam String date) {return userProfileService.getAccountInfoDaily(date);}

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/account-info-monthly")
    @ResponseBody
    public List<AccountInfo> getAccountInfoMonthly(@RequestParam String startdate,@RequestParam String enddate) {return userProfileService.getAccountInfoMonthly(startdate,enddate);}
}
