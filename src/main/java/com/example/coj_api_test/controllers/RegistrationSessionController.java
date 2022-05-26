package com.example.coj_api_test.controllers;


import com.example.coj_api_test.models.*;
import com.example.coj_api_test.services.RegistrationSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping(path= "api/registrationsession")
public class RegistrationSessionController {

    private final RegistrationSessionService registrationSessionService;

    @Autowired
    public RegistrationSessionController(RegistrationSessionService registrationSessionService) {
        this.registrationSessionService = registrationSessionService;
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping
    @ResponseBody
    public List<RegistrationSession> getRegistrationSession() {
        return registrationSessionService.getAllRegistrationSession();
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/total-l-info-daily")
    @ResponseBody
    public List<TotalLInfo> getTotaluserInfoDaily(@RequestParam String date) {
        return registrationSessionService.getTotalLInfoDaily(date);
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/change-device-info-daily")
    @ResponseBody
    public List<ChangeDeviceInfo> getChangeDeviceInfoDaily(@RequestParam String date) {
        return registrationSessionService.getChangeDeviceInfoDaily(date);
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/verify-register-info-daily")
    @ResponseBody
    public List<VerifyRegisterInfo> getVerifyRegisterInfoDaily(@RequestParam String date) {
        return registrationSessionService.getVerifyRegisterInfoDaily(date);
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/total-l-info-monthly")
    @ResponseBody
    public List<TotalLInfo> getTotaluserInfoMonthly(@RequestParam String startdate,@RequestParam String enddate) {
        return registrationSessionService.getTotalLInfoMonthly(startdate,enddate);
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/change-device-info-monthly")
    @ResponseBody
    public List<ChangeDeviceInfo> getChangeDeviceInfoMonthly(@RequestParam String startdate,@RequestParam String enddate) {
        return registrationSessionService.getChangeDeviceInfoMonthly(startdate,enddate);
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/verify-register-info-monthly")
    @ResponseBody
    public List<VerifyRegisterInfo> getVerifyRegisterMonthly(@RequestParam String startdate,@RequestParam String enddate) {
        return registrationSessionService.getVerifyRegisterInfoMonthly(startdate,enddate);
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/createddate")
    @ResponseBody
    public List<List<List<String>>> getVerifyRegisterMonthly(@RequestParam String date) {
        return registrationSessionService.getDateTotalUser(date);
    }



}
