package com.ggl.web.admin;

import com.ggl.domain.Tag;
import com.ggl.domain.Type;
import com.ggl.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping("/tags")
    public String tags(@PageableDefault(size = 3,sort = "id",direction = Sort.Direction.DESC) Pageable pageable,
                       Model model){
        model.addAttribute("tagPage",tagService.listTag(pageable));
        return "admin/tags";
    }


    @GetMapping("/tags/input")
    public String input(Model model){
        model.addAttribute("tag",new Tag());
        return "admin/tags-input";
    }

    @GetMapping("/tags/{id}/input")
    public String editInput(@PathVariable Long id,
                            Model model){
        model.addAttribute("tag",tagService.getTags(id));
        return "admin/tags-input";
    }

    @PostMapping("/tags")
    public String post(@Valid Tag tag, BindingResult result, RedirectAttributes attributes){
        Tag tag1 = tagService.getTagByName(tag.getName());
        if (tag1 != null){
            result.rejectValue("name","nameError","不能添加重名标签");
        }
        if (result.hasErrors()){
            return "admin/tags-input";
        }
        Tag tag2 = tagService.saveTag(tag);
        if (tag2 != null){
            attributes.addFlashAttribute("message","标签新增成功");
        }else {
            attributes.addFlashAttribute("message","标签新增失败");
        }
        return "redirect:/admin/tags";
    }

    @PostMapping("/tags/{id}")
    public String post(@Valid Tag tag,
                       BindingResult result,
                       @PathVariable Long id,
                       RedirectAttributes attributes){

        Tag tag1 = tagService.getTagByName(tag.getName());
        if (tag1 != null){
            result.rejectValue("name","nameError","不能添加重名标签");
        }
        if (result.hasErrors()){
            return "admin/tags-input";
        }
        Tag tag2 = tagService.updateTag(id, tag);
        if (tag2 != null){
            attributes.addFlashAttribute("message","标签更新成功");
        }else {
            attributes.addFlashAttribute("message","标签更新失败");
        }
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id,
                         RedirectAttributes attributes){
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/tags";
    }
}
