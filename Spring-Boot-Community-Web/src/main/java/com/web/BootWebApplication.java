package com.web;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.web.domain.Board;
import com.web.domain.User;
import com.web.domain.enums.BoardType;
import com.web.repository.BoardRepository;
import com.web.repository.UserRepository;

@SpringBootApplication
public class BootWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(BootWebApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(UserRepository userRepository,
			BoardRepository boardRepository) throws Exception{
		return (args) -> {
			User user = userRepository.save(User.builder()
					.name("havi")
					.password("test")
					.email("havi@gmail.com")
					.createdDate(LocalDateTime.now())
					.build());
			IntStream.rangeClosed(1,  200).forEach(index ->
					boardRepository.save(Board.builder()
							.title("°Ô½Ã±Û"+index)
							.subTitle("¼ø¼­"+index)
							.content("ÄÜÅÙÃ÷")
							.boardType(BoardType.free)
							.createdDate(LocalDateTime.now())
							.updatedDate(LocalDateTime.now())
							.user(user).build())
					);
		};
	}
}
