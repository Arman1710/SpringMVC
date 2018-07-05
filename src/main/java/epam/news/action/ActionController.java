package epam.news.action;

import epam.news.model.dto.CommentDTO;
import epam.news.model.dto.NewsDTO;
import epam.news.model.dto.UserDTO;
import epam.news.model.entity.News;
import epam.news.model.entity.User;
import epam.news.services.NewsService;
import epam.news.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ActionController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private UserService userService;

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
        return userService.createUser(userDTO, bindingResult);
    }


    @RequestMapping(value = "/main", method = {RequestMethod.GET, RequestMethod.POST})
    public String showAllNews(ModelMap modelMap) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        List<News> newsList = newsService.showAllNews();
        modelMap.addAttribute("newsList", newsList);
//        modelMap.addAttribute("username", user.getUsername());
        return "main";
    }

    @GetMapping("/selectedNews")
    public String selectedNews(@RequestParam("newsId") Long newsId, ModelMap modelMap) {
        NewsDTO newsDTO = newsService.selectedNews(newsId);
        CommentDTO commentDTO = new CommentDTO();
        modelMap.addAttribute("comment", commentDTO);
        modelMap.addAttribute("news", newsDTO);
        return "selectedNews";
    }

    @GetMapping("/addNewsPage")
    public String addNewsPage() {
        return "addNews";
    }

    @GetMapping("/addNews")
    public String addNews(@ModelAttribute("news") NewsDTO newsDTO) {
        newsService.addNews(newsDTO);
        return "redirect:/";
    }

    @GetMapping("/editNewsPage")
    public ModelAndView editNewsPage(@RequestParam("newsId") Long newsId) {
        return new ModelAndView("editNews", "news", newsService.selectedNews(newsId));
    }

    @PostMapping("/editNews")
    public String editNews(@ModelAttribute("news") NewsDTO newsDTO) {
        Long newsId = newsDTO.getNewsId();
        newsService.editNews(newsDTO, newsId);
        return "redirect:/selectedNews?newsId=" + newsId;
    }

    @PostMapping("/addComment/{newsId}")
    public String addComment(@PathVariable(value = "newsId") Long newsId, @ModelAttribute("comment") CommentDTO commentDTO) {
        newsService.addComment(newsId, commentDTO);
        return "redirect:/selectedNews?newsId=" + newsId;
    }

    @GetMapping("/deleteNews")
    public String deleteNews(@RequestParam(required = false, name = "checkedNews") String[] checkedNews) {
        if (checkedNews != null) {
            for (String checkboxValue : checkedNews) {
                newsService.deleteNews(Long.valueOf(checkboxValue));
            }
        }
        return "redirect:/";
    }

    @GetMapping("/deleteComment/{newsId}")
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
