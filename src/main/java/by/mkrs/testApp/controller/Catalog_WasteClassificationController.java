package by.mkrs.testApp.controller;


import by.mkrs.testApp.dto.Catalog_ClassOfDangerDto;
import by.mkrs.testApp.dto.Catalog_DegreeOfDangerDto;
import by.mkrs.testApp.dto.Catalog_KindOfActivityDto;
import by.mkrs.testApp.dto.Catalog_WasteClassificationDto;
import by.mkrs.testApp.entity.Catalog_WasteClassification;
import by.mkrs.testApp.service.Catalog_ClassOfDangerService;
import by.mkrs.testApp.service.Catalog_DegreeOfDangerService;
import by.mkrs.testApp.service.Catalog_KindOfActivityService;
import by.mkrs.testApp.service.Catalog_WasteClassificationService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/catalogWasteClassification")
public class Catalog_WasteClassificationController {

    public static final int PAGE_SIZE = 5;
    private final Catalog_WasteClassificationService catalog_wasteClassificationService;
    private final Catalog_DegreeOfDangerService catalog_degreeOfDangerService;
    private final Catalog_ClassOfDangerService catalog_classOfDangerService;
    private final Catalog_KindOfActivityService catalog_kindOfActivityService;

    public Catalog_WasteClassificationController(Catalog_WasteClassificationService catalog_wasteClassificationService,
                                                 Catalog_DegreeOfDangerService catalog_degreeOfDangerService,
                                                 Catalog_ClassOfDangerService catalog_classOfDangerService,
                                                 Catalog_KindOfActivityService catalog_kindOfActivityService) {
        this.catalog_wasteClassificationService = catalog_wasteClassificationService;
        this.catalog_degreeOfDangerService = catalog_degreeOfDangerService;
        this.catalog_classOfDangerService = catalog_classOfDangerService;
        this.catalog_kindOfActivityService = catalog_kindOfActivityService;
    }

    @GetMapping("/page/{pageNumber}")
    public String findPaginated(@PathVariable(value = "pageNumber") int pageNumber,
                                Model model,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDirection") String sortDirection) {

//        List<Catalog_WasteClassificationDto> catalog_wasteClassificationDtoList=catalog_wasteClassificationService.listAll(pageNumber, PAGE_SIZE, sortField, sortDir);

        Page<Catalog_WasteClassification> page = catalog_wasteClassificationService.findPaginated(pageNumber, PAGE_SIZE, sortField, sortDirection);
        List<Catalog_WasteClassification> catalog_wasteClassificationDtoList = page.getContent();

        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
        model.addAttribute("catalog_wasteClassificationDtoList", catalog_wasteClassificationDtoList);
        return "catalog_wasteClassificationList";
    }

    @GetMapping("/listAll")
    public String listWasteClassification(Model model) {
        return findPaginated(1, model, "titleWasteClassification", "asc");
    }


    @GetMapping("/save")
    public String showCreateEditFormNewWasteClassification(Model model,
                                                           Catalog_WasteClassificationDto catalog_wasteClassificationDto) {
        model.addAttribute("catalog_degreeOfDangerDtoList", catalog_degreeOfDangerService.listAll());
        model.addAttribute("catalog_classOfDangerDtoList", catalog_classOfDangerService.listAll());
        model.addAttribute("catalog_kindOfActivityDtoList", catalog_kindOfActivityService.listAll());
        model.addAttribute("catalog_wasteClassificationDto", catalog_wasteClassificationDto);

        return "catalog_wasteClassificationAddEdit";
    }

    @PostMapping("/save")
    public String saveWasteClassification(@ModelAttribute("wasteClassification")  @Valid Catalog_WasteClassificationDto catalog_wasteClassificationDto,
                                          BindingResult bindingResult,
                                          @RequestParam(value ="idCatalogDegreeOfDanger",required = false)Long idCatalogDegreeOfDanger,
                                          @RequestParam(value ="idCatalogClassOfDanger",required = false) Long idCatalogClassOfDanger,
                                          @RequestParam(value ="idCatalogKindOfActivity",required = false) Long idCatalogKindOfActivity) {
        if (bindingResult.hasErrors()) {
            return "catalog_wasteClassificationAddEdit";
        }
        Catalog_DegreeOfDangerDto catalog_degreeOfDangerDto = catalog_degreeOfDangerService.findById(idCatalogDegreeOfDanger);
        Catalog_ClassOfDangerDto catalog_classOfDangerDto = catalog_classOfDangerService.findById(idCatalogClassOfDanger);
        Catalog_KindOfActivityDto catalog_kindOfActivityDto = catalog_kindOfActivityService.findById(idCatalogKindOfActivity);
        catalog_wasteClassificationDto.setCatalog_degreeOfDangerDto(catalog_degreeOfDangerDto);
        catalog_wasteClassificationDto.setCatalog_classOfDangerDto(catalog_classOfDangerDto);
        catalog_wasteClassificationDto.setCatalog_kindOfActivityDto(catalog_kindOfActivityDto);
        catalog_wasteClassificationService.addNew(catalog_wasteClassificationDto);
        return "redirect:/catalogWasteClassification/page/1?sortField=titleWasteClassification&sortDirection=asc";
    }

    @GetMapping("/edit/{id}")
    public String showEditFormWasteClassification(@PathVariable(name = "id") Long wasteClassificationId,
                                                  Model model) {
        model.addAttribute("catalog_degreeOfDangerDtoList", catalog_degreeOfDangerService.listAll());
        model.addAttribute("catalog_classOfDangerDtoList", catalog_classOfDangerService.listAll());
        model.addAttribute("catalog_kindOfActivityDtoList", catalog_kindOfActivityService.listAll());
        model.addAttribute("catalog_wasteClassificationDto", catalog_wasteClassificationService.findById(wasteClassificationId));
        return "catalog_wasteClassificationAddEdit";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteWasteClassification(@PathVariable(name = "id") Long wasteClassificationId) {
        catalog_wasteClassificationService.deleteById(wasteClassificationId);
        return "redirect:/catalogWasteClassification/page/1?sortField=titleWasteClassification&sortDirection=asc";
    }

}


