package ru.netology.FlightSearch.domain;

public class AirTicketData implements Comparable<AirTicketData> {
    //ID.
    //Стоимость, для упрощения будем считать стоимость единой для всех продавцов.
    //Аэропорт вылета, вы можете использовать IATA-коды.
    //Аэропорт прилёта, вы можете использовать IATA-коды.
    //Время в пути в минутах.
    protected int id;
    protected int price;
    protected String DepartureAirport;
    protected String ArrivalAirport;
    protected int TravelTime;

    public AirTicketData(int id, int price, String departureAirport, String arrivalAirport, int travelTime) {
        this.id = id;
        this.price = price;
        DepartureAirport = departureAirport;
        ArrivalAirport = arrivalAirport;
        TravelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDepartureAirport() {
        return DepartureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        DepartureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return ArrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        ArrivalAirport = arrivalAirport;
    }

    public int getTravelTime() {
        return TravelTime;
    }

    public void setTravelTime(int travelTime) {
        TravelTime = travelTime;
    }

    @Override
    public int compareTo(AirTicketData o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }
}
