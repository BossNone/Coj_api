package com.example.coj_api_test.services;

import com.example.coj_api_test.models.*;
import com.example.coj_api_test.repository.LoginLogUserRepository;
import org.apache.juli.logging.Log;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LoginLogUserService {

    private LoginLogUserRepository loginLogUserRepository;

    @Autowired
    public LoginLogUserService(LoginLogUserRepository loginLogRepository){this.loginLogUserRepository = loginLogRepository;}

    public List<LoginLogUser> getAllLoginlog() {return loginLogUserRepository.findAll(); }

    public List<LoginInfo> getLoginInfoDaily(String date) {
        List timedaily = List.of("0:00 น.","2:00 น.","4:00 น.","6:00 น.","8:00 น.","10:00 น.","12:00 น.","14:00 น.","16:00 น.","18:00 น.","20:00 น.","22:00 น.","24:00 น.");
        List<String> timestamp = new ArrayList<>();
        LocalDateTime localDateTime = LocalDateTime.parse(date+"T00:00:00");
        for(int i=0;i<24;i++) {
            if(i<8){
                timestamp.add(localDateTime.minusHours(7-i).toString());
            } else {
                timestamp.add(localDateTime.plusHours(i-7).toString());
            }
        }
        return List.of(
                new LoginInfo(
                        List.of(new QrCode(
                                timedaily,
                                List.of(loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(0),timestamp.get(1)),
                                        loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(2),timestamp.get(3)),
                                        loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(4),timestamp.get(5)),
                                        loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(6),timestamp.get(7)),
                                        loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(8),timestamp.get(9)),
                                        loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(10),timestamp.get(11)),
                                        loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(12),timestamp.get(13)),
                                        loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(14),timestamp.get(15)),
                                        loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(16),timestamp.get(17)),
                                        loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(18),timestamp.get(19)),
                                        loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(20),timestamp.get(21)),
                                        loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(22),timestamp.get(23).substring(0,14)+"59:59")
                                        )
                        )),
                        List.of(new User(
                                timedaily,
                                List.of(
                                        loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(0),timestamp.get(1)),
                                        loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(2),timestamp.get(3)),
                                        loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(4),timestamp.get(5)),
                                        loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(6),timestamp.get(7)),
                                        loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(8),timestamp.get(9)),
                                        loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(10),timestamp.get(11)),
                                        loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(12),timestamp.get(13)),
                                        loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(14),timestamp.get(15)),
                                        loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(16),timestamp.get(17)),
                                        loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(18),timestamp.get(19)),
                                        loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(20),timestamp.get(21)),
                                        loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(22),timestamp.get(23).substring(0,14)+"59:59")
                                        )
                        )),
                        List.of(new Failed(
                                timedaily,
                                List.of(
                                        loginLogUserRepository.getfailedCountDaily(timestamp.get(0),timestamp.get(1)),
                                        loginLogUserRepository.getfailedCountDaily(timestamp.get(2),timestamp.get(3)),
                                        loginLogUserRepository.getfailedCountDaily(timestamp.get(4),timestamp.get(5)),
                                        loginLogUserRepository.getfailedCountDaily(timestamp.get(6),timestamp.get(7)),
                                        loginLogUserRepository.getfailedCountDaily(timestamp.get(8),timestamp.get(9)),
                                        loginLogUserRepository.getfailedCountDaily(timestamp.get(10),timestamp.get(11)),
                                        loginLogUserRepository.getfailedCountDaily(timestamp.get(12),timestamp.get(13)),
                                        loginLogUserRepository.getfailedCountDaily(timestamp.get(14),timestamp.get(15)),
                                        loginLogUserRepository.getfailedCountDaily(timestamp.get(16),timestamp.get(17)),
                                        loginLogUserRepository.getfailedCountDaily(timestamp.get(18),timestamp.get(19)),
                                        loginLogUserRepository.getfailedCountDaily(timestamp.get(20),timestamp.get(21)),
                                        loginLogUserRepository.getfailedCountDaily(timestamp.get(22),timestamp.get(23).substring(0,14)+"59:59")
                                        )
                                )
                        ))
                );
    }

    public List<LoginInfo> getLoginInfoMonthly(String startdate,String enddate) {
        LocalDate date1;
        LocalDate date2;
        date1 = LocalDate.parse(startdate);
        date2 = LocalDate.parse(enddate);
        List<String> monthly = new ArrayList<>();
        List<String> daily = new ArrayList<>();
        List<Long> countqr = new ArrayList<>();
        List<Long> countuser = new ArrayList<>();
        List<Long> countfailed = new ArrayList<>();
        Period diff = Period.between(date1,date2);

        int yeardiff = diff.getYears();
        int monthdiff = diff.getMonths()+(yeardiff*12);
        long daydiff = ChronoUnit.DAYS.between(date1,date2);
        String[] month = new String[monthdiff];
        String[] day = new String[(int)daydiff/3];
        String[] totalmonth = new String[]{"ม.ค.","ก.พ.","มี.ค.","เม.ย.","พ.ค.","มิ.ย.","ก.ค.","ส.ค.","ก.ย.","ต.ค.","พ.ศ.","ธ.ค."};
        int year = date1.getYear();
        String selectmonth = String.valueOf(startdate.charAt(5))+String.valueOf(startdate.charAt(6));
        int monthdayofmonth = Integer.parseInt(selectmonth)-1;
        int dayofmonth = 30;
        // List of month to show in dashboard
        for (int i=Integer.parseInt(selectmonth);i<=(Integer.parseInt(selectmonth)+monthdiff);i++) {
            if(i>12) {
                int temp = (i-1)%12;
                monthly.add(totalmonth[temp]);
            } else {
                monthly.add(totalmonth[i-1]);
            }

        }
            for (int j=0;j<=monthdiff;j++) {
                switch (monthdayofmonth) {
                    case 0:
                        dayofmonth = 31;
                        break;
                    case 1:
                    {
                        if(year%4==0){
                            dayofmonth = 29;
                            break;
                        } else {
                            dayofmonth = 28;
                        }
                    }

                    case 2:
                        dayofmonth = 31;
                        break;
                    case 3:
                        dayofmonth = 30;
                        break;
                    case 4:
                        dayofmonth = 31;
                        break;
                    case 5:
                        dayofmonth = 30;
                        break;
                    case 6:
                        dayofmonth = 31;
                        break;
                    case 7:
                        dayofmonth = 31;
                        break;
                    case 8:
                        dayofmonth = 30;
                        break;
                    case 9:
                        dayofmonth = 31;
                        break;
                    case 10:
                        dayofmonth = 30;
                        break;
                    case 11:
                        dayofmonth = 31;
                        break;
                }
                for (int i = 1; i <= dayofmonth; i += 3) {
                    if(dayofmonth <=29) {

                    }
                    daily.add(String.valueOf(i) + monthly.get(j));
                    String querystartday = "";
                    if(i==1) {
                        querystartday = "30T17:00:00";
                    } else {
                        querystartday = String.valueOf(i-1);
                        if(querystartday.length() <2) {
                            querystartday = "0" + querystartday + "T17:00:00";
                        }
                        else {
                            querystartday = String.valueOf(i)+"T17:00:00";
                        }

                    }
                    String querymonth = String.valueOf(monthdayofmonth + 1);
                    String queryendday = String.valueOf(i + 3);

                    if (querymonth.length() < 2) {
                        querymonth = "0" + querymonth;
                    }
                    if (queryendday.length() < 2) {
                        queryendday = "0" + queryendday;
                    }
                    countqr.add(loginLogUserRepository.getloginCountMonthly("QR_CODE", year + "-" + querymonth + "-" + querystartday, date1.getYear() + "-" + querymonth + "-" + queryendday +"T16:59:59"));
                    countuser.add(loginLogUserRepository.getloginCountMonthly("CREDENTIAL", year + "-" + querymonth + "-" + querystartday, date1.getYear() + "-" + querymonth + "-" + queryendday +"T16:59:59"));
                    countfailed.add(loginLogUserRepository.getfailedCountMonthly(year + "-" + querymonth + "-" + querystartday, date1.getYear() + "-" + querymonth + "-" + queryendday+"T16:59:59"));
                }
                monthdayofmonth += 1;
                if(monthdayofmonth>=12) {
                    monthdayofmonth = monthdayofmonth % 12;
                    year++;
                }
            }

        return List.of(
                new LoginInfo(
                        List.of(
                                new QrCode(
                                        daily,
                                        countqr
                                )
                        ),
                        List.of(
                                new User(
                                        daily,
                                        countuser
                                )
                        ),
                        List.of(
                                new Failed(
                                        daily,
                                        countfailed
                                )
                        )
                )
        );
    }


}
