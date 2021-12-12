package ru.product_developer.study.books.dao

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@SpringBootTest
internal class BooksDaoImplTest {
    @Autowired
    private lateinit var booksDaoImpl: BooksDaoImpl

    @Test
    fun getBookTest() {
        val book = booksDaoImpl.getBookByUid("8e7e4b0a-6ccd-4dea-b50c-cc4a68596b15")
        assertEquals("dev_book_name1", book.name)
        assertEquals("dev_author_name1", book.author)
    }
}