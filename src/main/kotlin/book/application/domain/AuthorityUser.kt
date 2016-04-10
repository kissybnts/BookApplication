package book.application.domain

import javax.persistence.*

/**
 * .
 */
@Entity
@Table(name = "authority_user")
class AuthorityUser() {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Column
    lateinit var loginId: String

    @Column
    lateinit var password: String

    @Column
    var enabled: Int = 1

    @ManyToMany
    @JoinTable(name = "authority_user_role", joinColumns = arrayOf(JoinColumn(name = "user_id")), inverseJoinColumns = arrayOf(JoinColumn(name = "role_id")))
    lateinit var roles: MutableList<AuthorityRole>

    constructor(id: Long? = null, loginId: String, password: String, enabled: Int = 1, roles: MutableList<AuthorityRole> = mutableListOf()): this(){
        this.id = id
        this.loginId = loginId
        this.password = password
        this.enabled = enabled
        this.roles = roles
    }
}