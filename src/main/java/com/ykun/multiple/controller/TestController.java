package com.ykun.multiple.controller;

import com.ykun.multiple.domain.HelloWorld;
import com.ykun.multiple.repository.master.MasterRepository;
import com.ykun.multiple.repository.slave.SlaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ykun 于 2017-06-16 16:11
 */
@RestController
public class TestController {

    @Autowired
    private MasterRepository masterRepository;

    @Autowired
    private SlaveRepository slaveRepository;

//    @Autowired
//    @Qualifier("masterTemplate")
//    private MongoTemplate masterTemplate;
//
//    @Autowired
//    @Qualifier("slaveTemplate")
//    private MongoTemplate slaveTemplate;

    @GetMapping("test")
    public void test() {
        HelloWorld h1 = new HelloWorld();
        h1.setCounter(masterRepository.getNextSequence("hello"));
        masterRepository.save(h1);

        HelloWorld h2 = new HelloWorld();
        h2.setCounter(slaveRepository.getNextSequence("hello"));
        slaveRepository.save(h2);
    }

}
