package com.example.coj_api_test.repository;

import com.example.coj_api_test.models.RegistrationSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationSessionRepository extends JpaRepository<RegistrationSession,String> {


    @Query(value = "SELECT COUNT(*) FROM registrationsession WHERE kyctype=:type and (createddate BETWEEN :dailystart AND :dailyend)",nativeQuery = true)
    Long getCountTotalTypeOfUserDaily(@Param("type") String type,@Param("dailystart") String dailystart,@Param("dailyend") String dailyend);
    @Query(value = "SELECT COUNT(*) FROM registrationsession WHERE kyctype=:type and isNewUser=false and (createddate BETWEEN :dailystart AND :dailyend)",nativeQuery = true)
    Long getCountTypeOfUserDaily(@Param("type") String type,@Param("dailystart") String dailystart,@Param("dailyend") String dailyend);
    @Query(value = "SELECT COUNT(*) FROM registrationsession WHERE kyctype=:type and isNewUser=true and (createddate BETWEEN :dailystart AND :dailyend)",nativeQuery = true)
    Long getCountIsNewTypeOfUserDaily(@Param("type")String type,@Param("dailystart") String dailystart,@Param("dailyend") String dailyend);

    @Query(value = "SELECT COUNT(*) FROM registrationsession WHERE createddate LIKE :date",nativeQuery = true)
    Long getTotalUserDaily(@Param("date") String date);
    @Query(value = "SELECT COUNT(*) FROM registrationsession WHERE kyctype = :type and (createddate BETWEEN :dailystart AND :dailyend)",nativeQuery = true)
    Long getTotalRevokeUserDaily(@Param("type") String type,@Param("dailystart") String dailystart,@Param("dailyend") String dailyend);
    @Query(value = "SELECT COUNT(revoked) FROM registrationsession WHERE createddate LIKE :date",nativeQuery = true)
    Long getTotalActiveUserDaily(@Param("date") String date);


    @Query(value = "SELECT COUNT(*) FROM registrationsession WHERE kyctype=:type and (createddate BETWEEN :startdate AND :enddate)",nativeQuery = true)
    Long getCountTotalTypeOfUserMonthly(@Param("type") String type,@Param("startdate") String startdate,@Param("enddate") String enddate);
    @Query(value = "SELECT COUNT(*) FROM registrationsession WHERE kyctype = :type and isNewUser = false and (createddate BETWEEN :startdate AND :enddate)",nativeQuery = true)
    Long getCountTypeOfUserMonthly(@Param("type") String type,@Param("startdate") String startdate,@Param("enddate") String enddate);
    @Query(value = "SELECT COUNT(*) FROM registrationsession WHERE kyctype = :type and isNewUser = true and (createddate BETWEEN :startdate AND :enddate)",nativeQuery = true)
    Long getCountIsNewTypeOfUserMonthly(@Param("type") String type,@Param("startdate")String startdate,@Param("enddate") String enddate );


    @Query(value = "SELECT createddate FROM registrationsession WHERE kyctype=:type and (createddate BETWEEN :dailystart AND :dailyend)",nativeQuery = true)
    List<String> getDateTotal(@Param("type") String type,@Param("dailystart") String dailystart,@Param("dailyend") String dailyend);
    @Query(value = "SELECT createddate FROM registrationsession WHERE kyctype=:type and isNewUser=false and (createddate BETWEEN :dailystart AND :dailyend)",nativeQuery = true)
    List<String> getDateOldUser(@Param("type") String type,@Param("dailystart") String dailystart,@Param("dailyend") String dailyend);
    @Query(value = "SELECT createddate FROM registrationsession WHERE kyctype=:type and isNewUser=true and (createddate BETWEEN :dailystart AND :dailyend)",nativeQuery = true)
    List<String> getDateNewUser(@Param("type")String type,@Param("dailystart") String dailystart,@Param("dailyend") String dailyend);

    @Query(value = "SELECT COUNT(*) FROM registrationsession WHERE createddate >= :startdate and createddate <= :enddate",nativeQuery = true)
    Long getTotalUserMonthly(@Param("startdate") String startdate,@Param("enddate")String enddate);
    @Query(value = "SELECT COUNT(revoked) FROM registrationsession WHERE kyctype=:type and (createddate BETWEEN :startdate AND :enddate)",nativeQuery = true)
    Long getTotalRevokeUserMonthly(@Param("type") String type,@Param("startdate") String startdate,@Param("enddate") String enddate);
    @Query(value = "SELECT COUNT(revoked) FROM registrationsession WHERE createddate >= :startdate and createddate <= :enddate",nativeQuery = true)
    Long getTotalActiveUserMonthly(@Param("startdate") String startdate,@Param("enddate") String enddate);

}
