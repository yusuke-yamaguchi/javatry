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
public class Ticket {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private final int displayPrice;
    private final TicketTypes ticketTypes;
    private final int ticketDays;

    private boolean alreadyIn = false;
    private int doInPark = 0;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Ticket(TicketTypes ticketTypes) {
        this.ticketTypes = ticketTypes;
        this.displayPrice = ticketTypes.getTicketPrice();
        this.ticketDays = ticketTypes.getTicketDays();

    }

    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======
    public void doInPark() {
        if (ticketDays > doInPark) {
            doInPark += 1;
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        } else {
            alreadyIn = true;
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getDisplayPrice() {
        return displayPrice;
    }

    public TicketTypes getTicketTypes() {
        return ticketTypes;
    }

    public int getDoInPark() {
        return doInPark;
    }

    public boolean isAlreadyIn() {
        return alreadyIn;
    }
}
