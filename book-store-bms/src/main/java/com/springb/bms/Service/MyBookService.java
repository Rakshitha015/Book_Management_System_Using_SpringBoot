package com.springb.bms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springb.bms.Entity.MyBookList;
import com.springb.bms.repository.MyBookRepository;

@Service
public class MyBookService {

	@Autowired
	private MyBookRepository mybook;
	public void saveMyBooks(MyBookList book) {
		mybook.save(book);
	}
	public List<MyBookList> getAllMyBooks(){
		return mybook.findAll();
		}
	public void deleteById(int id)
	{
		mybook.deleteById(id);
	}
}
