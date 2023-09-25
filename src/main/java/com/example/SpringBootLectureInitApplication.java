package com.example;

import com.example.config.MyConfig;
import com.example.config.MyConfigProto;
import com.example.ioc.Chef;
import com.example.ioc.IngredientFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLectureInitApplication {

	public static void main(String[] args) {
//		MyConfig myConfig1 = new MyConfig();
//		MyConfig myConfig2 = new MyConfig();
//		MyConfig myConfig3 = new MyConfig();
//
//		MyConfigProto myConfigProto1 = new MyConfigProto();
//		MyConfigProto myConfigProto2 = new MyConfigProto();
//		MyConfigProto myConfigProto3 = new MyConfigProto();
//
//		System.out.println(myConfig1);
//		System.out.println(myConfig2);
//		System.out.println(myConfig3);
//
//		System.out.println(myConfigProto1);
//		System.out.println(myConfigProto2);
//		System.out.println(myConfigProto3);

//		IngredientFactory ingredientFactory = new IngredientFactory();
//		Chef chef = new Chef(ingredientFactory);
//
//		String food = chef.cook("파전");
//		System.out.println(food);

		//스프링 부팅
		SpringApplication.run(SpringBootLectureInitApplication.class, args);
	}

}
