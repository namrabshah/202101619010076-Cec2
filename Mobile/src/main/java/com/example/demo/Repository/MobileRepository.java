package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.MobileModel;

public interface MobileRepository extends JpaRepository<MobileModel,Integer>{

}
