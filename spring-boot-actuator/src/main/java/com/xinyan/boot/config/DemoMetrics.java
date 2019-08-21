package com.xinyan.boot.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import io.micrometer.core.lang.NonNull;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 孟星魂
 * @version 5.0 createTime: 2019/8/20
 */
public class DemoMetrics implements MeterBinder {
    AtomicInteger count = new AtomicInteger(0);

    @Override
    public void bindTo(@NonNull MeterRegistry registry) {
        gauge(registry);

    }

    private void gauge(MeterRegistry registry){
        Gauge.builder("demo.count", count, c -> c.incrementAndGet())
                .tags("host", "localhost")
                .description("demo of custom meter binder")
                .register(registry);
    }
    private void counter(MeterRegistry registry){
        Counter counter = Counter.builder("counter")
                .tag("counter", "counter")
                .description("counter")
                .register(registry);
        counter.increment(2D);
    }

}
