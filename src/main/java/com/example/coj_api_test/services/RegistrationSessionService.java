package com.example.coj_api_test.services;

import com.example.coj_api_test.models.*;
import com.example.coj_api_test.repository.RegistrationSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistrationSessionService {

    private final RegistrationSessionRepository registrationSessionRepository;

    @Autowired
    public RegistrationSessionService(RegistrationSessionRepository registrationSessionRepository){
        this.registrationSessionRepository = registrationSessionRepository;
    }

    public List<VerifyRegisterInfo> getVerifyRegisterInfoDaily(String date) {

        LocalDateTime localDateTime = LocalDateTime.parse(date+"T00:00:00");
        String dailystart = localDateTime.minusHours(7).toString();
        String dailyend = localDateTime.plusHours(16).plusMinutes(59).plusSeconds(59).toString();
        return List.of(new VerifyRegisterInfo(
                registrationSessionRepository.getCountIsNewTypeOfUserDaily("eKYC",dailystart,dailyend),
                registrationSessionRepository.getCountIsNewTypeOfUserDaily("PHYSICAL",dailystart,dailyend),
                registrationSessionRepository.getCountIsNewTypeOfUserDaily("NDID",dailystart,dailyend),
                registrationSessionRepository.getCountIsNewTypeOfUserDaily("D.DOPA",dailystart,dailyend),
                registrationSessionRepository.getTotalRevokeUserDaily(dailystart,dailyend)

        ));
    }

    public List<ChangeDeviceInfo> getChangeDeviceInfoDaily(String date) {
        LocalDateTime localDateTime = LocalDateTime.parse(date+"T00:00:00");
        String dailystart = localDateTime.minusHours(7).toString();
        String dailyend = localDateTime.plusHours(16).plusMinutes(59).plusSeconds(59).toString();
        return List.of(new ChangeDeviceInfo(
                registrationSessionRepository.getCountTypeOfUserDaily("eKYC",dailystart,dailyend),
                registrationSessionRepository.getCountTypeOfUserDaily("PHYSICAL",dailystart,dailyend),
                registrationSessionRepository.getCountTypeOfUserDaily("NDID",dailystart,dailyend),
                registrationSessionRepository.getCountTypeOfUserDaily("D.DOPA",dailystart,dailyend),
                registrationSessionRepository.getTotalRevokeUserDaily(dailystart,dailyend)
        ));
    }

    public List<TotalLInfo> getTotalLInfoDaily(String date) {
        LocalDateTime localDateTime = LocalDateTime.parse(date+"T00:00:00");
        String dailystart = localDateTime.minusHours(7).toString();
        String dailyend = localDateTime.plusHours(16).plusMinutes(59).plusSeconds(59).toString();
        return List.of(new TotalLInfo(
                registrationSessionRepository.getCountTotalTypeOfUserDaily("eKYC",dailystart,dailyend),
                registrationSessionRepository.getCountTotalTypeOfUserDaily("PHYSICAL",dailystart,dailyend),
                registrationSessionRepository.getCountTotalTypeOfUserDaily("NDID",dailystart,dailyend),
                registrationSessionRepository.getCountTotalTypeOfUserDaily("D.DOPA",dailystart,dailyend),
                registrationSessionRepository.getTotalRevokeUserDaily(dailystart,dailyend)
        ));
    }

    public List<VerifyRegisterInfo> getVerifyRegisterInfoMonthly(String startdate,String enddate){
        LocalDateTime startlocalDateTime = LocalDateTime.parse(startdate+"T00:00:00");
        LocalDateTime endlocalDateTime = LocalDateTime.parse(enddate+"T00:00:00");
        String start = startlocalDateTime.minusHours(7).toString();
        String end = endlocalDateTime.plusHours(16).plusMinutes(59).plusSeconds(59).toString();
        return List.of(
                new VerifyRegisterInfo(
                        registrationSessionRepository.getCountIsNewTypeOfUserMonthly("eKYC",start,end),
                        registrationSessionRepository.getCountIsNewTypeOfUserMonthly("PHYSICAL",start,end),
                        registrationSessionRepository.getCountIsNewTypeOfUserMonthly("NDID",start,end),
                        registrationSessionRepository.getCountIsNewTypeOfUserMonthly("D.DOPA",start,end),
                        registrationSessionRepository.getTotalRevokeUserMonthly(start,end)
                )
        );
    }

    public List<ChangeDeviceInfo> getChangeDeviceInfoMonthly(String startdate,String enddate) {
        LocalDateTime startlocalDateTime = LocalDateTime.parse(startdate+"T00:00:00");
        LocalDateTime endlocalDateTime = LocalDateTime.parse(enddate+"T00:00:00");
        String start = startlocalDateTime.minusHours(7).toString();
        String end = endlocalDateTime.plusHours(16).plusMinutes(59).plusSeconds(59).toString();
        return List.of(new ChangeDeviceInfo(
                registrationSessionRepository.getCountTypeOfUserMonthly("eKYC",start,end),
                registrationSessionRepository.getCountTypeOfUserMonthly("PHYSICAL",start,end),
                registrationSessionRepository.getCountTypeOfUserMonthly("NDID",start,end),
                registrationSessionRepository.getCountTypeOfUserMonthly("D.DOPA",start,end),
                registrationSessionRepository.getTotalRevokeUserMonthly(start,end)
        ));
    }

    public List<TotalLInfo> getTotalLInfoMonthly(String startdate,String enddate) {
        LocalDateTime startlocalDateTime = LocalDateTime.parse(startdate+"T00:00:00");
        LocalDateTime endlocalDateTime = LocalDateTime.parse(enddate+"T00:00:00");
        String start = startlocalDateTime.minusHours(7).toString();
        String end = endlocalDateTime.plusHours(16).plusMinutes(59).plusSeconds(59).toString();
        return List.of(new TotalLInfo(
                registrationSessionRepository.getCountTotalTypeOfUserMonthly("eKYC",start,end),
                registrationSessionRepository.getCountTotalTypeOfUserMonthly("PHYSICAL",start,end),
                registrationSessionRepository.getCountTotalTypeOfUserMonthly("NDID",start,end),
                registrationSessionRepository.getCountTotalTypeOfUserMonthly("D.DOPA",start,end),
                registrationSessionRepository.getTotalRevokeUserMonthly(start,end)
        ));
    }

    public List<List<List<String>>> getDateTotalUser(String date) {
        LocalDateTime localDateTime = LocalDateTime.parse(date+"T00:00:00");
        String dailystart = localDateTime.minusHours(7).toString();
        String dailyend = localDateTime.plusHours(16).plusMinutes(59).plusSeconds(59).toString();
        return List.of(
                List.of(registrationSessionRepository.getDateTotal("eKYC",dailystart,dailyend),
                        registrationSessionRepository.getDateTotal("PHYSICAL",dailystart,dailyend),
                        registrationSessionRepository.getDateTotal("NDID",dailystart,dailyend),
                        registrationSessionRepository.getDateTotal("D.DOPA",dailystart,dailyend)),
                List.of(registrationSessionRepository.getDateOldUser("eKYC",dailystart,dailyend),
                        registrationSessionRepository.getDateOldUser("PHYSICAL",dailystart,dailyend),
                        registrationSessionRepository.getDateOldUser("NDID",dailystart,dailyend),
                        registrationSessionRepository.getDateOldUser("D.DOPA",dailystart,dailyend)),
                List.of(registrationSessionRepository.getDateNewUser("eKYC",dailystart,dailyend),
                        registrationSessionRepository.getDateNewUser("PHYSICAL",dailystart,dailyend),
                        registrationSessionRepository.getDateNewUser("NDID",dailystart,dailyend),
                        registrationSessionRepository.getDateNewUser("D.DOPA",dailystart,dailyend))
        );
    }


    public List<RegistrationSession> getAllRegistrationSession() { return registrationSessionRepository.findAll();}
//
//    public void addRegistrationSession(RegistrationSession registrationSession) {
//        registrationSessionRepository.save(registrationSession);
//    }
//
//    public void deleteRegistrationSession(String id){ registrationSessionRepository.deleteById(id);}
}
