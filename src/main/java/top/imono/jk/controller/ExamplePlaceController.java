package top.imono.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.imono.jk.common.utils.Rs;
import top.imono.jk.pojo.po.ExamPlace;
import top.imono.jk.pojo.po.PlateRegion;
import top.imono.jk.pojo.query.ProvincesQuery;
import top.imono.jk.pojo.result.R;
import top.imono.jk.service.ExamPlaceService;
import top.imono.jk.service.PlateRegionService;

@RestController
@RequestMapping("/examplePlace")
public class ExamplePlaceController extends BaseController<ExamPlace> {
    @Autowired
    private ExamPlaceService service;

    @GetMapping("/regionExamplePlaces")
    public R listRegionExamplePlaces() {
        return Rs.success(service.listRegionExamplePlaces());
    }


    @Override
    protected IService<ExamPlace> getService() {
        return service;
    }

}
