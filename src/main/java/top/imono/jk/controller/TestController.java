package top.imono.jk.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.imono.jk.pojo.po.DictType;
import top.imono.jk.service.DictTypeService;

import java.util.List;

@Hidden
@RestController
public class TestController {

    @Autowired
    private DictTypeService dictTypeService;

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/test/database")
    public List<DictType> testDatabase(){
        return dictTypeService.list();
    }
}
