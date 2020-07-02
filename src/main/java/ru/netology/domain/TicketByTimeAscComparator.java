package ru.netology.domain;

import java.util.Comparator;

public class TicketByTimeAscComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        return t1.getTime() - t2.getTime();
    }
}
