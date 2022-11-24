package com.burak.metro.controller;

import com.burak.metro.service.LineServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/lines")
public class LineController {

    private final LineServiceImpl lineService;

    @GetMapping("/red")
    public String redLineInfo(Model model) {
        String RED_LINE_TITLE = "Aŭtazavadskaja line";
        model.addAttribute("title", RED_LINE_TITLE);
        Double redLineCurrentTimeInterval = lineService.getRedLineCurrentTimeInterval();
        model.addAttribute("time_interval", redLineCurrentTimeInterval);
        Integer allTimeInterval = lineService.getRedLineByCurrentTime().getFullTimeInterval();
        model.addAttribute("all_time_interval", allTimeInterval);
        return "line-info";
    }

    @GetMapping("/blue")
    public String blueLineInfo(Model model) {
        String BLUE_LINE_TITLE = "Maskoŭskaja line";
        model.addAttribute("title", BLUE_LINE_TITLE);
        Double blueLineCurrentTimeInterval = lineService.getBlueLineCurrentTimeInterval();
        model.addAttribute("time_interval", blueLineCurrentTimeInterval);
        Integer allTimeInterval = lineService.getBlueLineByCurrentTime().getFullTimeInterval();
        model.addAttribute("all_time_interval", allTimeInterval);
        return "line-info";
    }

    @GetMapping("/green")
    public String greenLineInfo(Model model) {
        String GREEN_LINE_TITLE = "Zielienalužskaja line";
        model.addAttribute("title", GREEN_LINE_TITLE);
        Double greenLineCurrentTimeInterval = lineService.getGreenLineCurrentTimeInterval();
        model.addAttribute("time_interval", greenLineCurrentTimeInterval);
        Integer allTimeInterval = lineService.getGreenLineByCurrentTime().getFullTimeInterval();
        model.addAttribute("all_time_interval", allTimeInterval);
        return "line-info";
    }
}
