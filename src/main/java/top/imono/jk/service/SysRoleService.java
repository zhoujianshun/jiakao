package top.imono.jk.service;

import top.imono.jk.pojo.po.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import top.imono.jk.pojo.vo.req.list.SysRolePageReqVo;
import top.imono.jk.pojo.vo.resp.PageVo;
import top.imono.jk.pojo.vo.resp.SysRoleVo;

import java.util.List;

/**
 * @author zhoujianshun
 * @description 针对表【sys_role(角色)】的数据库操作Service
 * @createDate 2023-11-13 10:26:36
 */
public interface SysRoleService extends IService<SysRole> {
    PageVo<SysRoleVo> list(SysRolePageReqVo reqVo);

    List<SysRole> listByUserId(Integer userId);
    List<Integer> listIds(Integer userId);
}
