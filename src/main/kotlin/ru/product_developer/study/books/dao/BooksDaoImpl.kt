package ru.product_developer.study.books.dao

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import ru.product_developer.study.books.dao.models.BookModel

@Repository
class BooksDaoImpl(private val jdbcTemplate: JdbcTemplate) : BooksDao {
    private val bookRowMapper: RowMapper<BookModel> = RowMapper { rs, rowNum ->
        BookModel(
                rs.getString("uid"),
                rs.getString("name"),
                rs.getString("author")
        )
    }

    override fun getBookByUid(uid: String): BookModel {
        return jdbcTemplate.queryForObject("select uid, name, author from books where uid = ?::uuid", bookRowMapper, uid)!!
    }

    override fun saveBook(name: String, author: String): BookModel {
        return jdbcTemplate.queryForObject("insert into books(name, author) values (?, ?) returning uid, name, author", bookRowMapper, arrayOf(name, author))
    }
}