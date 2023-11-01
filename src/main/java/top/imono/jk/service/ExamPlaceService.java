package top.imono.jk.service;

import top.imono.jk.pojo.dto.ProvinceDto;
import top.imono.jk.pojo.po.ExamPlace;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author zhoujianshun
* @description 针对表【exam_place(考场)】的数据库操作Service
* @createDate 2023-10-31 19:45:49
*/
public interface ExamPlaceService extends IService<ExamPlace> {
    List<ProvinceDto> listRegionExamplePlaces();
}
