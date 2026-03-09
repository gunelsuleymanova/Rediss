package com.example.Redis.resdis.configuration;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        mapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);

        RedisSerializer<Object> jsonSerializer = RedisSerializer.json();

        template.setKeySerializer(RedisSerializer.string());
        template.setValueSerializer(jsonSerializer);
        template.setHashKeySerializer(RedisSerializer.string());
        template.setHashValueSerializer(jsonSerializer);

        return template;
    }
}





























//        package com.example.Redis.resdis.configuration;
//
//import com.fasterxml.jackson.annotation.JsonTypeInfo;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//        @Configuration
//        public class RedisConfig {
//
//            @Bean
//            public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
//                RedisTemplate<String, Object> template = new RedisTemplate<>();
//                template.setConnectionFactory(connectionFactory);
//
//                // 1. Düzgün ObjectMapper (com.fasterxml.jackson.databind)
//                ObjectMapper mapper = new ObjectMapper();
//                mapper.registerModule(new JavaTimeModule());
//
//                // Bu hissə mütləqdir: LinkedHashMap xətasını aradan qaldırır
//                mapper.activateDefaultTyping(
//                        LaissezFaireSubTypeValidator.instance,
//                        ObjectMapper.DefaultTyping.NON_FINAL,
//                        JsonTypeInfo.As.PROPERTY
//                );
//
//                // 2. Spring Boot 4+ üçün ən yeni və tövsiyə olunan yol:
//                // RedisSerializer.json() metodu daxildə Jackson2JsonRedisSerializer yaradır
//                // və sizin təyin etdiyiniz mapper-i istifadə edir.
//                RedisSerializer<Object> jsonSerializer = RedisSerializer.json(mapper);
//
//                template.setKeySerializer(RedisSerializer.string()); // StringRedisSerializer-in qısa yolu
//                template.setValueSerializer(jsonSerializer);
//                template.setHashKeySerializer(RedisSerializer.string());
//                template.setHashValueSerializer(jsonSerializer);
//
//                return template;
//            }
//        }
//
//









//package com.example.Redis.resdis.configuration;
//
//import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
////import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.GenericJacksonJsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import tools.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
//
//@Configuration
//@RequiredArgsConstructor
//public class RedisConfig {
//    private final ObjectMapper objectMapper;
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//        template.setKeySerializer(new StringRedisSerializer());
//
//        // Ağıllı serializer: Obyektin tipini də yadda saxlayır
//        ObjectMapper mapper = new ObjectMapper();
//        // Bu sətir LocalDate kimi vaxt tipləri üçün mütləqdir
//        mapper.registeredModules(new JavaTimeModule());
//        // Bu sətir isə tip məlumatını JSON-un içinə gizli sahə kimi əlavə edir
//        mapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
//
//        template.setValueSerializer(new GenericJacksonJsonRedisSerializer(mapper));
//        return template;
//    }
//
//
//
//
//
////    @Bean
////    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
////        RedisTemplate<String, Object> template = new RedisTemplate<>();
////        template.setConnectionFactory(connectionFactory);
////
////        template.setKeySerializer(new StringRedisSerializer());
////        template.setValueSerializer(new GenericJacksonJsonRedisSerializer(new ObjectMapper()));
////
////        return template;
////    }
//
//}
