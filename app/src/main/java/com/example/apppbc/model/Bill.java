package com.example.apppbc.model;

import java.time.LocalDateTime;
import java.util.List;

public class Bill {
    private Long id;
    private LocalDateTime payDateTime;
    private double totalAmount;
    private User user;
    private List<Ticket> ticketList;
    public Bill(Long id, LocalDateTime payDateTime, double totalAmount, User user,List<Ticket> ticketList) {
        this.id = id;
        this.payDateTime = payDateTime;
        this.totalAmount = totalAmount;
        this.user = user;
        this.ticketList = ticketList;
    }
    public Bill(Long id, LocalDateTime payDateTime, double totalAmount) {
        this.id = id;
        this.payDateTime = payDateTime;
        this.totalAmount = totalAmount;

    }
    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", payDateTime=" + payDateTime +
                ", totalAmount=" + totalAmount +
                ", user=" + user +
                ", ticketList=" + ticketList +
                '}';
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getPayDateTime() {
        return payDateTime;
    }

    public void setPayDateTime(LocalDateTime payDateTime) {
        this.payDateTime = payDateTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
