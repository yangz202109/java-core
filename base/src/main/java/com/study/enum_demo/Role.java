package com.study.enum_demo;

/**
 * @author yangz
 * @createTime 2023/6/29 - 14:29
 */
public enum Role {
    /*枚举类的所有实例必须放在第一行显示,不需使用new,不需显示调用构造方法,
    每个变量都是public static final修饰的,最终以分号结束.
     ↓ name属性*/
    ROLE_ADMIN("管理员",1111),
    ROLE_SALE("销售",2222),
    ROLE_TEST("测试",3333);


    /**
     *  角色名称
     */
    private final String roleName;

    /**
     * 角色编码
     */
    private final Integer roleCode;

    /**
     * 构造方法必然是private修饰的 就算不写也是默认的
     */
     Role( String roleName, Integer roleCode ) {
        this.roleName = roleName;
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public Integer getRoleCode() {
        return roleCode;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                ", roleCode=" + roleCode +
                '}';
    }
}
