package com.burak.metro.controller;

import com.burak.metro.model.RedLine;
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
        model.addAttribute("title", "Aŭtazavadskaja line");
        Double timeInterval = lineService.getRedLineByCurrentTime().getFridayDaysInterval();
        RedLine all_time = lineService.getRedLineByCurrentTime();

        model.addAttribute("time_interval", String.valueOf(timeInterval));
        model.addAttribute("all_time", String.valueOf(all_time.getFullTimeIntervalId().getFullTimeInterval()));
        return "line-info";
    }

    @GetMapping("/blue")
    public String blueLineInfo(Model model) {
        model.addAttribute("title", "Maskoŭskaja line");
        return "line-info";
    }

    @GetMapping("/green")
    public String greenLineInfo(Model model) {
        model.addAttribute("title", "Zielienalužskaja line");
        return "line-info";
    }
}
