package com.zjh.tomato.test;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author zjh
 */
class TestMd5 {
    public static void main(String[] args) {
        SimpleHash  simpleHash = new SimpleHash("MD5","admin","1111",2);
        System.out.println("simpleHash.toString() = " + simpleHash.toString());
        System.out.println("simpleHash.toHex() = " + simpleHash.toHex());


    }
}
