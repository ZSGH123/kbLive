package com.kblive.usersystem.common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * title: ListTest
 * projectName kbLive
 * description:
 * author 2671242147@qq.com
 * date 2019-09-07 11:50
 ***/
public class ListTest {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();


        stringList.add(null);
        stringList.add("eqw");
        System.out.println(stringList.size());
    }

    @Test
    public void listTest() {
        List<String> stringList = new ArrayList<>();
        stringList.add(null);
        stringList.add("eqw");
        System.out.println(stringList.size());
    }


}
