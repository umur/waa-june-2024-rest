package com.miu.lab2.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class Course {

	String id = UUID.randomUUID().toString();
	String name;
	String course;

}
