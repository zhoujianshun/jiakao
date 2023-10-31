package top.imono.jk.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 省份、城市
 * @TableName plate_region
 */
@TableName(value ="plate_region")
@Data
public class PlateRegion implements Serializable {
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
     * 父区域
     */
    @TableField(value = "parent_id")
    private Integer parentId;

    /**
     * 车牌，比如省份是粤、琼、赣，城市是A、B、C、D
     */
    @TableField(value = "plate")
    private String plate;

    /**
     * 拼音
     */
    @TableField(value = "pinyin")
    private String pinyin;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
