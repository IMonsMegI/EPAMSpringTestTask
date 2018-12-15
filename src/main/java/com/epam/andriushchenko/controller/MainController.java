package com.epam.andriushchenko.controller;

import com.epam.andriushchenko.service.PlaylistService;
import com.epam.andriushchenko.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
public class MainController {
    @Inject
    private PlaylistService playlistService;
    @Inject
    private SongService songService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String getIndex(ModelMap modelMap) {
        modelMap.addAttribute("songs", songService.getAll());
        modelMap.addAttribute("playlists", playlistService.getAll());
        return "index";
    }
}
