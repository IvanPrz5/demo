package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.c_ObjetoImp;
import com.example.demo.Repository.c_ObjetoImpRepostory;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/ObjetoImp")
public class c_ObjetoImpController {
    @Autowired
    private c_ObjetoImpRepostory objetoimpRepository;

    @GetMapping
    public List<c_ObjetoImp> datos() {
        return (List<c_ObjetoImp>) objetoimpRepository.findAll();
    }
}
