package com.josamtechie.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("product")
public class Product implements Serializable
{
    @Id
    private String id;
    @Indexed
    private String name;
    private int quantity;
    private double price;
}
