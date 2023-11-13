package top.imono.jk.service;

import top.imono.jk.pojo.po.SysResource;
import com.baomidou.mybatisplus.extension.service.IService;
import top.imono.jk.pojo.vo.req.list.SysRolePageReqVo;
import top.imono.jk.pojo.vo.resp.PageVo;
import top.imono.jk.pojo.vo.resp.SysRoleVo;

import java.util.List;

/**
* @author zhoujianshun
* @description 针对表【sys_resource(资源)】的数据库操作Service
* @createDate 2023-11-13 10:27:20
*/
public interface SysResourceService extends IService<SysResource> {

     List<SysResource> listByRoleIds(List<Integer> roleIds);

}
