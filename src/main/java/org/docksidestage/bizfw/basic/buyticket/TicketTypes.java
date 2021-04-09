package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author Yusuke
 */

public enum TicketTypes {

    ONE_DAY_TICKET("oneDayTicket", 1), TWO_DAY_TICKET("twoDayTicket", 2);

    private final String ticketTypes;
    private final int ticketTypeId;

    private TicketTypes(String ticketTypes, int ticketTypeId) {
        this.ticketTypes = ticketTypes;
        this.ticketTypeId = ticketTypeId;
    }

    public String getTicketTypes() {
        return ticketTypes;
    }

    public int getTicketTypeId() {
        return ticketTypeId;
    }

}
