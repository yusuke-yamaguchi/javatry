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

import java.util.ArrayList;
import java.util.List;

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of if-for. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author yusuke
 */
public class Step02IfForTest extends PlainTestCase {

    // ===================================================================================
    //                                                                        if Statement
    //                                                                        ============
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_if_basic() {
        int sea = 904;
        if (sea >= 904) {
            sea = 2001;
        }
        log(sea); // your answer? => 2001
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_else_basic() {
        int sea = 904;
        if (sea > 904) {
            sea = 2001;
        } else {
            sea = 7;
        }
        log(sea); // your answer? => 7
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_elseif_basic() {
        int sea = 904;
        if (sea > 904) {
            sea = 2001;
        } else if (sea >= 904) {
            sea = 7;
        } else if (sea >= 903) {
            sea = 8;
        } else {
            sea = 9;
        }
        log(sea); // your answer? => 7
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_elseif_nested() {
        boolean land = false; // landの初期値はfalse
        int sea = 904;
        if (sea > 904) {
            sea = 2001;
        } else if (land && sea >= 904) { // false && sea >= 904
            sea = 7;
        } else if (sea >= 903 || land) { // sea >= 903 || false
            sea = 8;
            if (!land) {
                land = true;
            } else if (sea <= 903) {
                sea++;
            } // land = true
        } else {
            sea = 9;
        }
        if (land) { // land = true
            sea = 10;
        }
        log(sea); // your answer? => 10
    }

    // ===================================================================================
    //                                                                       for Statement
    //                                                                       =============
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_inti_basic() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (int i = 0; i < stageList.size(); i++) { // iの値がstageListの要素数より大きくなるまで
            String stage = stageList.get(i); // stageにi番目の文字列を代入
            if (i == 1) { // iの値が1のとき
                sea = stage; //seaにstageの文字列を代入
            }
        }
        log(sea); // your answer? => dockside
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_foreach_basic() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (String stage : stageList) {
            sea = stage; // seaにstageの文字列を代入
        }
        log(sea); // your answer? => magiclamp
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_foreach_continueBreak() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (String stage : stageList) {
            if (stage.startsWith("br")) { // stageに代入されている文字列が"br"で始まる
                continue; // 次の処理を行わない
            }
            sea = stage; // seaにstageの値を代入
            if (stage.contains("ga")) { // stageに代入されている文字列が"ga"を含む
                break; // おわり
            }
        }
        log(sea); // your answer? => hangar
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_listforeach_basic() {
        List<String> stageList = prepareStageList();
        StringBuilder sb = new StringBuilder(); // StringBuilder : 文字列を扱うクラス（Immutable）
        stageList.forEach(stage -> { // コレクション名(Listなどの変数名).forEach(引数 -> 繰り返し行う処理(引数))
            if (sb.length() > 0) { // sbの文字列の文字数が0以上のとき
                return;
            }
            if (stage.contains("i")) { // stageに代入されている文字列が"i"を含む
                sb.append(stage); // stageの文字列をsbに追加
            }
        });
        String sea = sb.toString(); // sbをstring型に変換しseaに代入
        log(sea); // your answer? => dockside
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * Make list containing "a" from list of prepareStageList() and show it as log by loop. (without Stream API) <br>
     * (prepareStageList()のリストから "a" が含まれているものだけのリストを作成して、それをループで回してログに表示しましょう。(Stream APIなしで))
     */
    public void test_iffor_making() {
        // write if-for here
        List<String> stageList = prepareStageList();
        List<String> sea = new ArrayList<>();
        stageList.forEach(stage -> {
            if (stage.contains("a")) { // stageの文字列がaを含む場合
                sea.add(stage);
            }
        });
        log(sea);
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * Change foreach statement to List's forEach() (keep result after fix) <br>
     * (foreach文をforEach()メソッドへの置き換えてみましょう (修正前と修正後で実行結果が同じになるように))
     */
    public void test_iffor_refactor_foreach_to_forEach() {
        List<String> stageList = prepareStageList();
        //        String sea = null;
        //        for (String stage : stageList) {
        //            if (stage.startsWith("br")) {
        //                continue;
        //            }
        //            sea = stage;
        //            if (stage.contains("ga")) {
        //                break;
        //            }
        //        }
        StringBuilder gaSb = new StringBuilder(); // ga専用のStringBuilderにする
        ArrayList<String> reserveList = new ArrayList<String>(); // 予備のリストを定義
        String sea;
        stageList.forEach(stage -> {
            if (stage.startsWith("br") || gaSb.length() > 0) { // brで始まる場合、もしくはgaが格納されている場合
                return;
            }
            reserveList.clear(); // 予備のリストの中身をクリア
            reserveList.add(stage); // 一旦予備のリストに格納
            if (stage.contains("ga")) { // gaが含まれる場合
                gaSb.append(stage); // gaSbにstageの文字列を追加
            }
        });
        if (gaSb.length() == 0) { // gaSbにgaが入っていない場合
            sea = reserveList.get(0); // 予備のリストの値をseaに代入
        } else {
            sea = gaSb.toString(); // gaSbの値をseaに代入
        }
        log(sea); // should be same as before-fix
    }

    /**
     * Make your original exercise as question style about if-for statement. <br>
     * (if文for文についてあなたのオリジナルの質問形式のエクササイズを作ってみましょう)
     * <pre>
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * your question here (ここにあなたの質問を):
     * 
     * _/_/_/_/_/_/_/_/_/_/
     * </pre>
     */
    public void test_iffor_yourExercise() {
        // write your code here
    }

    // ===================================================================================
    //                                                                        Small Helper
    //                                                                        ============
    private List<String> prepareStageList() {
        List<String> stageList = new ArrayList<>();
        stageList.add("broadway");
        stageList.add("dockside");
        //        stageList.add("hangar");
        stageList.add("magiclamp");
        //        stageList.add("ga");
        return stageList;
    }
}
