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
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class LoginLogUserService {

    private LoginLogUserRepository loginLogUserRepository;

    @Autowired
    public LoginLogUserService(LoginLogUserRepository loginLogRepository){this.loginLogUserRepository = loginLogRepository;}

    public List<LoginLogUser> getAllLoginlog() {return loginLogUserRepository.findAll(); }

    public List<LoginInfo> getLoginInfoDaily(String date) {
        List timedaily = List.of("0:00-1:59 น.","2:00-3:59 น.","4:00-5:59 น.","6:00-7:59 น.","8:00-9:59 น.","10:00-11:59 น.","12:00-13:59 น.","14:00-15:59 น.","16:00-17:59 น.","18:00-19:59 น.","20:00-21:59 น.","22:00-23:59 น.");
        List<String> timestamp = new ArrayList<>();
        LocalDateTime localDateTime = LocalDateTime.parse(date+"T00:00:00");
        for(int i=0;i<24;i++) {
            if(i<8){
                timestamp.add(localDateTime.minusHours(7-i).toString());
            } else {
                timestamp.add(localDateTime.plusHours(i-7).toString());
            }
        }
        List<LoginInfo> response;
        try {
            response = List.of(
                    new LoginInfo(
                            List.of(new QrCode(
                                    timedaily,
                                    List.of(loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(0),timestamp.get(1).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(2),timestamp.get(3).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(4),timestamp.get(5).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(6),timestamp.get(7).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(8),timestamp.get(9).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(10),timestamp.get(11).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(12),timestamp.get(13).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(14),timestamp.get(15).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(16),timestamp.get(17).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(18),timestamp.get(19).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(20),timestamp.get(21).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("QR_CODE",timestamp.get(22),timestamp.get(23).substring(0,14)+"59:59")
                                    )
                            )),
                            List.of(new User(
                                    timedaily,
                                    List.of(
                                            loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(0),timestamp.get(1).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(2),timestamp.get(3).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(4),timestamp.get(5).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(6),timestamp.get(7).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(8),timestamp.get(9).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(10),timestamp.get(11).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(12),timestamp.get(13).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(14),timestamp.get(15).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(16),timestamp.get(17).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(18),timestamp.get(19).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(20),timestamp.get(21).substring(0,14)+"59:59"),
                                            loginLogUserRepository.getloginCountDaily("CREDENTIAL",timestamp.get(22),timestamp.get(23).substring(0,14)+"59:59")
                                    )
                            )),
                            List.of(new Failed(
                                            timedaily,
                                            List.of(
                                                    loginLogUserRepository.getfailedCountDaily(timestamp.get(0),timestamp.get(1).substring(0,14)+"59:59"),
                                                    loginLogUserRepository.getfailedCountDaily(timestamp.get(2),timestamp.get(3).substring(0,14)+"59:59"),
                                                    loginLogUserRepository.getfailedCountDaily(timestamp.get(4),timestamp.get(5).substring(0,14)+"59:59"),
                                                    loginLogUserRepository.getfailedCountDaily(timestamp.get(6),timestamp.get(7).substring(0,14)+"59:59"),
                                                    loginLogUserRepository.getfailedCountDaily(timestamp.get(8),timestamp.get(9).substring(0,14)+"59:59"),
                                                    loginLogUserRepository.getfailedCountDaily(timestamp.get(10),timestamp.get(11).substring(0,14)+"59:59"),
                                                    loginLogUserRepository.getfailedCountDaily(timestamp.get(12),timestamp.get(13).substring(0,14)+"59:59"),
                                                    loginLogUserRepository.getfailedCountDaily(timestamp.get(14),timestamp.get(15).substring(0,14)+"59:59"),
                                                    loginLogUserRepository.getfailedCountDaily(timestamp.get(16),timestamp.get(17).substring(0,14)+"59:59"),
                                                    loginLogUserRepository.getfailedCountDaily(timestamp.get(18),timestamp.get(19).substring(0,14)+"59:59"),
                                                    loginLogUserRepository.getfailedCountDaily(timestamp.get(20),timestamp.get(21).substring(0,14)+"59:59"),
                                                    loginLogUserRepository.getfailedCountDaily(timestamp.get(22),timestamp.get(23).substring(0,14)+"59:59")
                                            )
                                    )
                            ))
            );
        } catch (Exception e){
            long num = 0;
            response = List.of(
                    new LoginInfo(
                            List.of(new QrCode(
                                    timedaily,
                                    List.of(num,num,num,num,num,num,num,num,num,num,num,num)
                            )),
                            List.of(new User(
                                    timedaily,
                                    List.of(num,num,num,num,num,num,num,num,num,num,num,num)
                            )),
                            List.of(new Failed(
                                    timedaily,
                                    List.of(num,num,num,num,num,num,num,num,num,num,num,num)
                                    )
                            ))
            );
        }
        return response;
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
        try {
            for (int j=0;j<=monthdiff;j++) {
                switch (monthdayofmonth) {
                    case 1:
                    {
                        if(year > 2200) {
                            if(year % 4 == 3) {
                                dayofmonth = 29;
                                break;
                            } else {
                                dayofmonth = 28;
                                break;
                            }
                        } else {
                            if(year%4==0){
                                dayofmonth = 29;
                                break;
                            } else {
                                dayofmonth = 28;
                                break;
                            }
                        }
                    }
                    case 0:
                    case 2:
                    case 4:
                    case 6:
                    case 7:
                    case 9:
                    case 11:
                        dayofmonth = 31;
                        break;
                    case 3:
                    case 5:
                    case 8:
                    case 10:
                        dayofmonth = 30;
                        break;
                }
                for (int i = 1; i <= dayofmonth; i += 3) {
                    //Date Label ex. 1 ม.ค.
                    daily.add(String.valueOf(i) + monthly.get(j));

                    String querystartday = "";
                    if(i==1) {
                        if(monthdayofmonth == 4 || monthdayofmonth == 6 || monthdayofmonth ==9 || monthdayofmonth == 11) {
                            querystartday = "30T17:00:00";
                        } else if (monthdayofmonth == 0 || monthdayofmonth == 1 || monthdayofmonth == 3 || monthdayofmonth == 5 || monthdayofmonth == 7 || monthdayofmonth == 8 || monthdayofmonth == 10) {
                            querystartday = "31T17:00:00";
                        } else if(monthdayofmonth == 2) {
                            if(year%4==0) {
                                querystartday = "29T17:00:00";
                            } else {
                                querystartday = "28T17:00:00";
                            }
                        }
                    } else {
                        querystartday = String.valueOf(i);
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
                    if(i == 1) {
                        String startmonthtmp = String.valueOf(monthdayofmonth);
                        countqr.add(loginLogUserRepository.getloginCountMonthly("QR_CODE", year + "-" + startmonthtmp + "-" + querystartday, year + "-" + querymonth + "-" + queryendday + "T16:59:59"));
                        countuser.add(loginLogUserRepository.getloginCountMonthly("CREDENTIAL", year + "-" + startmonthtmp + "-" + querystartday, year + "-" + querymonth + "-" + queryendday + "T16:59:59"));
                        countfailed.add(loginLogUserRepository.getfailedCountMonthly(year + "-" + startmonthtmp + "-" + querystartday, year + "-" + querymonth + "-" + queryendday + "T16:59:59"));
                    } else {
                        countqr.add(loginLogUserRepository.getloginCountMonthly("QR_CODE", year + "-" + querymonth + "-" + querystartday, year + "-" + querymonth + "-" + queryendday + "T16:59:59"));
                        countuser.add(loginLogUserRepository.getloginCountMonthly("CREDENTIAL", year + "-" + querymonth + "-" + querystartday, year + "-" + querymonth + "-" + queryendday + "T16:59:59"));
                        countfailed.add(loginLogUserRepository.getfailedCountMonthly(year + "-" + querymonth + "-" + querystartday, year + "-" + querymonth + "-" + queryendday + "T16:59:59"));
                    }

                }
                monthdayofmonth += 1;
                if(monthdayofmonth>=12) {
                    monthdayofmonth = monthdayofmonth % 12;
                    year++;
                }
            }
        }
        catch (Exception e) {
            long longnum = 0;
            countqr.add(longnum);
            countuser.add(longnum);
            countfailed.add(longnum);
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
