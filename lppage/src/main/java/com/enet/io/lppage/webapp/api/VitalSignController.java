package com.enet.io.lppage.webapp.api;


import com.enet.io.lppage.webapp.model.VstRequest;
import com.enet.io.lppage.webapp.model.VstmConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v0/vital-sign")
public class VitalSignController {
    private transient final Log log = LogFactory.getLog(getClass());
    private VstmConfig vstmConfig = new VstmConfig();

    private RestTemplate template = null;

    @RequestMapping(value ="/request-vital-sign", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    String requestVitalSign(@PathVariable("vst") String vst,
                                         @RequestParam(value = "serialnumber") String serialnumber) {
        String url = vstmConfig.getVstm_endpoint() + "/api/pub/dkmdr/request-vital-sign";
        VstRequest vstRequest = new VstRequest();
        vstRequest.setSerialnumber(serialnumber);
        vstRequest.setReqid(""+System.currentTimeMillis());
        Long time = System.currentTimeMillis() / 1000;
        vstRequest.setTime(""+time);
        vstRequest.setPatientid("0000ABCD");
        vstRequest.setFullname("Nguyen Van A");
        vstRequest.setVitalsign(vst);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + vstmConfig.getVstm_access_token());
        HttpEntity<VstRequest> request = new HttpEntity<>(vstRequest,headers);
        ResponseEntity<String> result = getTemplate().postForEntity(url, request, String.class);
        return result.getBody();
    }

    public RestTemplate getTemplate() {
        if (template == null) {
            template = new RestTemplate();
        }
        return template;
    }
}
