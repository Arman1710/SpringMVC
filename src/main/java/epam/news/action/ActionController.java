package epam.news.action;

import epam.news.Validator.CommentsValidator;
import epam.news.Validator.NewsValidator;
import epam.news.Validator.UserValidator;
import epam.news.model.dto.CommentDTO;
import epam.news.model.dto.NewsDTO;
import epam.news.model.dto.UserDTO;
import epam.news.model.entity.News;
import epam.news.model.entity.User;
import epam.news.services.NewsService;
import epam.news.services.SecurityService;
import epam.news.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ActionController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private NewsValidator newsValidator;

    @Autowired
    private CommentsValidator commentsValidator;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/")
    public String welcome() {
        return "login";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout, Model model) {
            model.addAttribute("error", error != null);
            model.addAttribute("logout", logout != null);
        return "login";
    }

    @GetMapping("/registrationPage")
    public String registration(ModelMap modelMap) {
     modelMap.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult) {
        userValidator.validate(userDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.createUser(userDTO);
        securityService.autoLogin(userDTO.getUsername(), userDTO.getConfirmPassword());
        return "main";
    }


    @RequestMapping(value = "/main", method = {RequestMethod.GET, RequestMethod.POST})
    public String showAllNews(ModelMap modelMap) {
        List<News> newsList = newsService.showAllNews();
        modelMap.addAttribute("newsList", newsList);
        return "main";
    }

    @GetMapping("/selectedNews")
    public String selectedNews(@RequestParam("newsId") Long newsId, ModelMap modelMap) {
        NewsDTO newsDTO = newsService.selectedNews(newsId);

        modelMap.addAttribute("comment", new CommentDTO());
        modelMap.addAttribute("news", newsDTO);
        return "selectedNews";
    }

    @GetMapping("/admin/addNewsPage")
    public String addNewsPage(ModelMap modelMap) {
        modelMap.addAttribute("news", new News());
        return "addNews";
    }

    @GetMapping("/admin/addNews")
    public String addNews(@ModelAttribute("news") NewsDTO newsDTO, BindingResult bindingResult) {
        newsValidator.validate(newsDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "addNews";
        }
        newsService.addNews(newsDTO);
        return "redirect:/main";
    }

    @GetMapping("/admin/editNewsPage")
    public ModelAndView editNewsPage(@RequestParam("newsId") Long newsId) {
        return new ModelAndView("editNews", "news", newsService.selectedNews(newsId));
    }

    @PostMapping("/admin/editNews")
    public String editNews(@ModelAttribute("news") NewsDTO newsDTO, BindingResult bindingResult) {
        newsValidator.validate(newsDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "editNews";
        }
        Long newsId = newsDTO.getNewsId();
        newsService.editNews(newsDTO, newsId);
        return "redirect:/selectedNews?newsId=" + newsId;
    }

    @PostMapping("/addComment/{newsId}")
    public String addComment(@PathVariable(value = "newsId") Long newsId, @ModelAttribute("comment") CommentDTO commentDTO, BindingResult bindingResult) {
        commentsValidator.validate(commentDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "selectedNews";
        }
        newsService.addComment(newsId, commentDTO);
        return "redirect:/selectedNews?newsId=" + newsId;
    }

    @GetMapping("/admin/deleteNews")
    public String deleteNews(@RequestParam(required = false, name = "checkedNews") String[] checkedNews) {
        if (checkedNews != null) {
            for (String checkboxValue : checkedNews) {
                newsService.deleteNews(Long.valueOf(checkboxValue));
            }
        }
        return "redirect:/main";
    }

    @GetMapping("/admin/deleteComment/{newsId}")
    public String deleteComment(@RequestParam(required = false, name = "checkedComments") String[] checkedComments,
                                @PathVariable(value = "newsId") Long newsId) {
        System.out.println("newsIDDDDDDDDD      " + newsId);
        if (checkedComments != null) {
            for (String checkboxValue : checkedComments) {
                newsService.deleteComment(newsId, Long.valueOf(checkboxValue));
            }
        }
        return "redirect:/selectedNews?newsId=" + newsId;
    }


}
