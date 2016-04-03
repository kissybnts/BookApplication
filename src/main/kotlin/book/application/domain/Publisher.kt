package book.application.domain

import javax.persistence.*

/**
 * publisherテーブルのEntity.
 */
@Entity
@Table(name = "publisher")
class Publisher() : LikeTarget() {
    @Id
    @GeneratedValue
    var id: Long? = null
        private set

    @Column(nullable = false)
    lateinit var name: String
        private set

    /**
     * 出版している書籍リスト.
     */
    @OneToMany(mappedBy = "publisher")
    lateinit var books: MutableList<Book>

    /**
     * セカンダリコンストラクタ.
     * @param id 主キー
     * @param name 出版社名
     * @param likeCount いいね数
     * @param books 出版している書籍リスト
     */
    constructor(id: Long? = null, name: String, likeCount: Int = 0, books: MutableList<Book> = mutableListOf()): this(){
        this.id = id
        this.name = name
        this.likeCount = likeCount
        this.books = books
    }
}