package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author Yusuke
 */

public enum TicketTypes {

    ONE_DAY_TICKET("oneDayTicket", 1, 7400), //
    TWO_DAY_TICKET("twoDayTicket", 2, 13200), //
    FOUR_DAY_TICKET("fourDayTicket", 4, 22400), //
    TWO_DAY_NIGHT_TICKET("twoDayNightTicket", 2, 7400);

    private final String ticketTypes;
    private final int ticketDays;
    private final int ticketPrice;

    private TicketTypes(String ticketTypes, int ticketDays, int ticketPrice) {
        this.ticketTypes = ticketTypes;
        this.ticketDays = ticketDays;
        this.ticketPrice = ticketPrice;
    }

    public String getTicketTypes() {
        return ticketTypes;
    }

    public int getTicketDays() {
        return ticketDays;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

}
