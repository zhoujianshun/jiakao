package top.imono.jk.pojo.vo.resp;

import lombok.Data;

import java.util.List;

@Data
public class CityVo {

    private Integer id;

    private String name;

    private String plate;

    private List<ExamPlaceVo> children;
}
