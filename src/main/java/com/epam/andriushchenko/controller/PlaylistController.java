package com.epam.andriushchenko.controller;

import com.epam.andriushchenko.model.User;
import com.epam.andriushchenko.service.PlaylistService;
import com.epam.andriushchenko.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PlaylistController {
    @Inject
    private PlaylistService playlistService;
    @Inject
    private SongService songService;

    @RequestMapping(method = RequestMethod.GET, value = "/playlists")
    public String playlists(ModelMap modelMap) {
        modelMap.addAttribute("playlists", playlistService.getAll());
        return "playlists";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/playlists/addForm")
    public String addPlaylistForm() {
        return "addPlaylist";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/playlists/addForm/addPlaylist")
    public String addPlaylist(HttpServletRequest request) {
        String playlistName = request.getParameter("playlistName");
        User user = (User) request.getSession().getAttribute("user");
        return playlistService.add(playlistName, user.getId()) && playlistService.isExist(playlistName)
                ? "redirect:/playlists" : "/playlists/addForm";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/playlists/deletePlaylist")
    public String deletePlaylist(@RequestParam String playlistToDeleteName, ModelMap modelMap) {
        playlistService.delete(playlistToDeleteName);
        modelMap.addAttribute("playlists", playlistService.getAll());
        return "playlists";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/playlist/{playlistId}")
    public String getPlaylist(@PathVariable int playlistId, ModelMap modelMap) {
        modelMap.addAttribute("playlist", playlistService.getById(playlistId));
        modelMap.addAttribute("songs", songService.getAllFromPlaylist(playlistId));
        return "playlist";
    }
}
