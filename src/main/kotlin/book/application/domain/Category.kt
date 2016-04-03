package book.application.domain

import javax.persistence.*

/**
 * categoryテーブルのEntity.
 */
@Entity
@Table(name = "category")
class Category() : LikeTarget() {
    @Id
    @GeneratedValue
    var id: Long? = null
        private set

    /**
     * カテゴリ名.
     */
    @Column(nullable = false)
    lateinit var name: String
        private set

    /**
     * カテゴリに属する書籍リスト.
     */
    @ManyToMany
    @JoinTable(name = "category_book", joinColumns = arrayOf(JoinColumn(name = "category_id")), inverseJoinColumns = arrayOf(JoinColumn(name = "book_id")))
    lateinit var books: MutableList<Book>

    /**
     * セカンダリコンストラクタ
     * @param id 主キー
     * @param name カテゴリ名
     * @param likeCount いいね数
     * @param books カテゴリに属する書籍リスト
     */
    constructor(id: Long? = null, name: String, likeCount: Int, books: MutableList<Book>): this(){
        this.id = id
        this.name = name
        this.likeCount = likeCount
        this.books = books
    }
}