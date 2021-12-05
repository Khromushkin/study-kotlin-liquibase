package ru.product_developer.study.books.dao

import ru.product_developer.study.books.dao.models.BookModel

interface BooksDao {
    fun getBookByUid(uid: String): BookModel
    fun saveBook(name: String, author: String): BookModel
}