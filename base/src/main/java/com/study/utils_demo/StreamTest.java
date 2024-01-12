package com.study.utils_demo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yangz
 * @createTime 2023/7/20 - 10:01
 * 使用stream流式计算对集合进行筛选,排序,聚合等.
 */
public class StreamTest {
    public static void main(String[] args) {
        //测试数据
        List<Person> people = new ArrayList<>();
        people.add(new Person("Tom", 8900, 17, "male", "New York"));
        people.add(new Person("Jack", 7000, 20, "male", "Washington"));
        people.add(new Person("Lily", 7800, 22, "female", "Washington"));
        people.add(new Person("Anni", 8200, 45, "female", "New York"));
        people.add(new Person("Alisa", 7900, 35, "female", "New York"));


        /* 1.筛选(filter) 按照一定的规则校验流中的元素,将符合条件的元素提取到新的流中的操作 */
        //输出满足年龄大于18岁的人
        people.stream().filter(person -> person.getAge() > 18).forEach(System.out::println);
        //获取满足年龄大于18岁的第一个人并打印出来
        Optional<Person> person1 = people.stream().filter(person -> person.getAge() > 18).findFirst();
        System.out.println(person1.get());

        /*2 聚合(max/min/count) 对集合,数组的数据统计 */
        //获取员工工资最高的人
        Optional<Person> maxSalary = people.stream().max(Comparator.comparing(Person::getSalary));
        System.out.println(maxSalary.get());
        //获取员工中未成年的元素的个数。
        long count = people.stream().filter(person -> person.getAge() < 18).count();
        System.out.println(count);

        /* 3.映射(map/flatMap) 可以将一个流的元素按照一定的映射规则映射到另一个流中 */
        //将员工的薪资全部增加1000. 会改变原始集合的数据
        List<Person> newPeople = people.stream().map(person -> {
            person.setSalary(person.getSalary() + 1000);
            return person;
        }).collect(Collectors.toList());
        System.out.println("原始集合: " + people.get(0).getSalary());
        System.out.println("新集合: " + newPeople.get(0).getSalary());

        /* 4.归约(reduce) 是把一个流缩减成一个值,能实现对集合求和,求乘积和求最值操作 */
        // 求工资之和
        Optional<Integer> sumSalary = people.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println("员工工资之和: " + sumSalary.get());

        /* 5.收集(collect) 把一个流收集起来，最终可以是收集成一个值也可以收集成一个新的集合*/
        // 求平均工资
        Double average = people.stream().collect(Collectors.averagingDouble(Person::getSalary));
        // 一次性统计所有信息
        DoubleSummaryStatistics collect = people.stream().collect(Collectors.summarizingDouble(Person::getSalary));

        /* 6.分组(partitioningBy/groupingBy) */
        //根据性别分组
        Map<String, List<Person>> groupBYSex = people.stream().collect(Collectors.groupingBy(Person::getSex));
        for (Map.Entry<String, List<Person>> stringListEntry : groupBYSex.entrySet()) {
            System.out.println(stringListEntry);
        }
    }
}
