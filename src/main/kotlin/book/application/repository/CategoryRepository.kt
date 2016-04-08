package book.application.repository

import book.application.domain.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * categoryテーブルのRepository.
 */
@Repository
interface CategoryRepository : JpaRepository<Category, Long>{
}