package top.imono.jk.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 考场课程
 * @TableName exam_place_course
 */
@TableName(value ="exam_place_course")
@Data
public class ExamPlaceCourse implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 价格
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 课程类型：0是课程合集，2是科目2，3是科目3
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 
     */
    @TableField(value = "intro")
    private String intro;

    /**
     * 视频
     */
    @TableField(value = "video")
    private String video;

    /**
     * 封面
     */
    @TableField(value = "cover")
    private String cover;

    /**
     * 考场
     */
    @TableField(value = "place_id")
    private Integer placeId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}