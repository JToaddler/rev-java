package com.madlabs.rev.java8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madlabs.rev.java8.dao.WorldDao;
import com.madlabs.rev.java8.modal.World;

@Service
public class WorldService {

	@Autowired
	WorldDao worldDao;

	public void getWolrd() {
		List<World> worldList = worldDao.getWorldList();
		System.out.println(worldList.size());
	}

}
