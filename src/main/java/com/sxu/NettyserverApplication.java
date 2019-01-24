package com.sxu;

import com.sxu.server.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyserverApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NettyserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		new Server(8081).start();
	}
}

