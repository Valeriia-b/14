package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketByPriceAscComparator;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);
    private Ticket ticket1 = new Ticket(1, 1299, "DME", "KZN", 90);
    private Ticket ticket2 = new Ticket(2, 1500, "DME", "KZN", 95);
    private Ticket ticket3 = new Ticket(3, 2199, "VKO", "KZN", 95);
    private Ticket ticket4 = new Ticket(4, 3399, "ARH", "DME", 100);

    @BeforeEach
    public void save(){
        manager.save(ticket1);
        manager.save(ticket2);
        manager.save(ticket3);
        manager.save(ticket4);
    }

    @Test
    void shouldFind (){
        Ticket[] actual = manager.findByFromAndTo("DME", "KZN");
        Ticket[] expected = new Ticket[] {ticket1, ticket2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindIfNotExist() {
        Ticket[] actual = manager.findByFromAndTo("DME", "SVO");
        Ticket[] expected = new Ticket[] {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll (){
        Ticket[] actual = repository.findAll();
        Ticket[] expected = new Ticket[] {ticket1, ticket2, ticket3, ticket4};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(2);
        Ticket[] expected = new Ticket[] {ticket1, ticket3, ticket4};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldFindFaster(){
        Ticket[] actual = manager.findFromAndToAndFaster("DME", "KZN", new TicketByPriceAscComparator());
        Ticket[] expected = new Ticket[] {ticket1, ticket2};
        assertArrayEquals(expected, actual);
    }


}