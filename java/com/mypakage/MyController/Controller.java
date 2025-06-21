package com.mypakage.MyController;

import java.security.Principal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mypakage.DAO.NotesRepo;
import com.mypakage.Entity.Notes;
import com.mypakage.Helper.Message;
import com.mypakage.Service.NotesServices;

import jakarta.servlet.http.HttpSession;


@org.springframework.stereotype.Controller
public class Controller {

   
	@Autowired
  private NotesRepo notesRepo;
	
	@Autowired
	private NotesServices notesServices;  //  if we need use service 
	


	// home page 
	@GetMapping("/")
	public String Home(org.springframework.ui.Model model) {
		
		model.addAttribute("title", "HOME - NoteTaker");
		
		return "home";
	}

	
	// Add Notes page opener 
	@GetMapping("/AddNotes")
	public String Addnotes(org.springframework.ui.Model model) {
		model.addAttribute("title", "AddNotes-Notetaker");
		
		return "AddNotes";
	}
	
	

	//Save/Add  Notes  process handler 
	
		@PostMapping("/Process_SaveNotes")
		public String SaveNotes(@ModelAttribute("note") Notes Notes ,Principal principal, HttpSession session) {
			
			try {
				
			
				Notes.setAddeddate(new Date(0));
				
			System.out.println("Notes"+ Notes);
	if(	this.notesRepo.save(Notes) != null) {
		
		session.setAttribute("message", new Message("Note Saved Successfully....","alert-success"));
	}
				
			} catch (Exception e) {
			 e.printStackTrace();
			 session.setAttribute("message", new Message("Failed to Save Note...","alert-danger"));
			}
			
			return "redirect:/AddNotes";
		}
	
		
		
	
	//show All notes handler 
	 
	@GetMapping("/ShowNotes")
	public String shownotes(  @ModelAttribute Notes notes,   org.springframework.ui.Model model) {
		model.addAttribute("title", "ShowNotes");
		
		List<Notes> Allnotes=this.notesRepo.findAll();
		
		model.addAttribute("getAllNotes", Allnotes);
		
		

		return "ShowNotes";
	}
	
	
	
	
	
	// update form open handler  onclick update in show notes
	@RequestMapping("/update/{id}")
	public String  OnClickupdateNotes(@PathVariable("id")Integer id , Model model) {
		  model.addAttribute("title","Update-Notes");
	
	Optional<Notes> optionalnote=this.notesRepo.findById(id);
		Notes note= optionalnote.get();
	     model.addAttribute("note", note);
		
		return"update";
	}
	
	
	//Notes  update process
	@PostMapping("/process_UpdateNotes")
	public String updateNotesFormProcess(@ModelAttribute Notes notes , Model model,HttpSession session ) {
		
		model.addAttribute("title","Update-Note");
		
		
		System.out.println(notes.getId() +" "+ notes.getTitle() +" "+ notes.getContent());
		notes.setAddeddate(new Date(0));
	//	Notes oldNote= this.notesRepo.findById(notes.getId()).get();
		
	if(	this.notesRepo.save(notes) != null) {
		
		
		session.setAttribute("message", new Message("Note Updated Successfully....","alert-success"));
		
	}
	else {
		session.setAttribute("message", new Message("Updation failed !!q....","alert-danger"));
		
	}
		
		return "redirect:/ShowNotes";
		
	
	}
	
	
// Delete Notes 
	@GetMapping("/delete/{id}")
	public String deleteNotes(@PathVariable("id") Integer id) {
		
		this.notesRepo.deleteById(id);
		
		return "redirect:/ShowNotes";
		
		
	}
	
	
	
	
	
	
	
	

	

}
