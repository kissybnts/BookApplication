package book.application.domain

import javax.persistence.*

/**
 * authorテーブルのEntity.
 */
@Entity
@Table(name = "author")
class Author() : LikeTarget() {
    @Id
    @GeneratedValue
    var id: Long? = null

    /**
     * 著者名.
     */
    @Column(nullable = false)
    lateinit var name: String

    /**
     * 執筆した書籍リスト.
     */
    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = arrayOf(JoinColumn(name = "author_id")), inverseJoinColumns = arrayOf(JoinColumn(name = "book_id")))
    lateinit var books: MutableList<Book>

    /**
     * セカンダリコンストラクタ.
     * @param id 主キー
     * @param name 著者名
     * @param likeCount いいね数
     * @param books 執筆した本リスト
     */
    constructor(id: Long? = null, name: String, likeCount: Int = 0, books: MutableList<Book> = mutableListOf()): this(){
        this.id = id
        this.name = name
        this.likeCount = likeCount
        this.books = books
    }
}