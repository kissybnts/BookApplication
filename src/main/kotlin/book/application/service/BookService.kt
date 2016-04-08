package book.application.service

import book.application.domain.Book
import book.application.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

/**
 * DBからのデータ取得と加工を行う.
 */
@Service
class BookService @Autowired constructor(private val bookRepository: BookRepository) {

    /**
     * 全書籍リストの取得.
     * @return 書籍リスト
     */
    fun findAllBook(): MutableList<Book> = bookRepository.findAll()

    /**
     * .
     * @param pageable
     * @return １頁の書籍リスト情報
     */
    fun findPageBooks(pageable: Pageable): Page<Book> = bookRepository.findAll(pageable)
}