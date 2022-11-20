package ru.netology.FlightSearch.repository;

import ru.netology.FlightSearch.domain.AirTicketData;

import java.util.Comparator;

public class TicketByPriceAsComparator implements Comparator<AirTicketData> {
    public int compare(AirTicketData o1, AirTicketData o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
