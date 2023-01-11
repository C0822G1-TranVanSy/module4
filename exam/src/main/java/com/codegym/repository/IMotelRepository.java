package com.codegym.repository;

import com.codegym.model.Motel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMotelRepository extends JpaRepository<Motel,Integer> {
    @Query(value = "select * from motel join payment on motel.payment_id = payment.id where motel.name like %:name% and motel.number_phone like %:phone% and payment.id = :paymentId",nativeQuery = true)
    List<Motel> findThree(@Param("name") String name,@Param("phone") String phone,@Param("paymentId") int paymentId);

    @Query(value = "select * from motel join payment on motel.payment_id = payment.id where motel.name like %:name% and motel.number_phone like %:phone%",nativeQuery = true)
    List<Motel> findTwo(@Param("name") String name,@Param("phone") String phone);

    @Query(value = "select * from motel join payment on motel.payment_id = payment.id where motel.id=:id",nativeQuery = true)
    Motel viewDetail(@Param("id") int id);
}
