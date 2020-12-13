
package com.griesba.brewery.model;

import java.time.OffsetDateTime;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * this is generated automatically by jsonschama2pojo maven plugin
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "version",
    "style",
    "upc",
    "price",
    "quantityToBrew",
    "quantityOnHand",
    "minOnHand",
    "createdDate",
    "modificationDate"
})
public class BeerDto {

    @JsonProperty("id")
    private UUID id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("version")
    private Long version;
    @JsonProperty("style")
    private String style;
    @JsonProperty("upc")
    private String upc;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("quantityToBrew")
    private Integer quantityToBrew;
    @JsonProperty("quantityOnHand")
    private Integer quantityOnHand;
    @JsonProperty("minOnHand")
    private Integer minOnHand;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    @JsonProperty("createdDate")
    private OffsetDateTime createdDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    @JsonProperty("modificationDate")
    private OffsetDateTime modificationDate;

    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(UUID id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("version")
    public Long getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Long version) {
        this.version = version;
    }

    @JsonProperty("style")
    public String getStyle() {
        return style;
    }

    @JsonProperty("style")
    public void setStyle(String style) {
        this.style = style;
    }

    @JsonProperty("upc")
    public String getUpc() {
        return upc;
    }

    @JsonProperty("upc")
    public void setUpc(String upc) {
        this.upc = upc;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("quantityToBrew")
    public Integer getQuantityToBrew() {
        return quantityToBrew;
    }

    @JsonProperty("quantityToBrew")
    public void setQuantityToBrew(Integer quantityToBrew) {
        this.quantityToBrew = quantityToBrew;
    }

    @JsonProperty("quantityOnHand")
    public Integer getQuantityOnHand() {
        return quantityOnHand;
    }

    @JsonProperty("quantityOnHand")
    public void setQuantityOnHand(Integer quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    @JsonProperty("minOnHand")
    public Integer getMinOnHand() {
        return minOnHand;
    }

    @JsonProperty("minOnHand")
    public void setMinOnHand(Integer minOnHand) {
        this.minOnHand = minOnHand;
    }

    @JsonProperty("createdDate")
    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("createdDate")
    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("modificationDate")
    public OffsetDateTime getModificationDate() {
        return modificationDate;
    }

    @JsonProperty("modificationDate")
    public void setModificationDate(OffsetDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    public static class BeerDtoBuilder<T extends BeerDto >{

        protected T instance;

        @SuppressWarnings("unchecked")
        public BeerDtoBuilder() {
            // Skip initialization when called from subclass
            if (this.getClass().equals(BeerDto.BeerDtoBuilder.class)) {
                this.instance = ((T) new BeerDto());
            }
        }

        public T build() {
            T result;
            result = this.instance;
            this.instance = null;
            return result;
        }

        public BeerDto.BeerDtoBuilder withId(UUID id) {
            ((BeerDto) this.instance).id = id;
            return this;
        }

        public BeerDto.BeerDtoBuilder withName(String name) {
            ((BeerDto) this.instance).name = name;
            return this;
        }

        public BeerDto.BeerDtoBuilder withVersion(Long version) {
            ((BeerDto) this.instance).version = version;
            return this;
        }

        public BeerDto.BeerDtoBuilder withStyle(String style) {
            ((BeerDto) this.instance).style = style;
            return this;
        }

        public BeerDto.BeerDtoBuilder withUpc(String upc) {
            ((BeerDto) this.instance).upc = upc;
            return this;
        }

        public BeerDto.BeerDtoBuilder withPrice(Double price) {
            ((BeerDto) this.instance).price = price;
            return this;
        }

        public BeerDto.BeerDtoBuilder withQuantityToBrew(Integer quantityToBrew) {
            ((BeerDto) this.instance).quantityToBrew = quantityToBrew;
            return this;
        }

        public BeerDto.BeerDtoBuilder withQuantityOnHand(Integer quantityOnHand) {
            ((BeerDto) this.instance).quantityOnHand = quantityOnHand;
            return this;
        }

        public BeerDto.BeerDtoBuilder withMinOnHand(Integer minOnHand) {
            ((BeerDto) this.instance).minOnHand = minOnHand;
            return this;
        }

        public BeerDto.BeerDtoBuilder withCreatedDate(OffsetDateTime createdDate) {
            ((BeerDto) this.instance).createdDate = createdDate;
            return this;
        }

        public BeerDto.BeerDtoBuilder withModificationDate(OffsetDateTime modificationDate) {
            ((BeerDto) this.instance).modificationDate = modificationDate;
            return this;
        }

    }

}
