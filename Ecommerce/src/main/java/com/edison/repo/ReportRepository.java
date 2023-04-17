package com.edison.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edison.entity.Order;
public interface ReportRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderDateBetween(Date startDate, Date endDate);

}