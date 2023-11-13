package top.imono.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import top.imono.jk.common.enhance.MpLambdaQueryWrapper;
import top.imono.jk.common.enhance.MpPage;
import top.imono.jk.common.mapStruct.MapStructs;
import top.imono.jk.mapper.SysUserRoleMapper;
import top.imono.jk.pojo.po.SysRole;
import top.imono.jk.pojo.po.SysUserRole;
import top.imono.jk.pojo.vo.req.list.SysRolePageReqVo;
import top.imono.jk.pojo.vo.resp.PageVo;
import top.imono.jk.pojo.vo.resp.SysRoleVo;
import top.imono.jk.service.SysRoleService;
import top.imono.jk.mapper.SysRoleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhoujianshun
 * @description 针对表【sys_role(角色)】的数据库操作Service实现
 * @createDate 2023-11-13 10:26:36
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
        implements SysRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    @Transactional(readOnly = true)
    public PageVo<SysRoleVo> list(SysRolePageReqVo reqVo) {
        MpLambdaQueryWrapper<SysRole> wrapper = new MpLambdaQueryWrapper<>();
        wrapper.like(reqVo.getKeyword(), SysRole::getName);
        wrapper.orderByDesc(SysRole::getId);
        return baseMapper.selectPage(new MpPage<>(reqVo), wrapper).buildPageVo(MapStructs.INSTANCE::po2vo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SysRole> listByUserId(Integer userId) {
        if (userId == null || userId <= 0) {
            return null;
        }
        List<Integer> roleIds = listIds(userId);

        if (CollectionUtils.isEmpty(roleIds)) {
            return null;
        }
        MpLambdaQueryWrapper<SysRole> wrapper = new MpLambdaQueryWrapper<>();
        wrapper.in(SysRole::getId, roleIds);
        return baseMapper.selectList(wrapper);
    }

    // 通过userid查询roleid
    @Transactional(readOnly = true)
    @Override
    public List<Integer> listIds(Integer userId) {
        MpLambdaQueryWrapper<SysUserRole> wrapper = new MpLambdaQueryWrapper<>();
        wrapper.select(SysUserRole::getRoleId);
        wrapper.eq(SysUserRole::getUserId, userId);
        List<Object> ids = sysUserRoleMapper.selectObjs(wrapper);
        return ids.stream().map(id -> (Integer) id).toList();
    }
}




