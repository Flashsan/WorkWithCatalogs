package by.mkrs.testApp.controller;

import by.mkrs.testApp.dto.Catalog_ClassOfDangerDto;
import by.mkrs.testApp.dto.Catalog_DegreeOfDangerDto;
import by.mkrs.testApp.entity.Catalog_ClassOfDanger;
import by.mkrs.testApp.entity.Catalog_DegreeOfDanger;
import by.mkrs.testApp.service.Catalog_ClassOfDangerService;
import by.mkrs.testApp.service.Catalog_DegreeOfDangerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/catalogClassOfDanger")
@RequiredArgsConstructor
public class Catalog_ClassOfDangerController {

    private final Catalog_ClassOfDangerService catalog_classOfDangerService;

    @GetMapping("/page/{pageNumber}")
    public String findPaginated(@PathVariable(value="pageNumber") int pageNumber,
                                Model model,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir){
        int pageSize=5;

        Page<Catalog_ClassOfDanger> page = catalog_classOfDangerService.findPaginated(pageNumber, pageSize, sortField, sortDir);
        List<Catalog_ClassOfDanger> catalog_classOfDangerDtoList=page.getContent();

        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc")?"desc":"asc");
        model.addAttribute("catalog_classOfDangerDtoList", catalog_classOfDangerDtoList);
        return "catalog_classOfDangerList";
    }

    @GetMapping("/listAll")
    public String listClassOfDanger(Model model) {
        return findPaginated(1,model,"titleClassOfDanger","asc");
    }

    @GetMapping("/save")
    public String showCreateEditFormNewClassOfDanger(Model model,
                                                      Catalog_ClassOfDangerDto catalog_classOfDangerDto) {
        model.addAttribute("catalog_classOfDangerDto", catalog_classOfDangerDto);
        return "catalog_classOfDangerAddEdit";
    }

    @PostMapping("/save")
    public String saveClassOfDanger(@ModelAttribute("classOfDanger")
                                     @Valid Catalog_ClassOfDangerDto catalog_classOfDangerDto,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "catalog_classOfDangerAddEdit";
        }
        catalog_classOfDangerService.addNew(catalog_classOfDangerDto);
        return "redirect:/catalogClassOfDanger/page/1?sortField=titleClassOfDanger&sortDir=asc";
    }

    @GetMapping("/edit/{id}")
    public String showEditFormClassOfDanger(@PathVariable(name = "id") Long classOfDangerId,
                                             Model model) {
        Catalog_ClassOfDangerDto catalog_classOfDangerDto = catalog_classOfDangerService.findById(classOfDangerId);
        model.addAttribute("catalog_classOfDangerDto", catalog_classOfDangerDto);
        return "catalog_classOfDangerAddEdit";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteClassOfDanger(@PathVariable(name = "id") Long classOfDangerId) {
        catalog_classOfDangerService.deleteById(classOfDangerId);
        return "redirect:/catalogClassOfDanger/page/1?sortField=titleClassOfDanger&sortDir=asc";
    }
}


