package by.cryptic.admin.logs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LogService {

    private final Path logPath = Paths.get("log/cryptic.log");

    private List<String> getLogsFromFile() {
        List<String> logs = new ArrayList<>();

        try {
            return Files.readAllLines(logPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logs;
    }

    public String getLogFileSize() throws IOException {
        return Files.size(logPath) + " bytes";
    }

    public String getLogFileName() {
        return logPath.getFileName().toString();
    }

    public String getLogFilePath() {
        return logPath.toUri().toString();
    }

    public ResponseEntity<byte[]> downloadLogs() {
        String result = getLogs();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);
        httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment().filename("logs.txt").build().toString());
        return ResponseEntity.ok().headers(httpHeaders).body(result.getBytes());
    }


    public String clearLogs() {
        try {
            BufferedWriter writer = Files.newBufferedWriter(logPath);
            writer.write("");
            writer.flush();
            return "admin/logs/success";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fail";
    }

    public String getLogs() {
       List<String> logs = getLogsFromFile();
       StringBuilder result = new StringBuilder();
       logs.forEach(log -> result.append(log).append("\n"));
       return result.toString();
    }


}
