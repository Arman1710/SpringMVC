package epam.news.action;

import epam.news.model.dto.CommentDTO;
import epam.news.model.dto.NewsDTO;
import epam.news.model.entity.News;
import epam.news.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private NewsService newsService;

    @GetMapping("/")
    public String showAllNews(ModelMap modelMap) {
        List<News> newsList = newsService.showAllNews();
        modelMap.addAttribute("newsList", newsList);
        return "index";
    }

    @GetMapping("/selectedNews")
    public String selectedNews(@RequestParam("newsId") int newsId, ModelMap modelMap) {
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
    public ModelAndView editNewsPage(@RequestParam("newsId") int newsId) {
        return new ModelAndView("editNews", "news", newsService.selectedNews(newsId));
    }

    @PostMapping("/editNews")
    public String editNews(@ModelAttribute("news") NewsDTO newsDTO) {
        int newsId = newsDTO.getNewsId();
        newsService.editNews(newsDTO, newsId);
        return "redirect:/selectedNews?newsId=" + newsId;
    }

    @PostMapping("/addComment/{newsId}")
    public String addComment(@PathVariable(value = "newsId") int newsId, @ModelAttribute("comment") CommentDTO commentDTO) {
        newsService.addComment(newsId, commentDTO);
        return "redirect:/selectedNews?newsId=" + newsId;
    }

    @GetMapping("/deleteNews")
    public String deleteNews(@RequestParam(required = false, name = "checkedNews") String[] checkedNews) {
        if (checkedNews != null) {
            for (String checkboxValue : checkedNews) {
                System.out.println(checkboxValue);
                newsService.deleteNews(Integer.parseInt(checkboxValue));
            }
        }
        return "redirect:/";
    }

    @GetMapping("/deleteComment/{newsId}")
    public String deleteComment(@RequestParam(required = false, name = "checkedComments") String[] checkedComments,
                                @PathVariable(value = "newsId") int newsId) {
        System.out.println("newsIDDDDDDDDD      " + newsId);
        if (checkedComments != null) {
            for (String checkboxValue : checkedComments) {
                System.out.println(checkboxValue);
                newsService.deleteComment(newsId, Integer.parseInt(checkboxValue));
            }
        }
        return "redirect:/selectedNews?newsId=" + newsId;
    }


}
