package com.springb.bms.Controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springb.bms.Entity.BookEntity;
import com.springb.bms.Entity.MyBookList;
import com.springb.bms.Service.BookService;
import com.springb.bms.Service.MyBookService;

@Controller
public class BookController {
	
		@Autowired
		private BookService service;
		
		@Autowired
		private MyBookService mybookservice;
	
		@GetMapping("/")
		public String home()
		{
			return "home";
		}
		@GetMapping("/book_register")
		public String bookRegister() {
			return "bookRegister"; 
			
		}
		@GetMapping("/available_books")
		public ModelAndView getAllBook() {
			List<BookEntity>list = service.getAllBook();
//			ModelAndView m=new ModelAndView();
//			m.setViewName("bookList");
//			m.addObject("book",list);
			
			
			return new ModelAndView("bookList","book",list);
			
			
		}
		
		@PostMapping("/save")
		public String addBook(@ModelAttribute BookEntity b)
		{
			service.save(b);
			return "redirect:/available_books";
			
		}
		@GetMapping("/my_books")
		public String getMyBooks(Model model) {
			List<MyBookList>list = mybookservice.getAllMyBooks();
			
			model.addAttribute("book",list);
			return "myBooks";
		}
		@RequestMapping("/mylist/{id}")
		public String getMyList(@PathVariable("id") int id) {
			BookEntity b=service.getBookById(id);
			MyBookList mb = new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
			mybookservice.saveMyBooks(mb);
			return "redirect:/my_books";
		}
		
		@RequestMapping("/deleteMyList/{id}")
		public String DeleteMyList(@PathVariable("id") int id) {
			mybookservice.deleteById(id);
			return "redirect:/my_books";
			
		}
		@RequestMapping("/editbook/{id}")
		public String editbook(@PathVariable("id") int id, Model model) {
			BookEntity b = service.getBookById(id);
			model.addAttribute("book",b);
			return "bookEdit";
		}
		@RequestMapping("/deletebook/{id}")
		public String deleteBook(@PathVariable("id") int id)
		{
			service.deleteById(id);
			return "redirect:/available_books";
		}
		
	

}
