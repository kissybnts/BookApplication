package book.application.repository

import book.application.domain.Publisher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * publisherテーブルのRepository.
 */
@Repository
interface PublisherRepository : JpaRepository<Publisher, Long> {
}