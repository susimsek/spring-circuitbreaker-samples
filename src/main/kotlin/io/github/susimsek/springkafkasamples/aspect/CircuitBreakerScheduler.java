package io.github.susimsek.springkafkasamples.aspect;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CircuitBreakerScheduler {

    private final CircuitBreakerRegistry circuitBreakerRegistry;

    @Scheduled(fixedRate = 1000 * 60)
    public void refresh() {
        var circuitBreakers = circuitBreakerRegistry.getAllCircuitBreakers();
        var circuitBreakerConfig = CircuitBreakerConfig.custom()
            .slidingWindowSize(10)
            .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
            .failureRateThreshold(100)
            .slowCallRateThreshold(100)
            .minimumNumberOfCalls(5)
            .permittedNumberOfCallsInHalfOpenState(3)
            .automaticTransitionFromOpenToHalfOpenEnabled(true)
            .waitDurationInOpenState(Duration.ofSeconds(60))
            .slowCallDurationThreshold(Duration.ofMillis(3000))
            .build();
        circuitBreakers.forEach(circuitBreaker -> circuitBreakerRegistry.replace(
            circuitBreaker.getName(), CircuitBreaker.of(circuitBreaker.getName(), circuitBreakerConfig)));
    }
}