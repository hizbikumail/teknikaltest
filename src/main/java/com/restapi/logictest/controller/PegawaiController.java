/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restapi.logictest.controller;

import com.restapi.logictest.entity.PegawaiEntity;
import com.restapi.logictest.repository.PegawaiRepository;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author W10
 */
@RestController
@RequestMapping(value = "/pegawai")
public class PegawaiController {
    
    @Autowired
    PegawaiRepository repo;
    
    @PostMapping(value = "/addpegawai")
    public String addPegawai(@RequestBody PegawaiEntity param, BindingResult r){
        String nama = param.getNama();
        String alamat = param.getAlamat();
        if(!r.hasErrors()){
            if(nama.equals("")||alamat.equals("")){
                return "Data tidak boleh kosong !";
            }else{
                repo.save(param);
                return "Success!";
            }
        }else{
            return "error!";
        }
    }
    
    @GetMapping(value = "/getallpegawai")
    public List<PegawaiEntity> getAllPegawai(){
        return repo.findAll();
    }
    
    @GetMapping(value = "/getbyid")
    public PegawaiEntity getById(@RequestParam int id){
        return repo.findById(id).get();
    }
}
