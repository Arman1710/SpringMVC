package epam.news.action;

import epam.news.model.dto.NewsDTO;
import epam.news.model.entity.News;
import epam.news.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private NewsService newsService;

//    @Autowired
//    private NewsConverterImpl newsConverterImpl;
//
//    @Autowired
//    private CommentConverterImpl commentConverterImpl;



    @GetMapping("/")
    public String showAllNews(ModelMap modelMap){
        List<News> newsList = newsService.showAllNews();
        modelMap.addAttribute("newsList", newsList);
        return "index";
    }

    @GetMapping("/selectedNews")
    public String selectedNews (@RequestParam("newsId") int newsId, ModelMap modelMap) {
        System.out.println(newsId);
//        NewsDTO newsDTO = newsService.selectedNews(newsId);
        return "index6";
    }

    @GetMapping("/addNewsPage")
    public String addNewsPage () {
        return "addNews";
    }

    @GetMapping("/addNews")
    public String addNews (@ModelAttribute("news") NewsDTO newsDTO) {

        newsService.addNews(newsDTO);
        return "addNews";
    }



//    public ActionForward deleteNews(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        NewsForm newsForm = (NewsForm) form;
//        if (newsForm.getCheckboxValue() != null) {
//            for (String checkboxValue : newsForm.getCheckboxValue()) {
//                newsService.deleteNews(Integer.parseInt(checkboxValue));
//            }
//        }
//        return mapping.findForward("success");
//    }
//
//    public ActionForward deleteComment(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        NewsForm newsForm = (NewsForm) form;
//        int newsId = Integer.parseInt(request.getParameter("newsId"));
//
//        if (newsForm.getCheckboxValue() != null) {
//            for (String checkboxValue : newsForm.getCheckboxValue()) {
//                newsService.deleteComment(newsId, Integer.parseInt(checkboxValue));
//            }
//        }
//        return mapping.findForward("success");
//    }
//
//    public ActionForward addComment(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        CommentForm commentForm = (CommentForm) form;
//        int newsId = Integer.parseInt(request.getParameter("newsId"));
//
//        commentForm.setDateCreated(new Date());
//        commentForm.setNewsId(newsId);
//        newsService.createComment(newsId, commentConverterImpl.formToDTO(commentForm));
//
//        return mapping.findForward("success");
//    }
//
//
//    public ActionForward moveToEditPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        int newsId = Integer.parseInt(request.getParameter("newsId"));
//        NewsForm newsForm = (NewsForm) form;
//
//        newsConverterImpl.DTOToForm(newsService.selectedNews(newsId), newsForm);
//
//        return mapping.findForward("success");
//    }
//
//    public ActionForward editNews(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        NewsForm newsForm = (NewsForm) form;
//        String newsId = request.getParameter("newsId");
//
//        NewsDTO newsDTO = newsConverterImpl.formToDTO(newsForm);
//        newsService.editNews(newsDTO, newsId);
//
//        return mapping.findForward("success");
//    }
//
//    public ActionForward addNews(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        NewsForm newsForm = (NewsForm) form;
//
//        NewsDTO newsDTO = newsConverterImpl.formToDTO(newsForm);
//        newsService.addNews(newsDTO);
//
//        return mapping.findForward("success");
//    }


