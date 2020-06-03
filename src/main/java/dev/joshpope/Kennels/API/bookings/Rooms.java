package dev.joshpope.Kennels.API.bookings;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
@EntityListeners(AuditingEntityListener.class)
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;
}

