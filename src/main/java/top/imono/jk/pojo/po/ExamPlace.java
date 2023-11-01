package top.imono.jk.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 考场
 * @TableName exam_place
 */
@TableName(value ="exam_place")
@Data
public class ExamPlace implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 考场是哪个省份的
     */
    @TableField(value = "province_id")
    private Integer provinceId;

    /**
     * 考场是哪个城市的
     */
    @TableField(value = "city_id")
    private Integer cityId;

    /**
     * 考场的具体地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 纬度
     */
    @TableField(value = "latitude")
    private BigDecimal latitude;

    /**
     * 经度
     */
    @TableField(value = "longitude")
    private BigDecimal longitude;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
