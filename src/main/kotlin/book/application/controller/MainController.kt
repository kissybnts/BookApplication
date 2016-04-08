package book.application.controller

import book.application.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

/**
 * 一覧画面のコントローラ.
 */
@Controller
@RequestMapping("/main")
class MainController @Autowired constructor(private val bookService: BookService) {
    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun main(@PageableDefault(size = 5) pageable: Pageable): ModelAndView {
        return ModelAndView("/main").apply { addObject("page", bookService.findPageBooks(pageable)) }
    }
}
