package by.mkrs.testApp.controller;


import by.mkrs.testApp.dto.Catalog_KindOfActivityDto;
import by.mkrs.testApp.entity.Catalog_KindOfActivity;
import by.mkrs.testApp.service.Catalog_KindOfActivityService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/catalogKindOfActivity")
public class Catalog_KindOfActivityController {

    private final Catalog_KindOfActivityService catalog_kindOfActivityService;

    public Catalog_KindOfActivityController(Catalog_KindOfActivityService catalog_kindOfActivityService) {
        this.catalog_kindOfActivityService = catalog_kindOfActivityService;
    }

    @GetMapping("/page/{pageNumber}")
    public String findPaginated(@PathVariable(value="pageNumber") int pageNumber,
                                Model model,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir){
        int pageSize=5;

        Page<Catalog_KindOfActivity> page = catalog_kindOfActivityService.findPaginated(pageNumber, pageSize, sortField, sortDir);
        List<Catalog_KindOfActivity> catalog_kindOfActivityDtoList=page.getContent();

        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc")?"desc":"asc");
        model.addAttribute("catalog_kindOfActivityDtoList", catalog_kindOfActivityDtoList);
        return "catalog_kindOfActivityList";
    }

    @GetMapping("/listAll")
    public String listKindOfActivity(Model model) {
        return findPaginated(1,model,"titleKindOfActivity","asc");
    }

    @GetMapping("/save")
    public String showCreateEditFormNewKindOfActivity(Model model,
                                                      Catalog_KindOfActivityDto catalog_kindOfActivityDto) {
        model.addAttribute("catalog_kindOfActivityDto", catalog_kindOfActivityDto);
        return "catalog_kindOfActivityAddEdit";
    }

    @PostMapping("/save")
    public String saveKindOfActivity(@ModelAttribute("catalog_kindOfActivity")
                                     @Valid Catalog_KindOfActivityDto catalog_kindOfActivityDto,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "catalog_kindOfActivityAddEdit";
        }
        catalog_kindOfActivityService.addNew(catalog_kindOfActivityDto);
        return "redirect:/catalogKindOfActivity/listAll";
    }

    @GetMapping("/edit/{id}")
    public String showEditFormKindOfActivity(@PathVariable(name = "id") Long kindOfActivityId,
                                             Model model) {
        Catalog_KindOfActivityDto catalog_kindOfActivityDto = catalog_kindOfActivityService.findById(kindOfActivityId);
        model.addAttribute("catalog_kindOfActivityDto", catalog_kindOfActivityDto);
        return "catalog_kindOfActivityAddEdit";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteKindOfActivity(@PathVariable(name = "id") Long kindOfActivityId) {
        catalog_kindOfActivityService.deleteById(kindOfActivityId);
        return "redirect:/catalogKindOfActivity/page/1?sortField=titleKindOfActivity&sortDir=asc";
    }
}


