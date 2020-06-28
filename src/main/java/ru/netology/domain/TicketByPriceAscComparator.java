package ru.netology.domain;

import java.util.Comparator;

public class TicketByPriceAscComparator  implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        return t1.getTime() - t1.getTime();
    }
}
