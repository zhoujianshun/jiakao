package top.imono.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.imono.jk.common.mapStruct.MapStructs;
import top.imono.jk.common.utils.JsonVos;
import top.imono.jk.pojo.po.PlateRegion;
import top.imono.jk.pojo.vo.req.list.ProvincesPageReqVo;
import top.imono.jk.pojo.vo.req.save.PlateRegionReqVo;
import top.imono.jk.pojo.vo.resp.PlateRegionVo;
import top.imono.jk.pojo.vo.resp.ProvinceVo;
import top.imono.jk.pojo.vo.resp.json.DataJsonVo;
import top.imono.jk.pojo.vo.resp.json.ListJsonVo;
import top.imono.jk.service.PlateRegionService;

import java.util.List;

@RestController
@RequestMapping("/plateRegions")
public class PlateRegionController extends BaseController<PlateRegion, PlateRegionReqVo> {
    @Autowired
    private PlateRegionService service;

    @GetMapping("/regions")
    public DataJsonVo<List<ProvinceVo>> listRegions() {
        return JsonVos.success(service.listRegions());
//        return new R().setSuccess(true).setContent(dictTypeQuery);
    }

    @GetMapping("/provinces")
    public ListJsonVo<PlateRegionVo> listProvinces(@Valid ProvincesPageReqVo provincesQuery) {
        return JsonVos.success(service.listProvinces(provincesQuery));
//        return new R().setSuccess(true).setContent(dictTypeQuery);
    }

    @Override
    protected IService<PlateRegion> getService() {
        return service;
    }

    @Override
    protected PlateRegion getPo(PlateRegionReqVo reqV) {
        return MapStructs.INSTANCE.reqVo2po(reqV);
    }

}
