package com.springb.bms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springb.bms.Entity.BookEntity;
import com.springb.bms.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bRepo;
	
	public void save(BookEntity b) {
		bRepo.save(b);
	}
	public List<BookEntity> getAllBook()
	{
		return bRepo.findAll();
		
	}
	public BookEntity getBookById(int id) {
		return bRepo.findById(id).get();
	}
	public void deleteById(int id)
	{
		bRepo.deleteById(id);
	}

}
