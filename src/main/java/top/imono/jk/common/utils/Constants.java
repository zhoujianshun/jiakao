package top.imono.jk.common.utils;

public class Constants {
    public static class ImageType {
        public static final short ROUTE = 1;
    }

    public static class SysUserStatus {
        public static final short NORMAL = 0;
        public static final short LOCKED = 1;
    }

    public static class ExamPlaceCourseType {
        public static final short SET = 0;
        public static final short K2 = 2;
        public static final short K3 = 3;
    }

    public static class SysResourceType {
        public static final short DIR = 0;
        public static final short MENU = 1;
        public static final short BTN = 2;
    }

    public static class Permisson {
        public static final String SYS_USER_LIST = "sysUser:list";
        public static final String SYS_USER_ADD = "sysUser:add";
        public static final String SYS_USER_UPDATE = "sysUser:update";
        public static final String SYS_USER_REMOVE = "sysUser:remove";

        public static final String SYS_ROLE_LIST = "sysRole:list";
        public static final String SYS_ROLE_ADD = "sysRole:add";
        public static final String SYS_ROLE_UPDATE = "sysRole:update";
        public static final String SYS_ROLE_REMOVE = "sysRole:remove";

        public static final String SYS_RESOURCE_LIST = "sysResource:list";
        public static final String SYS_RESOURCE_ADD = "sysResource:add";
        public static final String SYS_RESOURCE_UPDATE = "sysResource:update";
        public static final String SYS_RESOURCE_REMOVE = "sysResource:remove";

        public static final String DICT_ITEM_LIST = "dictItem:list";
        public static final String DICT_ITEM_ADD = "dictItem:add";
        public static final String DICT_ITEM_UPDATE = "dictItem:update";
        public static final String DICT_ITEM_REMOVE = "dictItem:remove";
    }
}
