package ru.netology.FlightSearch.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.FlightSearch.domain.AirTicketData;

public class TicketRepositoryTest {
    //int ID, int price, String DepartureAirport, String ArrivalAirport, int TravelTime
    //Стоимость, для упрощения будем считать стоимость единой для всех продавцов.
    //Аэропорт вылета, вы можете использовать IATA-коды.
    //Аэропорт прилёта, вы можете использовать IATA-коды.
    //Время в пути в минутах.
    AirTicketData ticket1 = new AirTicketData(1, 6000, "DME", "EGO", 120);
    AirTicketData ticket2 = new AirTicketData(2, 2000, "DME", "LED", 180);
    AirTicketData ticket3 = new AirTicketData(3, 5000, "DME", "OGZ", 60);
    AirTicketData ticket4 = new AirTicketData(4, 4000, "DME", "GOJ", 240);
    AirTicketData ticket5 = new AirTicketData(5, 3000, "DME", "FRU", 360);
    AirTicketData ticket6 = new AirTicketData(6, 1000, "DME", "RVH", 420);

    TicketRepository tickets = new TicketRepository();

    @Test
    public void saveTest() {
        tickets.save(ticket1);
        tickets.save(ticket2);
        tickets.save(ticket3);
        tickets.save(ticket4);
        tickets.save(ticket5);
        tickets.save(ticket6);

        AirTicketData[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        AirTicketData[] actual = tickets.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notSaveTest() {
        tickets.save(ticket1);
        tickets.save(ticket2);
        tickets.save(ticket3);
        tickets.save(ticket4);
        tickets.save(ticket5);
        tickets.save(ticket6);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            tickets.save(ticket4);
        });
    }

    @Test
    public void removeByIdTest() {
        tickets.save(ticket1);
        tickets.save(ticket2);
        tickets.save(ticket3);
        tickets.save(ticket4);
        tickets.save(ticket5);
        tickets.save(ticket6);
        tickets.removeById(2);

        AirTicketData[] expected = {ticket1, ticket3, ticket4, ticket5, ticket6};
        AirTicketData[] actual = tickets.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notRemoveByIdTest() {
        tickets.save(ticket1);
        tickets.save(ticket2);
        tickets.save(ticket3);
        tickets.save(ticket4);
        tickets.save(ticket5);
        tickets.save(ticket6);

        Assertions.assertThrows(NotFoundException.class, () -> {
            tickets.removeById(7);
        });
    }

}
