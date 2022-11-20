package ru.netology.FlightSearch.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.FlightSearch.domain.AirTicketData;

public class TicketManagerTest {

    TicketRepository mass = new TicketRepository();
    TicketManager manager = new TicketManager(mass);

    AirTicketData ticket1 = new AirTicketData(1, 5000, "DME", "OGZ", 120);
    AirTicketData ticket2 = new AirTicketData(2, 2000, "DME", "LED", 180);
    AirTicketData ticket3 = new AirTicketData(3, 6000, "DME", "OGZ", 60);
    AirTicketData ticket4 = new AirTicketData(4, 6000, "DME", "OGZ", 240);
    AirTicketData ticket5 = new AirTicketData(5, 3000, "DME", "FRU", 360);
    AirTicketData ticket6 = new AirTicketData(6, 1000, "DME", "OGZ", 420);

    @Test
    public void findAllTest() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        AirTicketData[] expected = {ticket6, ticket1, ticket3,ticket4};
        AirTicketData[] actual = manager.findAll("DME", "OGZ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notFindAllTest() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        AirTicketData[] expected = {};
        AirTicketData[] actual = manager.findAll("LED", "OGZ");

        Assertions.assertArrayEquals(expected, actual);
    }

}
