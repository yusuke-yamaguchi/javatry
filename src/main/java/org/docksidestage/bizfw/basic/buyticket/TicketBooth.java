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
package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author jflute
 * @author Yusuke
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int MAX_QUANTITY = 10;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private int quantity = MAX_QUANTITY;
    private Integer salesProceeds;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBooth() {
    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                          ==========
    // リファクタリング前
    //    public void buyOneDayPassport(int handedMoney) {
    //        if (quantity <= 0) { // 在庫数が0以下の場合"Sold out（売り切れ）を投げる"
    //            throw new TicketSoldOutException("Sold out");
    //        }
    //        // 
    //        // --quantity; // 在庫数から1減らす
    //        if (handedMoney < ONE_DAY_PRICE) { // 持っている金額より1日パスの金額が大きい場合（つまり手持ちのお金が足りない場合）
    //            throw new TicketShortMoneyException("Short money: " + handedMoney); // 
    //        }
    //        --quantity;
    //        if (salesProceeds != null) { // 売上収益が0ではない場合（売れた場合）
    //            salesProceeds = salesProceeds + ONE_DAY_PRICE;
    //        } else {
    //            salesProceeds = ONE_DAY_PRICE;
    //        }
    //    }
    //
    //    public int buyTwoDayPassport(int handedMoney) {
    //        if (quantity <= 1) { // 在庫数が2以下の場合"Sold out（売り切れ）を投げる"
    //            throw new TicketSoldOutException("Sold out");
    //        }
    //        if (handedMoney < TWO_DAY_PRICE) {
    //            throw new TicketShortMoneyException("Short money: " + handedMoney);
    //        }
    //        quantity -= 2; // 2枚ずつ在庫から消費する
    //        if (salesProceeds != null) {
    //            salesProceeds = salesProceeds + TWO_DAY_PRICE;
    //        } else {
    //            salesProceeds = TWO_DAY_PRICE;
    //        }
    //        return handedMoney - TWO_DAY_PRICE; // おつりの値を返す
    //    }

    // done リファクタリング途中　チケット購入のフローをもう少しまとめたい (2020/10/16)
    public Ticket buyOneDayPassport(int handedMoney) {
        final TicketTypes ticketTypes = TicketTypes.ONE_DAY_TICKET; // TicketTypesクラスから判別用の値を取得する
        final int ticketPrice = ticketTypes.getTicketPrice();
        final int ticketCount = ticketTypes.getTicketDays();
        doBuyPassport(ticketCount, ticketPrice, handedMoney);
        final Ticket ticket = new Ticket(ticketTypes);
        return ticket;
    }

    public TicketBuyResult buyTwoDayPassport(int handedMoney) {
        final TicketTypes ticketTypes = TicketTypes.TWO_DAY_TICKET; // TicketTypesクラスから判別用の値を取得する
        final int ticketPrice = ticketTypes.getTicketPrice();
        final int ticketCount = ticketTypes.getTicketDays();
        doBuyPassport(ticketCount, ticketPrice, handedMoney);
        TicketBuyResult buyResult = buyPassportResult(ticketTypes, ticketPrice, handedMoney); // done チケット購入結果取得用の共通処理の追加

        return buyResult;
    }

    // FourDayPassport購入用
    public TicketBuyResult buyFourDayPassport(int handedMoney) {
        final TicketTypes ticketTypes = TicketTypes.FOUR_DAY_TICKET;
        final int ticketPrice = ticketTypes.getTicketPrice();
        final int ticketCount = ticketTypes.getTicketDays();
        doBuyPassport(ticketCount, ticketPrice, handedMoney);
        TicketBuyResult buyResult = buyPassportResult(ticketTypes, ticketPrice, handedMoney);

        return buyResult;
    }

    // NightOnlyTwoDayPassport購入用
    public TicketBuyResult buyNightOnlyTwoDayPassport(int handedMoney) {
        final TicketTypes ticketTypes = TicketTypes.TWO_DAY_NIGHT_TICKET;
        final int ticketPrice = ticketTypes.getTicketPrice();
        final int ticketCount = ticketTypes.getTicketDays();
        doBuyPassport(ticketCount, ticketPrice, handedMoney);
        TicketBuyResult buyResult = buyPassportResult(ticketTypes, ticketPrice, handedMoney);

        return buyResult;
    }

    /**
     * チケット購入周りの処理
     * @param ticketCount チケット枚数
     * @param ticketPrice チケットの値段
     * @param handedMoney 所持金
     */
    private void doBuyPassport(int ticketCount, int ticketPrice, int handedMoney) {
        assertInventoryRemained(ticketCount); // 在庫数確認処理
        possessionMoneyEnough(ticketPrice, handedMoney); // 所持金とチケットの金額確認処理
        prosessPurchasedTicketInventory(ticketPrice, ticketCount); // チケット購入後の在庫と売上処理
    }

    /**
     * チケット購入結果取得用の共通処理
     * @param ticketTypes チケット種別
     * @param ticketPrice チケットの値段
     * @param handedMoney 所持金
     */
    private TicketBuyResult buyPassportResult(TicketTypes ticketTypes, int ticketPrice, int handedMoney) {
        final int change = handedMoney - ticketPrice;
        final Ticket ticket = new Ticket(ticketTypes);
        TicketBuyResult buyResult = new TicketBuyResult(ticket, change);

        return buyResult;
    }

    /**
     * 在庫数確認処理
     * @param passportDays 選択したチケット枚数
     */
    // done javayusuke checkInventory() or assertInventoryRemained/Exists() by jflute (2020/10/16)
    // メソッド名を選択して、ctrl+1 => rename in file
    private void assertInventoryRemained(int passportDays) {
        if (quantity < passportDays) { // 在庫数がパスポートの日数以下の場合"Sold out（売り切れ）を投げる"
            throw new TicketSoldOutException("Sold out");
        }
    }

    /**
     * 所持金とチケットの金額確認処理
     * @param ticketMoney 選択したチケットの値段
     * @param handedMoney 所持金
     */
    private void possessionMoneyEnough(int ticketMoney, int handedMoney) {
        if (handedMoney < ticketMoney) { // 持っている金額より購入予定のパスポートの金額が大きい場合（つまり手持ちのお金が足りない場合）エラーを投げる
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
    }

    /**
     * チケット購入後の在庫と売上処理
     * @param boughtTicketPrice 購入済みチケットの値段
     * @param boughtTicketCount 購入済みチケットの枚数
     */

    // done メソッド名と引数名を修正する。
    private void prosessPurchasedTicketInventory(int boughtTicketPrice, int boughtTicketCount) {
        quantity -= boughtTicketCount;

        if (salesProceeds != null) { // 売上収益が0ではない場合（売れた場合）
            salesProceeds = salesProceeds + boughtTicketPrice;
        } else {
            salesProceeds = boughtTicketPrice;
        }
    }

    public static class TicketSoldOutException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketSoldOutException(String msg) {
            super(msg);
        }
    }

    public static class TicketShortMoneyException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketShortMoneyException(String msg) {
            super(msg);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getQuantity() {
        return quantity;
    }

    public Integer getSalesProceeds() {
        return salesProceeds;
    }
}
