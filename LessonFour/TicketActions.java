package LessonFour;

interface TicketActions {
    boolean reserveTicket();
    boolean deductFunds();
    boolean confirmPurchase();
    void updateTicketAvailability();
    boolean cancelReservation();
}

