/*
 * Copyright 2019-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.javatry.basic;

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of method. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author your_name_here
 */
public class Step04MethodTest extends PlainTestCase {

    // ===================================================================================
    //                                                                         Method Call
    //                                                                         ===========
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_method_call_basic() {
        String sea = supplySomething();
        log(sea); // your answer? => over
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_method_call_many() {
        String sea = functionSomething("mystic"); // seaに"mysmys"を代入
        consumeSomething(supplySomething());
        runnableSomething();
        log(sea); // your answer? => mysmys
    }

    private String functionSomething(String name) {
        String replaced = name.replace("tic", "mys"); // "tic"を"mys"に置き換える　"mystic" → "mysmys"
        log("in function: {}", replaced);
        return replaced;
    }

    private String supplySomething() {
        String sea = "over"; // seaに"over"を代入
        log("in supply: {}", sea);
        return sea;
    }

    private void consumeSomething(String sea) {
        log("in consume: {}", sea.replace("over", "mystic")); // "over"を"mystic"に置き換えて表示
    } // 返り値なし

    private void runnableSomething() {
        String sea = "outofshadow";
        log("in runnable: {}", sea);
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_method_object() {
        St4MutableStage mutable = new St4MutableStage();
        int sea = 904; // seaに904を代入
        boolean land = false; // landにfalseを指定
        helloMutable(sea - 4, land, mutable); // mutable　:　mystic
        if (!land) {
            sea = sea + mutable.getStageName().length(); // 904 + mysticの文字数（6）  904 + 6 = 910
        }
        log(sea); // your answer? => 910
    }

    private int helloMutable(int sea, Boolean land, St4MutableStage piari) {
        sea++;
        land = true;
        piari.setStageName("mystic");
        return sea;
    }

    private static class St4MutableStage {

        private String stageName;

        public String getStageName() {
            return stageName;
        }

        public void setStageName(String stageName) {
            this.stageName = stageName;
        }
    }

    // ===================================================================================
    //                                                                   Instance Variable
    //                                                                   =================
    private int inParkCount;
    private boolean hasAnnualPassport;

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_method_instanceVariable() {
        hasAnnualPassport = true; // hasAnnualPassportにtrueを指定
        int sea = inParkCount; // seaにinParkCountを代入
        offAnnualPassport(hasAnnualPassport); // hasAnnualPassport ： true
        for (int i = 0; i < 100; i++) { // i = 0～99
            goToPark();
        }
        ++sea; // sea = 1
        sea = inParkCount; // seaにinParkCountを代入　inParkCount = 100
        log(sea); // your answer? => 100
    }

    private void offAnnualPassport(boolean hasAnnualPassport) {
        hasAnnualPassport = false;
    }

    private void goToPark() {
        if (hasAnnualPassport) { // trueの場合
            ++inParkCount;
        }
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    // write instance variables here
    /**
     * Make private methods as followings, and comment out caller program in test method:
     * <pre>
     * o replaceAtoB(): has one argument as String, returns argument replaced "A" with "B" as String 
     * o replaceCtoB(): has one argument as String, returns argument replaced "C" with "B" as String 
     * o addPrefix(): has two arguments as String, returns combined first argument with ":" with second argument 
     * o isAvailableLogging(): no argument, returns private instance variable "availableLogging" initialized as true (also make it)  
     * o showSea(): has one argument as String argument, no return, show argument by log()
     * </pre>
     * (privateメソッドを以下のように定義して、テストメソッド内の呼び出しプログラムをコメントアウトしましょう):
     * <pre>
     * o replaceAtoB(): 一つのString引数、引数を "A" を "B" に置き換えらたStringを戻す 
     * o replaceCtoB(): 一つのString引数、引数を "C" を "B" に置き換えらたStringを戻す 
     * o addPrefix(): 二つのString引数、第一引数と ":" と第二引数を連結したものを戻す 
     * o isAvailableLogging(): 引数なし、privateのインスタンス変数 "availableLogging" (初期値:true) を戻す (それも作る)  
     * o showSea(): 一つのString引数、戻り値なし、引数をlog()で表示する
     * </pre>
     */
    private boolean availableLogging = true; // availableLoggingにtrueを指定

    public void test_method_making() {
        String replaced = replaceCtoB(replaceAtoB("ABC")); // replaced = "BBB"
        String sea = addPrefix("broadway", replaced); // sea = broadway:BBB 
        if (isAvailableLogging()) {
            showSea(sea);
        }
    }

    private String replaceAtoB(String replaceTarget) {
        return replaceTarget.replace("A", "B"); // AをBに置き換え
    }

    private String replaceCtoB(String replaceTarget) {
        return replaceTarget.replace("C", "B"); // CをBに置き換え
    }

    private String addPrefix(String prefix, String linkText) {
        return prefix + ":" + linkText; // ２つの引数を連結したものを戻す
    }

    private boolean isAvailableLogging() {
        return availableLogging;
    }

    private void showSea(String sea) {
        log(sea);
    }
}
