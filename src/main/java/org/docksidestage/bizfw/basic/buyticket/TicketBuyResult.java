package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author jflute
 * @author yusuke
 */
public class TicketBuyResult {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========

    private Ticket ticket;
    private int change;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    //
    //

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBuyResult(Ticket ticket, int change) {
        this.ticket = ticket;
        this.change = change;
    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                     ==========

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public Ticket getTicket() {
        return ticket;
    }

    public int getChange() {
        return change;
    }

}