package com.griesba.brewery.beer.griesbabeerservice.web;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Data
public class BeerDto implements Serializable {
    private static final long serialVersionUID = -6808953121505951649L;

    private String id;
    private String name;
    private String style;
    private String upc;
    private double price;
    private Integer quantityToBrew;
    private Integer minOnHand;
    private Timestamp createdDate;
}
