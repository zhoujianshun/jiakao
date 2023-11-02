package top.imono.jk.pojo.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * 数据字典类型
 */
@Schema(description = "字典类型")
@Data
public class DictTypeVo implements Serializable {
    /**
     * id
     */
    @Schema(description = "字典类型id")
    private Integer id;

    /**
     * 名称
     */
    @Schema(description = "字典类型名称")
    private String name;

    /**
     * 值
     */
    @Schema(description = "字典类型值")
    private String value;

    /**
     * 简介
     */
    @Schema(description = "字典类型简介")
    private String intro;

}
