/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restapi.logictest.repository;

import com.restapi.logictest.entity.PegawaiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author hizkum
 */
public interface PegawaiRepository extends JpaRepository<PegawaiEntity, Integer>{
    
}
