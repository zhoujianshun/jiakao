package top.imono.jk.pojo.vo.resp;

import lombok.Data;

import java.util.List;

@Data
public class ProvinceVo {

    private Integer id;

    private String name;

    private String plate;

    private List<CityVo> children;
}
