package org.docksidestage.bizfw.basic.buyticket;

public enum TicketTypes {

    ONE_DAY_TICKET("oneDayTicket", 1), TWO_DAY_TICKET("twoDayTicket", 2);

    private String ticketType;
    private int ticketTypeId;

    private TicketTypes(String ticketType, int ticketTypeId) {
        this.ticketType = ticketType;
        this.ticketTypeId = ticketTypeId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public int getTicketTypeId() {
        return ticketTypeId;
    }

}
