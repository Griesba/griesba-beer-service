
package com.griesba.brewery.model.events;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.griesba.brewery.model.BeerDto;

/**
 * this is generated automatically by jsonschama2pojo maven plugin
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "beerDto"
})
public class BeerEvent {

    @JsonProperty("beerDto")
    private BeerDto beerDto;

    @JsonProperty("beerDto")
    public BeerDto getBeerDto() {
        return beerDto;
    }

    @JsonProperty("beerDto")
    public void setBeerDto(BeerDto beerDto) {
        this.beerDto = beerDto;
    }

    public static class BeerEventBuilder<T extends BeerEvent >{

        protected T instance;

        @SuppressWarnings("unchecked")
        public BeerEventBuilder() {
            // Skip initialization when called from subclass
            if (this.getClass().equals(BeerEvent.BeerEventBuilder.class)) {
                this.instance = ((T) new BeerEvent());
            }
        }

        public T build() {
            T result;
            result = this.instance;
            this.instance = null;
            return result;
        }

        public BeerEvent.BeerEventBuilder withBeerDto(BeerDto beerDto) {
            ((BeerEvent) this.instance).beerDto = beerDto;
            return this;
        }

    }

}
