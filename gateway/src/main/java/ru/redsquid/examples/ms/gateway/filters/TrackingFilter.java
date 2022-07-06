package ru.redsquid.examples.ms.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import ru.redsquid.examples.ms.gateway.utils.ServerWebExchangeWrapper;

import java.util.UUID;

@Component
public class TrackingFilter implements GlobalFilter {

    private static final Logger log = LoggerFactory.getLogger(TrackingFilter.class);

    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.trace("filter");
        ServerWebExchangeWrapper wrapper = ServerWebExchangeWrapper.wrap(exchange);
        if (wrapper.hasCorrelationId()) {
            System.out.println("Correlation ID: " + wrapper.getCorrelationId());
            return chain.filter(exchange);
        }
        UUID correlationId = UUID.randomUUID();
        System.out.println("Correlation ID has been generated: " + correlationId);
        return chain.filter(wrapper.addCorrelationIdToRequest(correlationId.toString()));
    }
}
