package ru.netology.FlightSearch.repository;

import ru.netology.FlightSearch.domain.AirTicketData;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {

    private TicketRepository ticketList;

    public TicketManager(TicketRepository ticketList) {
        this.ticketList = ticketList;
    }

    public AirTicketData[] findAll(String from, String to, Comparator<AirTicketData> comparator) {
        AirTicketData[] result = new AirTicketData[0];
        for (AirTicketData ticket : ticketList.findAll()) {
            if (matches(ticket, from, to)) {
                AirTicketData[] tmp = new AirTicketData[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
                //Arrays.sort(result, comparator); вынесено из цикла
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }

    public boolean matches(AirTicketData ticket, String from, String to) {
        if (ticket.getDepartureAirport().contains(from) & ticket.getArrivalAirport().contains(to)) {
            return true;
        } else {
            return false;
        }
    }

    public void add(AirTicketData ticket) {
        ticketList.save(ticket);
    }

}
