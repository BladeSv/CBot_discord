package by.mitrahovich.bot.controller;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogOutConroller {

	@Value("${logging.file.name}")
	private String logfile;

	@RequestMapping("/log")
	public String getLog() throws IOException {

		String log;

		FileInputStream fis = new FileInputStream(logfile);

		log = IOUtils.toString(fis, "UTF-8");

		String partLog = log.substring((log.length() - 10000), log.length());
		return partLog;

	}
}
