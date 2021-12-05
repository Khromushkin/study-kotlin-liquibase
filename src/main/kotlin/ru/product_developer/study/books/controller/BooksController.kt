package ru.product_developer.study.books.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.product_developer.study.books.controller.dto.BookDto
import ru.product_developer.study.books.dao.BooksDao
import ru.product_developer.study.books.dao.models.BookModel

@RestController()
@RequestMapping("books")
class BooksController @Autowired constructor(private val booksDao: BooksDao) {
    @GetMapping("/{uid}", produces = ["application/json"])
    fun getBook(@PathVariable uid: String): BookDto {
        return booksDao.getBookByUid(uid).toBookDto()
    }

    @PutMapping("", produces = ["application/json"])
    fun saveBook(@RequestParam name: String, @RequestParam author: String,): BookDto {
        return booksDao.saveBook(name, author).toBookDto()
    }
}

fun BookModel.toBookDto(): BookDto {
    return BookDto(this.uid, this.name, this.author)
}