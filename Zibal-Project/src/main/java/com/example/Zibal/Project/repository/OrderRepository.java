package com.example.Zibal.Project.repository;

import com.example.Zibal.Project.model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Integer> {

}
