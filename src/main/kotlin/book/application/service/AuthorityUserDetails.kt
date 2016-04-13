package book.application.service

import book.application.domain.AuthorityUser
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

/**
 * Spring Securityの認証ユーザクラス.
 */
class AuthorityUserDetails(private val id: Long?,
                           private val loginId: String,
                           private val password: String,
                           private val authorities: Collection<GrantedAuthority>) : UserDetails {
    companion object{
        fun create(authorityUser: AuthorityUser): AuthorityUserDetails {
            return AuthorityUserDetails(authorityUser.id, authorityUser.loginId, authorityUser.password, authorityUser.roles.map { SimpleGrantedAuthority(it.name) })
        }
    }

    override fun getUsername(): String? = loginId
    override fun getPassword(): String? = password
    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? = authorities.toMutableList()
    override fun isEnabled(): Boolean = true
    override fun isAccountNonExpired(): Boolean = true
    override fun isAccountNonLocked(): Boolean = true
    override fun isCredentialsNonExpired(): Boolean = true
    fun getId(): Long? = id
}
