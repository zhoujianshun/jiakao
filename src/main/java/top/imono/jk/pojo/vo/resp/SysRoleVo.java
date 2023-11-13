package top.imono.jk.pojo.vo.resp;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "系统角色")
public class SysRoleVo {
    @Schema(description = "id")
    private Short id;

    @Schema(description = "名称")
    private String name;
}
