package com.cognizant.demo.EmployeeDemo;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

@Component
public class CORSFilter implements WebFilter {
    @Override
    public reactor.core.publisher.Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        //exchange.getResponse().getHeaders().set("Access-Control-Allow-Methods","POST");
        exchange.getResponse().getHeaders().set("Access-Control-Allow-Origin","");
        return chain.filter(exchange);
    }
}
