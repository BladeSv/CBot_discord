package by.mitrahovich.bot.config;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import by.mitrahovich.bot.utils.JsonHelper;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

@Configuration
@ComponentScan("by.mitrakhovich.discord.bot")
@PropertySource("classpath:config.properties")
public class AppConfig {

	@Value("${bot.token}")
	private String botToken;


	@Bean
	public JDA getJda() throws LoginException {
		JDA jda = new JDABuilder(botToken).build();
		return jda;

	}

	@Bean
	public JsonHelper getJsonHelper() {
		return new JsonHelper();

	}

}
