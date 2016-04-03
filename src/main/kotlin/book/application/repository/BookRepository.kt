package book.application.repository

import book.application.domain.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * bookテーブルのRepository.
 */
@Repository
interface BookRepository : JpaRepository<Book, Long> {
}