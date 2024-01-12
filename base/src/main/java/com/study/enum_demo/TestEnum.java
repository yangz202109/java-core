package com.study.enum_demo;

/**
 * @author yangz
 * @date 2022/12/30 - 16:12
 */
public class TestEnum {
    public static void main(String[] args) {

        //返回包括所有枚举变量的数组.
        Role[] roles = Role.values();
        for (Role role : roles) {
            //System.out.println("name = " + role.name() + " ,roleName = " + role.getRoleName());
            System.out.println(role);
        }

        //返回当前枚举类的name属性,如果没有,则throw new java.lang.IllegalArgumentException().
        System.out.println( Role.valueOf("ROLE_ADMIN"));

        //返回对应的name属性
        System.out.println(Role.ROLE_TEST.toString());

        //返回根据我们定义的次序，从0开始。如果在定义时调换ROLE_ADMIN的次序，返回的数字也会对应的变化
        System.out.println(Role.ROLE_ADMIN.ordinal());

    }
}
