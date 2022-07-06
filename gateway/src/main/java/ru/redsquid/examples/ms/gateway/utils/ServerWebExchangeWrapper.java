package ru.redsquid.examples.ms.gateway.utils;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

public class ServerWebExchangeWrapper {

    public static final String CORRELATION_ID = "traceId";

    private final ServerWebExchange exchange;

    private ServerWebExchangeWrapper(ServerWebExchange exchange) {
        this.exchange = exchange;
    }

    public static ServerWebExchangeWrapper wrap(ServerWebExchange exchange) {
        return new ServerWebExchangeWrapper(exchange);
    }

    public String getCorrelationId() {
        List<String> ids = exchange.getRequest().getHeaders().get(CORRELATION_ID);
        return ids == null ? null : ids.stream().findFirst().orElse(null);
    }

    public boolean hasCorrelationId() {
        String correlationId = getCorrelationId();
        return correlationId != null && !correlationId.isBlank();
    }

    public ServerWebExchange addCorrelationIdToRequest(String correlationId) {
        ServerHttpRequest request = exchange.getRequest().mutate().header(CORRELATION_ID, correlationId).build();
        return exchange.mutate().request(request).build();
    }

    public ServerWebExchange addCorrelationIdToResponse(String correlationId) {
        exchange.getResponse().getHeaders().add(CORRELATION_ID, correlationId);
        return exchange;
    }
}
