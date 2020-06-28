package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void save(Ticket item) {
        repository.save(item);
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().equalsIgnoreCase(from) && ticket.getTo().equalsIgnoreCase(to)) {
            return true;
        }
        return false;
    }

    public Ticket[] findByFromAndTo (String from, String to){
        Ticket[] result = new Ticket[0];
        for (Ticket ticket: repository.findAll()) {
            if (matches(ticket, from, to)){
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

}
