package top.imono.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.imono.jk.pojo.dto.ProvinceDto;
import top.imono.jk.pojo.po.ExamPlace;
import top.imono.jk.service.ExamPlaceService;
import top.imono.jk.mapper.ExamPlaceMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author zhoujianshun
* @description 针对表【exam_place(考场)】的数据库操作Service实现
* @createDate 2023-10-31 19:45:49
*/
@Service
public class ExamPlaceServiceImpl extends ServiceImpl<ExamPlaceMapper, ExamPlace>
    implements ExamPlaceService{

    @Override
    public List<ProvinceDto> listRegionExamplePlaces() {
        return baseMapper.selectRegionExamplePlaces();
    }
}




