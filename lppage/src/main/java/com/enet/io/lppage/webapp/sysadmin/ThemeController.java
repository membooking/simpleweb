package com.enet.io.lppage.webapp.sysadmin;

import com.enet.io.lppage.core.domain.ThemeComponent;
import com.enet.io.lppage.core.service.ThemeService;
import com.enet.io.lppage.webapp.model.ContentComponent;
import com.enet.io.lppage.webapp.util.ObjectMapperUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.*;

@Controller
@RequestMapping("/sysadmin")
public class ThemeController {
    private transient final Logger log = Logger.getLogger(getClass());
    @Autowired
    private ThemeService themeService;

    @RequestMapping(value="/theme/{theme}/components", method = RequestMethod.GET)
    public ModelAndView components(@PathVariable("theme") String theme,
                                @RequestParam(value = "comcode",required = false) String comcode,
                                @RequestParam(value = "section",required = false) String section,
                                @RequestParam(value = "tag",required = false) String tag) {
        ModelAndView mav = new ModelAndView("sysadmin/theme-components");
        List<ThemeComponent> components = themeService.findComponents(theme,comcode,section,tag,100);
        mav.addObject("components",components);
        mav.addObject("theme",theme);
        String destFolder = "static/files/themes/"+theme;
        String base64_encoded_path = new String(Base64.getEncoder().encode(destFolder.getBytes()));
        mav.addObject("base64_encoded_path",base64_encoded_path);
        return mav;
    }

    @RequestMapping(value ="/theme/{theme}/save-component", method = RequestMethod.POST)
    public String saveComponent(@PathVariable("theme") String theme,
                                       @ModelAttribute("themeComponent") ThemeComponent themeComponent) {
        if (themeComponent.getThemecomponentid() != null && themeComponent.getThemecomponentid() > 0) {
            ThemeComponent old = themeService.findComponentById(themeComponent.getThemecomponentid());
            old.setContent(themeComponent.getContent());
            old.setTags(themeComponent.getTags());
            old.setSection(themeComponent.getSection());
            themeService.saveThemeComponent(old);
        } else {
            themeComponent.setThemecomponentid(null);
            themeComponent.setTheme(theme);
            themeComponent.setLastupdate(new Timestamp(System.currentTimeMillis()));
            themeComponent = themeService.saveThemeComponent(themeComponent);
        }
        return "redirect:/sysadmin/themes";
    }

    @RequestMapping(value="/theme/{theme}/view-page", method = RequestMethod.GET)
    public ModelAndView viewPage(@PathVariable("theme") String theme,
                                   @RequestParam(value = "tag") String tag) {
        ModelAndView mav = new ModelAndView("sysadmin/theme-view-page");
        tag = "#" + tag;
        List<ThemeComponent> components = themeService.findPageComponents(theme,tag);
        mav.addObject("components",components);
        mav.addObject("theme",theme);
        return mav;
    }

    @RequestMapping(value ="/theme/{theme}/sync-component", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    ContentComponent syncComponent(@RequestBody ContentComponent themeComponent, @PathVariable("theme") String theme) {
        if (StringUtils.isNotEmpty(themeComponent.getCode()) && StringUtils.isNotEmpty(themeComponent.getSection())) {
            ThemeComponent theComponent = themeService.findComponentByCode(theme,themeComponent.getCode());
            if (theComponent == null) {
                theComponent = new ThemeComponent();
                theComponent.setTheme(theme);
                theComponent.setCode(themeComponent.getCode());
            }
            theComponent.setContent(themeComponent.getContent());
            theComponent.setTags(themeComponent.getTags());
            theComponent.setSection(themeComponent.getSection());
            if (themeComponent.getData() != null) {
                theComponent.setJdata(ObjectMapperUtil.toJsonString(themeComponent.getData()));
            }
            theComponent = themeService.saveThemeComponent(theComponent);
            themeComponent.setThemecomponentid(themeComponent.getThemecomponentid());
        }
        return themeComponent;
    }


}
