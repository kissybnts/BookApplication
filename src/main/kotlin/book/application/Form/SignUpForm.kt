package book.application.Form

import book.application.domain.AuthorityRole
import book.application.domain.AuthorityUser
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * .
 */
class SignUpForm() {
    @NotNull
    lateinit var loginId: String

    @NotNull
    @Size(min = 8)
    lateinit var password: String

    @NotNull
    @Size(min = 8)
    lateinit private var againPassword: String

    private val encoder = BCryptPasswordEncoder()

    constructor(loginId: String, password: String, againPassword: String): this(){
        this.loginId = loginId
        this.password = password
        this.againPassword = againPassword
    }

    fun toAuthorityUser(): AuthorityUser {
        return AuthorityUser(loginId = loginId, password = encoder.encode(password), enabled = 1, roles = mutableListOf(AuthorityRole(1, "USER")))
    }
}