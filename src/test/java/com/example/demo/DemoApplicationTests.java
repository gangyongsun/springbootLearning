package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	// 使用 @Commit 注解来显式指定在测试方法执行完成后提交事务，而不是自动回滚
	@Commit
	public void createUserTest() {
		User user = new User();
		user.setUserId("10004");
		user.setNickName("王五asdf");
		user.setPassword("123456");

		int id = userService.createUser(user);
		System.out.println("--------------" + id);

		// 测试完成后，通过手动设置回滚来确保数据库中的数据不被保留
		// TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

		assertNotNull(id, "用户创建失败");
		assertNotNull(user.getUserId(), "用户UserID未设置");

		// 验证从数据库中获取用户
		User savedUser = userService.selectByPrimaryKey(23);
		assertNotNull(savedUser, "从数据库中获取用户失败");
		assertEquals("10001", savedUser.getUserId(), "用户ID不匹配");
		assertEquals("张三", savedUser.getNickName(), "用户昵称不匹配");
	}

}
