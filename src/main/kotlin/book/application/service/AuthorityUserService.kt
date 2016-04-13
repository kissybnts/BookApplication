package book.application.service

import book.application.domain.AuthorityUser
import book.application.repository.AuthorityUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

/**
 * authority_userテーブルのサービスクラス.
 */
@Service
class AuthorityUserService @Autowired constructor(private val repository: AuthorityUserRepository) {

    fun findAll(page: Pageable): Page<AuthorityUser> = repository.findAll(page)
}