package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Todo;
import ra.model.service.ITodoService;
import ra.model.service.impl.TodoService;

@Controller
public class TodoController {
    @Autowired
    private ITodoService todoService;
    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("t", new Todo());
        model.addAttribute("list", todoService.findAll());
        return "list";
    }
    @GetMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("add","todo", new Todo());
    }
    @GetMapping("/edit/{id}")
    public ModelAndView findById(@PathVariable Long id){
        return new ModelAndView("edit","todo", todoService.findById(id));
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        todoService.delete(id);
        return "redirect:/";
    }
    @PostMapping("/add")
    public String doAdd(@ModelAttribute Todo todo){
        todoService.save(todo);
        return "redirect:/";
    }
    @PostMapping("/update")
    public String doUpdate(@ModelAttribute Todo todo){
        todoService.save(todo);
        return "redirect:/";
    }
}
