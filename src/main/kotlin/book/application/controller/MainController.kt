package book.application.controller

import book.application.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

/**
 * 一覧画面のコントローラ.
 */
@Controller
class MainController @Autowired constructor(private val bookService: BookService) {
    @RequestMapping("/main")
    fun main(): ModelAndView = ModelAndView("/main").apply { addObject("books", bookService.findAllBook()) }
}
