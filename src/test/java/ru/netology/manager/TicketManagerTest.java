package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketByTimeAscComparator;
import ru.netology.repository.TicketRepository;
import ru.netology.repository.TicketRepository;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    private TicketRepository repository = new TicketRepository();
    private Ticket ticket1 = new Ticket(1, 200, "ALA", "SWE", 300);
    private Ticket ticket2 = new Ticket(2, 300, "ALA", "SWE", 350);
    private Ticket ticket3 = new Ticket(3, 400, "ALA", "SWE", 360);
    private Ticket ticket4 = new Ticket(4, 700, "ALA", "SIP", 300);
    private Ticket ticket5 = new Ticket(5, 200, "ALA", "SWE", 120);
    private Ticket ticket6 = new Ticket(6, 600, "ALA", "SSE", 400);
    TicketByTimeAscComparator comparator = new TicketByTimeAscComparator();




    @Test
    void searchByAndSortAllTickets() {
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
        repository.save(ticket5);
        repository.save(ticket6);

        TicketManager manager = new TicketManager(repository);

        Ticket[] actual = manager.searchBy("ALA", "SWE",comparator);
        Ticket[] expected = new Ticket[]{ticket5, ticket1, ticket2, ticket3};


        assertArrayEquals(actual, expected);


    }

    @Test
    void searchByAndSortOneTicket() {
        repository.save(ticket5);

        TicketManager manager = new TicketManager(repository);
        Ticket[] actual = manager.searchBy("ALA", "SWE",comparator);
        Ticket[] expected = new Ticket[]{ticket5};

        assertArrayEquals(actual, expected);

    }

    @Test
    void searchByAndSortNoTickets() {

        repository.save(ticket4);
        repository.save(ticket6);

        TicketManager manager = new TicketManager(repository);
        Ticket[] actual = manager.searchBy("ALA", "SWE",comparator);
        Ticket[] expected = new Ticket[]{};

        assertArrayEquals(actual, expected);

    }

    @Test
    void searchByAndSortTicketsWithSamePrice() {
        repository.save(ticket1);
        repository.save(ticket5);


        TicketManager manager = new TicketManager(repository);
        Ticket[] actual = manager.searchBy("ALA", "SWE",comparator);
        Ticket[] expected = new Ticket[]{ticket5, ticket1}; // два билета с одинаковой стоимостью

        assertArrayEquals(actual, expected);

    }
}