package com.example.BulletPoints;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/bulletPoint")
public class BulletPointController {
	
	@Autowired
	BulletPointService bs;
	
	@Autowired
	BulletPointRepository bulletPointRepository;
	
	@GetMapping("/save")
	public String save() {
		bs.save();
		return "success";
	}
	
	@GetMapping("/findAll")
	public List<BulletPoint> getAll() {		
		return bulletPointRepository.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Optional<BulletPoint> findById(@PathVariable String id) {
		return bulletPointRepository.findById(Long.decode(id));
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable String id)
	{
		bulletPointRepository.deleteById(Long.decode(id));
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/createNewBulletPoint/{username}")
	public BulletPoint createNewBulletPoint(@PathVariable String username,@RequestBody BulletPoint bulletPoint) {
		bulletPoint.setUsername(username);
		return bulletPointRepository.save(bulletPoint);
	}
	
	@PutMapping("/updateBulletPoint/{id}")
	public BulletPoint updateBulletPoint(@PathVariable String id,@RequestBody BulletPoint newBulletPoint) {
		BulletPoint bulletPointObj =  bulletPointRepository.findById(Long.decode(id)).get();
		bulletPointRepository.delete(bulletPointObj);
		return bulletPointRepository.save(newBulletPoint);
	}
	
}
