package top.imono.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.imono.jk.common.mapStruct.MapStructs;
import top.imono.jk.common.utils.JsonVos;
import top.imono.jk.pojo.po.ExamPlace;
import top.imono.jk.pojo.vo.req.save.ExamPlaceReqVo;
import top.imono.jk.pojo.vo.resp.ProvinceVo;
import top.imono.jk.pojo.vo.resp.json.DataJsonVo;
import top.imono.jk.service.ExamPlaceService;

import java.util.List;

@Tag(name = "考场查询", description = "查询考场查询信息")
@RestController
@RequestMapping("/examplePlace")
public class ExamplePlaceController extends BaseController<ExamPlace, ExamPlaceReqVo> {
    @Autowired
    private ExamPlaceService service;

    @Operation(summary = "查询所有省市下的考场")
    @GetMapping("/regionExamplePlaces")
    public DataJsonVo<List<ProvinceVo>> listRegionExamplePlaces() {
        return JsonVos.success(service.listRegionExamplePlaces());
    }


    @Override
    protected IService<ExamPlace> getService() {
        return service;
    }

    @Override
    protected ExamPlace getPo(ExamPlaceReqVo reqV) {
        return MapStructs.INSTANCE.reqVo2po(reqV);
    }

}
