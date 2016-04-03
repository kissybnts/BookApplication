package book.application.domain

import javax.persistence.Column

/**
 * いいね対象の抽象エンティティクラス.
 */
abstract class LikeTarget {
    /**
     * いいね数を保持するカラム
     */
    @Column(nullable = false)
    var likeCount: Int = 0
        private set

    /**
     * いいね数をインクリメントする.
     * @return 処理後のいいね数
     */
    fun likeUp(): Int = likeCount++

    /**
     * いいね数をデクリメントする.
     * @return 処理後のいいね数
     */
    fun likeDown(): Int = if(likeCount === 0){ 0 } else { likeCount-- }
}