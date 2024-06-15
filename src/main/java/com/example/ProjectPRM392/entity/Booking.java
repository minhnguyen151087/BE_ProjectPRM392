package com.example.ProjectPRM392.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Booking",uniqueConstraints = {@UniqueConstraint(columnNames = {"booking_id"})})
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="booking_id")
    private int bookingId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;
    @Column(name="date")
    private Date date;
    @Column(name="room")
    private int room;
    @Column(name="doctor_id")
    private int doctorId;
    

}
