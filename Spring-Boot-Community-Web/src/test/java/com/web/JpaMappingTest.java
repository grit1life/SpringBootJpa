package com.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.web.domain.Board;
import com.web.domain.User;
import com.web.domain.enums.BoardType;
import com.web.repository.BoardRepository;
import com.web.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class JpaMappingTest {
	private final String boardTestTitle = "�׽�Ʈ";
	private final String email = "test@gmail.com";
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BoardRepository boardRepository;

	@BeforeEach
	public void init() {
		User user = userRepository.save(User.builder()
				.name("havi")
				.password("test")
				.email(email)
				.createdDate(LocalDateTime.now())
				.build());
		boardRepository.save(Board.builder()
				.title(boardTestTitle)
				.subTitle("���� Ÿ��Ʋ")
				.content("������")
				.boardType(BoardType.free)
				.createdDate(LocalDateTime.now())
				.updatedDate(LocalDateTime.now())
				.user(user).build());
	}
	
	@Test
	public void �����_�����ƴ���_�׽�Ʈ() {
		User user = userRepository.findByEmail(email);
		assertEquals(user.getName(), "havi");
		assertEquals(user.getPassword(), "test");
		assertEquals(user.getEmail(), email);
		
		Board board = boardRepository.findByUser(user);
		assertEquals(board.getTitle(), boardTestTitle);
		assertEquals(board.getSubTitle(), "���� Ÿ��Ʋ");
		assertEquals(board.getContent(), "������");
		assertEquals(board.getBoardType(), BoardType.free);
		
	}
}
