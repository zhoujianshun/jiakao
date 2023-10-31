package top.imono.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.imono.jk.common.utils.Rs;
import top.imono.jk.pojo.po.PlateRegion;
import top.imono.jk.pojo.query.ProvincesQuery;
import top.imono.jk.pojo.result.R;
import top.imono.jk.service.PlateRegionService;

@RestController
@RequestMapping("/plateRegions")
public class PlateRegionController extends BaseController<PlateRegion> {
    @Autowired
    private PlateRegionService service;

    @GetMapping("/regions")
    public R listRegions() {
        return Rs.success(service.listRegions());
//        return new R().setSuccess(true).setContent(dictTypeQuery);
    }

    @GetMapping("/provinces")
    public R listProvinces(ProvincesQuery provincesQuery) {
        service.listProvinces(provincesQuery);
        return Rs.success(provincesQuery);
//        return new R().setSuccess(true).setContent(dictTypeQuery);
    }

    @Override
    protected IService<PlateRegion> getService() {
        return service;
    }

}
