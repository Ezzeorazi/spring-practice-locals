package com.ezze.restfulapi.controller;


import com.ezze.restfulapi.entity.Local;
import com.ezze.restfulapi.error.LocalNotFoundException;
import com.ezze.restfulapi.service.LocalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocalController {

    @Autowired
    LocalService localService;

    @GetMapping("/findLocalById/{id}")
    Local findLocalById(@PathVariable Long id)throws LocalNotFoundException {
     return localService.findLocalById(id);
    }

    @GetMapping("/findLocalByNameWithJPQL/{name}")
    Optional<Local> findLocalByNameWithJPQL(@PathVariable String name){
      return localService.findLocalByNameWithJPQL(name);
    }

    @GetMapping("/findByName/{name}")
    Optional<Local> findByName(@PathVariable String name){
        return localService.findByName(name);
    }

    @GetMapping("/findByNameIgnoreCase/{name}")
    Optional<Local> findByNameIgnoreCase(@PathVariable String name){
        return localService.findByNameIgnoreCase(name);
    }

    @GetMapping("/findAllLocals")
    public List<Local> findAllLocals(){
        return localService.findAllLocals();
    }


    @PostMapping("/savelocal")
    public Local saveLocal(@Valid @RequestBody Local local){
        return localService.saveLocal(local);
    }

    @PutMapping("/update/{id}")
    public Local updateLocal(@PathVariable long id, @RequestBody Local local){
      return localService.updateLocal(id, local);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteLocal(@PathVariable Long id) {
        localService.deleteLocal(id);
        return "Succesfully deleted";
    }


}
