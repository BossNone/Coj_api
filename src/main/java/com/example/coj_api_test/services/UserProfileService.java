package com.example.coj_api_test.services;

import com.example.coj_api_test.models.AccountInfo;
import com.example.coj_api_test.models.UserProfile;
import com.example.coj_api_test.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository){
        this.userProfileRepository = userProfileRepository;
    }

    public List<AccountInfo> getAccountInfoDaily(String date) {
        LocalDateTime localDateTime = LocalDateTime.parse(date+"T00:00:00");
        String dailystart = localDateTime.minusHours(7).toString();
        String dailyend = localDateTime.plusHours(16).plusMinutes(59).plusSeconds(59).toString();
        List<AccountInfo> response;
        try{
            response = List.of(
                    new AccountInfo(
                            userProfileRepository.getTotalActiveUserDaily(dailystart,dailyend)+userProfileRepository.getTotalInactiveUserDaily(dailystart,dailyend),
                            userProfileRepository.getTotalActiveUserDaily(dailystart,dailyend),
                            userProfileRepository.getTotalInactiveUserDaily(dailystart,dailyend)
                    )
            );
        }catch (Exception e){
            response = List.of(
                    new AccountInfo(
                            0,0,0
                    )
            );
        }
        return response;
    }

    public List<AccountInfo> getAccountInfoMonthly(String startdate,String enddate) {
        LocalDateTime startlocalDateTime = LocalDateTime.parse(startdate+"T00:00:00");
        LocalDateTime endlocalDateTime = LocalDateTime.parse(enddate+"T00:00:00");
        String start = startlocalDateTime.minusHours(7).toString();
        String end = endlocalDateTime.plusHours(16).plusMinutes(59).plusSeconds(59).toString();
        List<AccountInfo> response;
        try{
            response = List.of(
                    new AccountInfo(
                            userProfileRepository.getTotalActiveUserMonthly(start,end)+userProfileRepository.getTotalInactiveUserMonthly(start,end),
                            userProfileRepository.getTotalActiveUserMonthly(start,end),
                            userProfileRepository.getTotalInactiveUserMonthly(start,end)
                    )
            );
        }catch (Exception e){
            response = List.of(
                    new AccountInfo(
                            0,0,0
                    )
            );
        }
        return response;
    }
    public List<UserProfile> getAllUserProfile() {return userProfileRepository.findAll();}
}
