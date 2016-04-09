package book.application.service

import book.application.BookApplication
import book.application.test.TestDataResources
import org.junit.Assert.*
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import javax.transaction.Transactional
import org.hamcrest.CoreMatchers.`is` as be

@RunWith(SpringJUnit4ClassRunner::class)
@SpringApplicationConfiguration(BookApplication::class)
@WebAppConfiguration
open class BookServiceTest{
    @Rule
    @Autowired
    lateinit var testDataResources: TestDataResources

    @Autowired
    lateinit var bookService: BookService

    @Test
    @Transactional
    fun findAllBookTest() {
        var sutList = bookService.findAllBook()
        var sut = sutList[0]
        assertThat(sutList.size, be(10))
        assertThat(sut.id, be(1L))
        assertThat(sut.title, be("title"))
        assertThat(sut.subTitle, be("subTitle"))
        assertThat(sut.leadingSentence, be("leadingSentence"))
        assertThat(sut.imagePath, be("imagePath"))
        assertThat(sut.url, be("url"))
        assertThat(sut.authors[0].name, be("author"))
        assertThat(sut.likeCount, be(0))
        assertThat(sut.categories[0].name, be("category"))
        assertThat(sut.publisher.name, be("publisher"))
    }

}
