package com.griesba.brewery.beer.service.config;

import lombok.extern.slf4j.Slf4j;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

@Slf4j
public class CacheEventLoader implements CacheEventListener<Object, Object> {
    @Override
    public void onEvent(CacheEvent<?, ?> cacheEvent) {
      log.debug("/* message  key{}, new val {}, old val {} */", cacheEvent.getKey(), cacheEvent.getNewValue(), cacheEvent.getOldValue());
    }
}
