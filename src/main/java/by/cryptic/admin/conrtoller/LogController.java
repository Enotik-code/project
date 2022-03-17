package by.cryptic.admin.conrtoller;

import by.cryptic.admin.logs.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@Slf4j
@RequestMapping("/logs")
public class LogController {

    public static final String ACTIONS = "actions";

    @Autowired
    public LogService logService;

    @GetMapping("/actions")
    public ModelAndView getActions() throws IOException {
        ModelAndView modelAndView = new ModelAndView("admin/logs/actions");
        modelAndView.addObject("currentSize", logService.getLogFileSize());
        modelAndView.addObject("currentPath", logService.getLogFilePath());
        modelAndView.addObject("currentName", logService.getLogFileName());
        log.info("Get logs actions");
        return modelAndView;
    }

    @GetMapping("/all")
    public ResponseEntity<String> log() {
        log.info("Get logs");
        return new ResponseEntity<>(logService.getLogs(), HttpStatus.OK);
    }

    @GetMapping("/clear")
    public String clearLog() {
        log.info("Clear logs");
        return logService.clearLogs();
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadLog() {
        log.info("Download logs");
        return logService.downloadLogs();
    }

}
