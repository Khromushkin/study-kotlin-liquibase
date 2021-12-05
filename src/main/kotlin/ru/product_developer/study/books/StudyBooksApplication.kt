package ru.product_developer.study.books

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties

@SpringBootApplication
class StudyBooksApplication

fun main(args: Array<String>) {
    SpringApplication
            .run(StudyBooksApplication::class.java, *args)
}