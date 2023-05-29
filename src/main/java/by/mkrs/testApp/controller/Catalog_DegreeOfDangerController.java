package by.mkrs.testApp.controller;


import by.mkrs.testApp.dto.Catalog_DegreeOfDangerDto;
import by.mkrs.testApp.entity.Catalog_DegreeOfDanger;
import by.mkrs.testApp.entity.Catalog_KindOfActivity;
import by.mkrs.testApp.service.Catalog_DegreeOfDangerService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/catalogDegreeOfDanger")
public class Catalog_DegreeOfDangerController {

    private final Catalog_DegreeOfDangerService catalog_degreeOfDangerService;

    public Catalog_DegreeOfDangerController(Catalog_DegreeOfDangerService catalog_degreeOfDangerService) {
        this.catalog_degreeOfDangerService = catalog_degreeOfDangerService;
    }

    @GetMapping("/page/{pageNumber}")
    public String findPaginated(@PathVariable(value="pageNumber") int pageNumber,
                                Model model,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir){
        int pageSize=5;

        Page<Catalog_DegreeOfDanger> page = catalog_degreeOfDangerService.findPaginated(pageNumber, pageSize, sortField, sortDir);
        List<Catalog_DegreeOfDanger> catalog_degreeOfDangerDtoList=page.getContent();

        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc")?"desc":"asc");
        model.addAttribute("catalog_degreeOfDangerDtoList", catalog_degreeOfDangerDtoList);
        return "catalog_degreeOfDangerList";
    }

    @GetMapping("/listAll")
    public String listDegreeOfDanger(Model model) {
        return findPaginated(1,model,"titleDegreeOfDanger","asc");
    }

    @GetMapping("/save")
    public String showCreateEditFormNewDegreeOfDanger(Model model,
                                                      Catalog_DegreeOfDangerDto catalog_degreeOfDangerDto) {
        model.addAttribute("catalog_degreeOfDangerDto", catalog_degreeOfDangerDto);
        return "catalog_degreeOfDangerAddEdit";
    }

    @PostMapping("/save")
    public String saveDegreeOfDanger(@ModelAttribute("degreeOfDanger")
                                     @Valid Catalog_DegreeOfDangerDto catalog_degreeOfDangerDto,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "catalog_degreeOfDangerAddEdit";
        }
        catalog_degreeOfDangerService.addNew(catalog_degreeOfDangerDto);
        return "redirect:/catalogDegreeOfDanger/page/1?sortField=titleDegreeOfDanger&sortDir=asc";
    }

    @GetMapping("/edit/{id}")
    public String showEditFormDegreeOfDanger(@PathVariable(name = "id") Long degreeOfDangerId,
                                             Model model) {
        Catalog_DegreeOfDangerDto catalog_degreeOfDangerDto = catalog_degreeOfDangerService.findById(degreeOfDangerId);
        model.addAttribute("catalog_degreeOfDangerDto", catalog_degreeOfDangerDto);
        return "catalog_degreeOfDangerAddEdit";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteDegreeOfDanger(@PathVariable(name = "id") Long degreeOfDangerId) {
        catalog_degreeOfDangerService.deleteById(degreeOfDangerId);
        return "redirect:/catalogDegreeOfDanger/page/1?sortField=titleDegreeOfDanger&sortDir=asc";
    }
}


