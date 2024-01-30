package com.example.BulletPoints;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BulletPointService {
	
	public List<BulletPoint> bulletPoints = new ArrayList();
	
	private static int bulletPointCount = 0;
	
	@Autowired
	private BulletPointRepository bulletPointRepository;
	
	public void save() {
		BulletPoint bp = new BulletPoint();
		bp.setDescription("sampleDescription");
		bp.setDone(false);
		bp.setUsername("Peter");
		bulletPointRepository.save(bp);
	}
	
	
	
	
	
}