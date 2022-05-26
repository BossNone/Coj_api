package com.example.coj_api_test.repository;

import com.example.coj_api_test.models.LoginLogUser;
import org.apache.juli.logging.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.PreDestroy;
import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface LoginLogUserRepository extends JpaRepository<LoginLogUser,String> {

    @Query(value = "SELECT COUNT(*) FROM loginloguser WHERE logintype = :type and status = true and (timestamp BETWEEN :time1 AND :time2)",nativeQuery = true)
    Long getloginCountDaily(@Param("type") String type,@Param("time1") String time1,@Param("time2") String time2);
    @Query(value = "SELECT COUNT(*) FROM loginloguser WHERE status = false and (timestamp BETWEEN :time1 AND :time2)",nativeQuery = true)
    Long getfailedCountDaily(@Param("time1") String time1,@Param("time2") String time2);

    @Query(value = "SELECT COUNT(*) FROM loginloguser WHERE logintype = :type and status = true and (timestamp BETWEEN :startdate AND :enddate)",nativeQuery = true)
    Long getloginCountMonthly(@Param("type")String type,@Param("startdate") String startdate,@Param("enddate") String enddate);
    @Query(value = "SELECT COUNT(*) FROM loginloguser WHERE status = false and (timestamp BETWEEN :startdate AND :enddate)",nativeQuery = true)
    Long getfailedCountMonthly(@Param("startdate") String startdate,@Param("enddate") String enddate);

}
