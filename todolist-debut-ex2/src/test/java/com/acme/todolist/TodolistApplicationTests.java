package com.acme.todolist;

import com.acme.todolist.domain.TodoItem;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

class TodolistApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	void test_finalContent_NotLate() {
		Instant currentTime = Instant.now();
		TodoItem todoItem = new TodoItem("1",currentTime,"Test Object");
		String finalContent = todoItem.finalContent();
		assert(!finalContent.contains("[LATE!]"));
	}

	@Test
	void test_finalContent_Late() {
		Instant time = Instant.now().minus(1, ChronoUnit.DAYS);
		TodoItem todoItem = new TodoItem("1",time,"Test Object");
		String finalContent = todoItem.finalContent();
		assert(finalContent.contains("[LATE!]"));
	}
}
