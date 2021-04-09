/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.gatewayservice.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * <p>
 * Created by xiaofeng.he on 2021/04/09
 *
 * @author xiaofeng.he
 */
@Component
public class LoggerFilter implements GlobalFilter, Ordered {

    private static final Log log = LogFactory.getLog(LoggerFilter.class);
    private static final String REQUEST_TIME_BEGIN = "requestTimeBegin";

    @Autowired
    private Tracer tracer;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        tracer.currentSpan().tag("operator", "joden");
        log.debug("traceid: "+ tracer.currentSpan().context().traceId());
        exchange.getAttributes().put(REQUEST_TIME_BEGIN, System.currentTimeMillis());
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    Long startTime = exchange.getAttribute(REQUEST_TIME_BEGIN);
                    if (startTime != null) {
                        log.info(exchange.getRequest().getURI().getRawPath() + ": " + (System.currentTimeMillis() - startTime) + "ms");
                    }
                })
        );
    }

    @Override
    public int getOrder() {
        return 900;
    }
}
