package com.example.coj_api_test.repository;

import com.example.coj_api_test.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,String> {

//    @Query(value = "SELECT COUNT(*) FROM userprofile WHERE createddate LIKE :date",nativeQuery = true)
//    Long getTotalUserDaily(@Param("date") String date);
    @Query(value = "SELECT COUNT(*) FROM userprofile WHERE createddate BETWEEN :dailystart AND :dailyend",nativeQuery = true)
    Long getTotalActiveUserDaily(@Param("dailystart") String dailystart,@Param("dailyend") String dailyend);
    @Query(value = "SELECT COUNT(*) FROM inactiveuserprofile WHERE createddate BETWEEN :dailystart AND :dailyend",nativeQuery = true)
    Long getTotalInactiveUserDaily(@Param("dailystart") String dailystart,@Param("dailyend") String dailyend);

//    @Query(value = "SELECT COUNT(*) FROM userprofile WHERE createddate >= :startdate and createddate <= :enddate",nativeQuery = true)
//    Long getTotalUserMonthly(@Param("startdate") String startdate,@Param("enddate") String enddate);
    @Query(value = "SELECT COUNT(*) FROM userprofile WHERE createddate BETWEEN :startdate AND :enddate",nativeQuery = true)
    Long getTotalActiveUserMonthly(@Param("startdate") String startdate,@Param("enddate") String enddate);
    @Query(value = "SELECT COUNT(*) FROM inactiveuserprofile WHERE createddate BETWEEN :startdate AND :enddate",nativeQuery = true)
    Long getTotalInactiveUserMonthly(@Param("startdate") String startdate,@Param("enddate") String enddate);


}
