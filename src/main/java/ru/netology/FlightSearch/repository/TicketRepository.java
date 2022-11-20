package ru.netology.FlightSearch.repository;

import ru.netology.FlightSearch.domain.AirTicketData;

public class TicketRepository {

    private AirTicketData[] tickets = new AirTicketData[0];

    public AirTicketData[] findAll() {
        return tickets;
    }

    public void save(AirTicketData ticket) {
        if (findById(ticket.getId()) != null) {
            throw new AlreadyExistsException(
                    "Element with id: " + ticket.getId() + " already exists."
            );
        }
        AirTicketData[] tmp = new AirTicketData[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found."
            );
        }
        AirTicketData[] tmp = new AirTicketData[tickets.length - 1];
        int copyToIndex = 0;
        for (AirTicketData ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }

    public AirTicketData findById(int id) {
        for (AirTicketData ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

}
