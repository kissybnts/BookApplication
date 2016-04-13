package book.application.service

import book.application.repository.AuthorityUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * .
 */
@Service
class AuthorityUserDetailsService() : UserDetailsService {
    @Autowired
    lateinit private var repository: AuthorityUserRepository

    override fun loadUserByUsername(loginId: String?): UserDetails? {
        loginId?: throw UsernameNotFoundException("login id is null")
        return repository.findByLoginId(loginId)?.let { AuthorityUserDetails.create(it) }?: throw UsernameNotFoundException("account not found. login id is $loginId")
    }
}