package ru.redsquid.examples.ms.gateway.filters;

import brave.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;
import ru.redsquid.examples.ms.gateway.utils.ServerWebExchangeWrapper;

@Configuration
public class ResponseFilter {

    private static final Logger log = LoggerFactory.getLogger(ResponseFilter.class);

    @Autowired
    private Tracer tracer;

    @Bean
    public GlobalFilter postGlobalFilter() {

        return ((exchange, chain) -> chain.filter(exchange).then(Mono.fromRunnable(() -> {
            log.trace("postGlobalFilter");
            String traceId = tracer.currentSpan().context().traceIdString();
            if (traceId != null) {
                ServerWebExchangeWrapper.wrap(exchange).addCorrelationIdToResponse(traceId);
            }
        })));
    }
}
