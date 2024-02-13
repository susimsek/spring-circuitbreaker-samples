package io.github.susimsek.springkafkasamples

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class SpringCircuitBreakerSamplesApplication

fun main(args: Array<String>) {
    runApplication<SpringCircuitBreakerSamplesApplication>(*args)
}