package com.example.demo.service;

import com.example.demo.dao.DemoRepo;
import com.example.demo.entity.DemoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
public class DemoService {
    @Autowired
    private DemoRepo demoRepo;
    public List<DemoEntity> getAllRecords() {
        return demoRepo.findAll();
    }

    public void createRecords(DemoEntity demoEntity) {
        demoRepo.save(demoEntity);
    }

    public DemoEntity findById(Long id) {
        return demoRepo.findById(id).orElseGet(DemoEntity::new);
    }

    public void deleteByid(Long id) {
        demoRepo.deleteById(id);
    }
}
