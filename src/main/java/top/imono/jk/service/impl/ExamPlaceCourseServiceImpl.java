package top.imono.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import top.imono.jk.common.enhance.MpPage;
import top.imono.jk.common.enhance.MpQueryWrapper;
import top.imono.jk.pojo.po.ExamPlaceCourse;
import top.imono.jk.pojo.vo.req.list.ExamPlaceCourseListReqVo;
import top.imono.jk.pojo.vo.resp.ExamPlaceCourseVo;
import top.imono.jk.pojo.vo.resp.PageVo;
import top.imono.jk.service.ExamPlaceCourseService;
import top.imono.jk.mapper.ExamPlaceCourseMapper;
import org.springframework.stereotype.Service;

/**
 * @author zhoujianshun
 * @description 针对表【exam_place_course(考场课程)】的数据库操作Service实现
 * @createDate 2023-11-02 14:31:21
 */
@Service
@Transactional
public class ExamPlaceCourseServiceImpl extends ServiceImpl<ExamPlaceCourseMapper, ExamPlaceCourse>
        implements ExamPlaceCourseService {

    @Override
    @Transactional(readOnly = true)
    public PageVo<ExamPlaceCourseVo> list(ExamPlaceCourseListReqVo reqVo) {
        MpQueryWrapper<ExamPlaceCourse> wrapper = new MpQueryWrapper<>();

        // 类型
        Short type = reqVo.getType();
        if (type != null && type >= 0) {
            wrapper.eq("c.type", type);
        }

        // 考场 -> 城市 -> 省份
        Integer placeId = reqVo.getPlaceId();
        Integer provinceId = reqVo.getProvinceId();
        Integer cityId = reqVo.getCityId();
        if (placeId != null && placeId > 0) {
            wrapper.eq("c.place_id", placeId);
        } else if (provinceId != null && provinceId > 0) {
            wrapper.eq("c.province_id", provinceId);
        } else if (cityId != null && cityId > 0) {
            wrapper.eq("c.city_id", cityId);
        }

        // 关键词
        wrapper.like(reqVo.getKeyword(), "c.name", "c.intro");
//        String[] list = new String[]{"c.name", "c.intro"};
//        String keyword = reqVo.getKeyword();
//        if (StringUtils.hasLength(keyword)) {
//            wrapper.nested(w -> {
//                for (String s : list) {
//                    w.like(s, keyword).or();
//                }
//            });
//        }


        return baseMapper.select(new MpPage<>(reqVo), wrapper).buildPageVo();
    }
}




