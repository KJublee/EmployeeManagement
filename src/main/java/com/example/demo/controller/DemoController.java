package com.example.demo.controller;

import com.example.demo.dao.DemoRepo;
import com.example.demo.entity.DemoEntity;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String demoHome(){
        return "I'm string with my new Laptop";
    }

    @PostMapping
    public String create(@RequestBody DemoEntity demoEntity){
        demoService.createRecords(demoEntity);
        return "Record created successfully";
    }

    @GetMapping
    public List<DemoEntity> getAll(){

        return demoService.getAllRecords();

    }

    @GetMapping("/{id}")
    public DemoEntity getById(@PathVariable Long id){
        return demoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        String name = demoService.findById(id).getName();
        demoService.deleteByid(id);

        return name;

    }
    @PutMapping()

    //put mapping
    public String editDemo(@RequestBody DemoEntity update){
        DemoEntity demo = demoService.findById(update.getId());
        demo.setName(update.getName());
        demo.setRole(update.getRole());
        demo.setEmail(update.getEmail());
        demoService.createRecords(demo);


        return "Update successful";
    }

}
