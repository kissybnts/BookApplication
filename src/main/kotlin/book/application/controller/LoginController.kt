package book.application.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

/**
 * .
 */
@Controller
class LoginController {
    @RequestMapping("/login")
    fun loginPage(): ModelAndView {
        return ModelAndView("/login")
    }
}