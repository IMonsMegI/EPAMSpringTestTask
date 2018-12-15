package com.epam.andriushchenko.controller;

import com.epam.andriushchenko.service.PlaylistService;
import com.epam.andriushchenko.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

@Controller
public class SongController {
    @Inject
    private PlaylistService playlistService;
    @Inject
    private SongService songService;

    @RequestMapping(method = RequestMethod.GET, value = "/addSongToPlaylist/{songId}")
    public String addSongToPlaylist(@PathVariable int songId, ModelMap modelMap, @RequestParam int playlistId) {
        modelMap.addAttribute("playlists", playlistService.getAll());
        modelMap.addAttribute("songs", songService.getAll());
        songService.addToPlaylist(playlistId, songId);
        return "redirect:/";
    }
}
