package com.griesba.brewery.beer.griesbabeerservice.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class BeerDto implements Serializable {
    private static final long serialVersionUID = -6808953121505951649L;

    private UUID id;
    private String name;
    private String version;
    private String style;
    private String upc;
    private double price;
    private Integer quantityToBrew;
    private Integer minOnHand;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime modificationDate;
}
