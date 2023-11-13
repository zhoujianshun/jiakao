package top.imono.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import top.imono.jk.common.enhance.MpLambdaQueryWrapper;
import top.imono.jk.common.enhance.MpPage;
import top.imono.jk.mapper.SysRoleResourceMapper;
import top.imono.jk.pojo.po.SysResource;
import top.imono.jk.pojo.po.SysRole;
import top.imono.jk.pojo.po.SysRoleResource;
import top.imono.jk.pojo.vo.req.list.SysRolePageReqVo;
import top.imono.jk.pojo.vo.resp.PageVo;
import top.imono.jk.pojo.vo.resp.SysRoleVo;
import top.imono.jk.service.SysResourceService;
import top.imono.jk.mapper.SysResourceMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhoujianshun
 * @description 针对表【sys_resource(资源)】的数据库操作Service实现
 * @createDate 2023-11-13 10:27:20
 */
@Service
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource>
        implements SysResourceService {

    @Autowired
    private SysRoleResourceMapper sysRoleResourceMapper;

    @Transactional(readOnly = true)
    @Override
    public List<SysResource> listByRoleIds(List<Integer> roleIds) {
        if (CollectionUtils.isEmpty(roleIds)) {
            return null;
        }
        List<Integer> resourceIds = listIdsByRoleIds(roleIds);
        if (CollectionUtils.isEmpty(resourceIds)) {
            return null;
        }

        MpLambdaQueryWrapper<SysResource> wrapper = new MpLambdaQueryWrapper<>();
        wrapper.in(SysResource::getId, resourceIds);
        return baseMapper.selectList(wrapper);
    }

    private List<Integer> listIdsByRoleIds(List<Integer> roleIds) {
        MpLambdaQueryWrapper<SysRoleResource> wrapper = new MpLambdaQueryWrapper();
        wrapper.select(SysRoleResource::getResourceId);
        wrapper.in(SysRoleResource::getRoleId, roleIds);

        List<Object> objects = sysRoleResourceMapper.selectObjs(wrapper);
        return objects.stream().map(id -> (Integer) id).toList();
    }
}




