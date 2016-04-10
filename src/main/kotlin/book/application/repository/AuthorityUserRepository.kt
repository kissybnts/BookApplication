package book.application.repository

import book.application.domain.AuthorityUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * .
 */
@Repository
interface AuthorityUserRepository : JpaRepository<AuthorityUser, Long> {
    fun findByLoginId(loginid: String): AuthorityUser?
}