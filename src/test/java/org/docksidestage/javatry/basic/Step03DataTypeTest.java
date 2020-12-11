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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of data type. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author yusuke
 */
public class Step03DataTypeTest extends PlainTestCase {

    // ===================================================================================
    //                                                                          Basic Type
    //                                                                          ==========
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_datatype_basicType() {
        String sea = "mystic"; //seaにmysticを代入
        Integer land = 416; //landに416を代入
        LocalDate piari = LocalDate.of(2001, 9, 4); //LocalDate:日付を表す不変の日付/時間オブジェクト
        LocalDateTime bonvo = LocalDateTime.of(2001, 9, 4, 12, 34, 56); //LocalDateTime:日付/時間を表す不変の日付/時間オブジェクト
        Boolean dstore = true; //dstoreは正である
        BigDecimal amba = new BigDecimal("9.4"); //ambaに9.4を代入

        piari = piari.plusDays(1); //日付に1日加算
        land = piari.getYear(); //landに2001を上書き
        bonvo = bonvo.plusMonths(1); //月に1ヶ月加算
        land = bonvo.getMonthValue(); //landに10を上書き
        land--; //landの値から1を引く（land == 9）
        if (dstore) {
            BigDecimal addedDecimal = amba.add(new BigDecimal(land)); //9.4に9を加算　　9.4 + 9 = 18.4
            sea = String.valueOf(addedDecimal); //文字列に変換
        }
        log(sea); // your answer? => 18.4
    }

    // ===================================================================================
    //                                                                           Primitive
    //                                                                           =========
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_datatype_primitive() {
        byte sea = 127; // max
        short land = 32767; // max
        int piari = 2147483647; // max
        long bonvo = 9223372036854775807L; // max
        float dstore = 2147483647.1f;
        double amba = 2.3d;
        char miraco = 'a';
        boolean dohotel = miraco == 'a';
        if (dohotel && dstore >= piari) {
            bonvo = sea; //bonvo = 127
            land = (short) bonvo; //land = 127
            bonvo = piari; //bonvo = 2147483647
            sea = (byte) land; //sea = 127
            if (amba == 2.3D) {
                sea = (byte) amba; //sea = 2
            }
        }
        if (dstore > piari) { //この辺りがちょっと・・・　dstore == piari? 0.1は誤差？　違う型同士を比較すると本来はエラーになるが javaがfloatをintに変換している
            sea = 0;
        }
        log(sea); // your answer? => 2
    }

    // ===================================================================================
    //                                                                              Object
    //                                                                              ======
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_datatype_object() {
        St3ImmutableStage stage = new St3ImmutableStage("hangar");
        String sea = stage.getStageName();
        log(sea); // your answer? => hangar
    }

    private static class St3ImmutableStage {

        private final String stageName; //final：一度しか値を代入することができない変数の宣言

        public St3ImmutableStage(String stageName) {
            this.stageName = stageName; //stageNameに"hangar"を代入
        }

        public String getStageName() {
            return stageName; //getStageNameにstageNameを返却する
        }
    }
}
