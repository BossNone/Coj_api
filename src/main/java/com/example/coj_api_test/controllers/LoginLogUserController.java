package com.example.coj_api_test.controllers;

import com.example.coj_api_test.models.LoginInfo;
import com.example.coj_api_test.models.LoginLogUser;
import com.example.coj_api_test.services.LoginLogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping(path = "api/loginloguser")
public class LoginLogUserController {

    private final LoginLogUserService loginLogUserService;

    @Autowired
    public LoginLogUserController(LoginLogUserService loginLogService){
        this.loginLogUserService = loginLogService;
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping
    public List<LoginLogUser> getLoginLog() {
        return loginLogUserService.getAllLoginlog();
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/daily")
    @ResponseBody
    public List<LoginInfo> getDaily(@RequestParam String date) {
        if(date == null) {
            throw new HandlerException(new Throwable());
        }
        return loginLogUserService.getLoginInfoDaily(date);
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/monthly")
    @ResponseBody
    public List<LoginInfo> getMonthly(@RequestParam String startdate,@RequestParam String enddate) {
        if(startdate == null && enddate == null) {
            throw new HandlerException(new Throwable());
        }
        return loginLogUserService.getLoginInfoMonthly(startdate,enddate);
    }

}
