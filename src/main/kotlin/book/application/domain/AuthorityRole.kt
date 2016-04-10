package book.application.domain

import javax.persistence.*

/**
 * .
 */
@Entity
@Table(name = "authority_role")
class AuthorityRole() {
    @Id
    @GeneratedValue
    var id: Int? = null
        private set

    @Column
    lateinit var name: String
        private set

    constructor(id: Int? = null, name: String): this(){
        this.id = id
        this.name = name
    }
}