package com.griesba.brewery.beer.service.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
public class Beer {

    @Builder
    public Beer(Long version, String name, String style, String upc, double price, Integer quantityToBrew, Integer quantityOnHand, Integer minOnHand, Timestamp createdDate, Timestamp modificationDate) {
        this.version = version;
        this.name = name;
        this.style = style;
        this.upc = upc;
        this.price = price;
        this.quantityToBrew = quantityToBrew;
        //this.quantityOnHand = quantityOnHand; retrieve from inventory
        this.minOnHand = minOnHand;
        this.createdDate = createdDate;
        this.modificationDate = modificationDate;
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    @Type(type = "uuid-char")
    private UUID id;

    @Version
    private Long version;

    private String name;

    private String style;

    @Column(unique = true)
    private String upc;

    private double price;

    private Integer quantityToBrew;

    //private Integer quantityOnHand; retrieve from inventory service. present only in the DTO

    private Integer minOnHand;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp modificationDate;
}

