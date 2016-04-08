package book.application.repository

import book.application.domain.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * authorテーブルのRepository.
 */
@Repository
interface AuthorRepository : JpaRepository<Author, Long> {
}