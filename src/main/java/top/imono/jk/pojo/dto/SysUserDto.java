package top.imono.jk.pojo.dto;

import lombok.Data;
import top.imono.jk.pojo.po.SysResource;
import top.imono.jk.pojo.po.SysRole;
import top.imono.jk.pojo.po.SysUser;

import java.util.List;

@Data
public class SysUserDto {
    private SysUser user;
    private List<SysRole> roles;
    private List<SysResource> resources;
}
