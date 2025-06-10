package com.enet.io.lppage.webapp.api;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.enet.io.lppage.core.domain.ThemeComponent;
import com.enet.io.lppage.core.service.ThemeService;
import com.enet.io.lppage.webapp.model.ContentComponent;
import java.util.List;

@RestController
@RequestMapping("/api/v0/theme")
public class ThemeV0Controller {
    private transient final Log log = LogFactory.getLog(getClass());

    @Autowired
    private ThemeService themeService;

    @RequestMapping(value ="/{theme}/get-components", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    List<ThemeComponent> components(@PathVariable("theme") String theme,
                                         @RequestParam(value = "comcode",required = false) String comcode,
                                         @RequestParam(value = "section",required = false) String section,
                                         @RequestParam(value = "tag",required = false) String tag) {
        List<ThemeComponent> components = themeService.findComponents(theme,comcode,section,tag,100);
        return components;
    }
    @RequestMapping(value ="/{theme}/get-component", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    ThemeComponent getComponent(@PathVariable("theme") String theme,
                                    @RequestParam(value = "cid") String cid) {
        ThemeComponent component = null;
        if (StringUtils.isNumeric(cid)) {
            ThemeComponent one = themeService.findComponentById(Long.valueOf(cid));
            if (one != null && one.getTheme().equals(theme)) {
                component = one;
            }
        } else {
            List<ThemeComponent> components = themeService.findComponents(theme,cid,null,null,1);
            if (components.size() > 0) {
                component = components.get(0);
            }
        }
        if (component == null) {
            component = new ThemeComponent();
            component.setThemecomponentid(-1l);
        }
        return component;
    }
}
